package CsvParserAPI;

import com.univocity.parsers.common.*;
import com.univocity.parsers.common.processor.*;
import com.univocity.parsers.common.record.*;
import com.univocity.parsers.conversions.*;
import com.univocity.parsers.csv.*;

import de.siegmar.fastcsv.reader.CsvReader;
import de.siegmar.fastcsv.reader.CsvContainer;
import de.siegmar.fastcsv.reader.CsvParser;
import de.siegmar.fastcsv.reader.CsvRow;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;


/* This class is responsible for reading large .csv files.
 * 
 * Entire file is not processed, the FileRead class accounts for every few hundred lines of data
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
	
	static long startTime = System.currentTimeMillis();
	private static long total = 0;
	long elapsedTime = System.currentTimeMillis() - startTime;
	private static final Pattern FIELD_DELIMETER_PATTERN = Pattern.compile("\\^\\|\\^");	
	
	
	public Reader getReader(String relativePath) throws UnsupportedEncodingException {
		try {
			return new InputStreamReader(FileReader.class.getResourceAsStream(relativePath), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new IllegalStateException("Unable to read input", e);
		}
	}

	/*
	*  Using this parser throws NullPointerExpression
	*
	*
	
	public void univocityParserIterative(InputStream path) throws UnsupportedEncodingException {
		CsvParserSettings settings = new CsvParserSettings();
		settings.getFormat().setLineSeparator("\n");
		CsvParser parser = new CsvParser(settings);
		String[] row;
		parser.beginParsing(path);
		while ((row = parser.parseNext()) != null) {
			System.out.println(row.length);
		}
	}
	
	public void univocityParserAtOnce(String path) throws Exception {
		CsvParserSettings settings = new CsvParserSettings();
		settings.getFormat().setLineSeparator("\n");
		CsvParser parser = new CsvParser(settings);
		List<String[]> allRows = parser.parseAll(getReader(path));
	}
	
	public void univocitySimple(String path) throws Exception {
		StringBuilder out = new StringBuilder();
		CsvParserSettings settings = new CsvParserSettings();
		settings.getFormat().setLineSeparator("\n");
		CsvParser parser = new CsvParser(settings);
		parser.beginParsing(getReader(path));
		String[] row;
		while ((row = parser.parseNext()) != null) {
			System.out.println(out);
		}
		
		parser.stopParsing();

	}
	
	*/
	
	
	/* Only Working Parser at the moment
	 * Using complete-distilled-sorted.csv
	 * 1st attempt with % 5 = 8.2132 m
	 * 2nd attempt with % 3 = 6.7771 m
	 * 3rd attempt with % 3 = 
	 */
	
	public void fastCsv(String filePath) { 
		
		ArrayList<HashMap<String,String>> ArrayL = new ArrayList<>();
		HashMap<String,String> Hash = new HashMap<>();
		File file = new File(filePath);
		CsvReader csvReader = new CsvReader();
		int linecounter = 1;

		try (CsvParser csvParser = csvReader.parse(file, StandardCharsets.UTF_8)) {
		    CsvRow row;
		    while ((row = csvParser.nextRow()) != null) {
		    	if ((linecounter % 3) > 0 ) {
		        // System.out.println("Read line: " + row);
		        //System.out.println("First column of line: " + row.getField(0));
		    	System.out.println(row);
		    	Hash.clear();
		    	Hash.put("File Extenstion", row.getField(0)); // Change to file ext index
		    	Hash.put("Job ID", row.getField(4)); // Change this to job ID
		    	ArrayL.add(Hash);
		    	
		    	}
		    linecounter ++;
		    }
		    System.out.println("Execution Time in ms: " + elapsedTime);
			csvParser.close();
			} catch (IOException e) {
				e.printStackTrace();
		}
	} 
	
	public void fastCsvAtOnce(String path) throws IOException {
		File file = new File(path);
		CsvReader csvReader = new CsvReader();

		CsvContainer csv = csvReader.read(file, StandardCharsets.UTF_8);
		for (CsvRow row : csv.getRows()) {
		    System.out.println("Read line: " + row);
		    System.out.println("First column of line: " + row.getField(0));
		}
	}
	
	
	
	public void usingCustBuffReader() throws FileNotFoundException, IOException {
		try (CustomBufferedReader data = new CustomBufferedReader(new FileReader(new File(this.getClass().getResource("E:\\complete-distilled-sorted.csv").getPath())))) {;
		String s;
				while ((s = data.readLine()) != null) {
					String [] fields = FIELD_DELIMETER_PATTERN.split(s, 0);
					total += fields.length;
					long elapsedTime = System.currentTimeMillis() - startTime;
					System.out.println("Execution Time in ms:" + elapsedTime);
					data.close();
				}
			
	} catch (Exception e) {
		System.err.println("Error");
		}
	}
    
    
}
	

