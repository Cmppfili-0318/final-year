package FinalYearProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Pattern;

import de.siegmar.fastcsv.reader.CsvParser;
import de.siegmar.fastcsv.reader.CsvReader;
import de.siegmar.fastcsv.reader.CsvRow;
import org.simpleflatmapper.csv.*;

/* This class is responsible for reading large .csv files.
 * 
 * Entire file is not processed, the FileReader accounts for every few hundred lines of data
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */



public class FileRead {
	
	//File file = new File(SimpleFlatMapper_csvParser.class.getClassLoader().getResource("E:\\complete-distilled-2.csv").getFile());
	static String filePath;
	static long startTime = System.currentTimeMillis();
	private static long total = 0;
	//private static String regex = "\\^\\|\\";
	//private static final Pattern FIELD_DELIMETER_PATTERN = Pattern.compile(regex);	
	
	FileRead(String path) {
		filePath = path;
	}

	public void fastCsv() { 
		File file = new File(filePath);
		CsvReader csvReader = new CsvReader();
		int linecounter = 1;

		try (CsvParser csvParser = csvReader.parse(file, StandardCharsets.UTF_8)) {
		    CsvRow row;
		    while ((row = csvParser.nextRow()) != null) {
		    	if ((linecounter % 500) > 0 ) {
		        // System.out.println("Read line: " + row);
		        //System.out.println("First column of line: " + row.getField(0));
		    	System.out.println(row);
		    	}
		    linecounter ++;
		    }
		    long elapsedTime = System.currentTimeMillis() - startTime;
			System.out.println("Execution Time in ms: " + elapsedTime);
			csvParser.close();
			} catch (IOException e) {
				e.printStackTrace();
		}
	}
	
	public void FileReadSimpleFlatMapper() throws FileNotFoundException, IOException {
		File file = new File(SimpleFlatMapper_csvParser.class.getClassLoader().getResource("E:\\complete-distilled-2.csv").getFile());
	     // Callback
        CsvParser
                .forEach(file, row -> System.out.println(Arrays.toString(row)));
		
	}
	
	public static Iterable<String[]> parseCSV(final InputStream stream) throws IOException {
	    return new Iterable<String[]>() {
	        @Override
	        public Iterator<String[]> iterator() {
	            return new Iterator<String[]>() {
	                static final int UNCALCULATED = 0;
	                static final int READY = 1;
	                static final int FINISHED = 2;
	                int state = UNCALCULATED;
	                ArrayList<String> value_list = new ArrayList<>();
	                StringBuilder sb = new StringBuilder();
	                String[] return_value;

	                public void end() {
	                    end_part();
	                    return_value = new String[value_list.size()];
	                    value_list.toArray(return_value);
	                    value_list.clear();
	                }

	                public void end_part() {
	                    value_list.add(sb.toString());
	                    sb.setLength(0);
	                }

	                public void append(int ch) {
	                    sb.append((char) ch);
	                }

	                public void calculate() throws IOException {
	                    boolean inquote = false;
	                    while (true) {
	                        int ch = stream.read();
	                        switch (ch) {
	                            default: //regular character.
	                                append(ch);
	                                break;
	                            case -1: //read has reached the end.
	                                if ((sb.length() == 0) && (value_list.isEmpty())) {
	                                    state = FINISHED;
	                                } else {
	                                    end();
	                                    state = READY;
	                                }
	                                return;
	                            case '\r':
	                            case '\n': //end of line.
	                                if (inquote) {
	                                    append(ch);
	                                } else {
	                                    end();
	                                    state = READY;
	                                    return;
	                                }
	                                break;
	                            case ',': //comma
	                                if (inquote) {
	                                    append(ch);
	                                } else {
	                                    end_part();
	                                    break;
	                                }
	                                break;
	                            case '"': //quote.
	                                inquote = !inquote;
	                                break;
	                        }
	                    }
	                }

	                @Override
	                public boolean hasNext() {
	                    if (state == UNCALCULATED) {
	                        try {
	                            calculate();
	                        } catch (IOException ex) {
	                        }
	                    }
	                    return state == READY;
	                }

	                @Override
	                public String[] next() {
	                    if (state == UNCALCULATED) {
	                        try {
	                            calculate();
	                        } catch (IOException ex) {
	                        }
	                    }
	                    state = UNCALCULATED;
	                    return return_value;
	                }
	            };
	        }
	    };
	}
}	

