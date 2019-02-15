package CsvParserAPI;

import com.univocity.parsers.common.*;
import com.univocity.parsers.common.processor.*;
import com.univocity.parsers.common.record.*;
import com.univocity.parsers.conversions.*;
import com.univocity.parsers.csv.*;

import de.siegmar.fastcsv.reader.CsvParser;
import de.siegmar.fastcsv.reader.CsvReader;
import de.siegmar.fastcsv.reader.CsvRow;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;


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


public class FileReader {
	
	static String filePath;
	static long startTime = System.currentTimeMillis();
	private static long total = 0;
	//private static final Pattern FIELD_DELIMETER_PATTERN = Pattern.compile("\\^\\|\\");	
	
	FileReader(String file) {
		filePath = file;
	}
	
	/*
	public Reader getReader(String relativePath) throws UnsupportedEncodingException {
		try {
			return new InputStreamReader(FileReader.class.getResourceAsStream(relativePath), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new IllegalStateException("Unable to read input", e);
		}
	}

	
	 * Using this parser throws NullPointerExpression syntax
	 * 
	public void csvParser() throws UnsupportedEncodingException {
		CsvParserSettings settings = new CsvParserSettings();
		settings.getFormat().setLineSeparator("\n");
		CsvParser parser = new CsvParser(settings);
		List<String[]> allRows = parser.parseAll(getReader("E:\\complete-distilled-2.csv"));
		//printAndValidate(null, allRows);
	}*/
	
	
	/* Only Working Parser at the moment
	 * 1st attempt with % 5 = 8.2132 m
	 * 2nd attempt with % 3 = 6.7771 m
	 */
	public void fastCsv() { 
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
}
