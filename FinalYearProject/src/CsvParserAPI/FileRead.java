package CsvParserAPI;

import com.univocity.parsers.common.*;
import com.univocity.parsers.common.processor.*;
import com.univocity.parsers.common.record.*;
import com.univocity.parsers.conversions.*;
import com.univocity.parsers.csv.*;
/*
import de.siegmar.fastcsv.reader.CsvReader;
import de.siegmar.fastcsv.reader.CsvContainer;
import de.siegmar.fastcsv.reader.CsvParser;
import de.siegmar.fastcsv.reader.CsvRow;
*/
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
 * Several open source parsers are being tested to find the most efficient parser (FastCSV, CustomBufferedReader, univocity)
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
	String relativePath;
	
	public FileRead() {
		
	}

	public void univocityIterativeParser(String filePath) {
		ArrayList<HashMap<String,String>> ArrayL = new ArrayList<>();
		HashMap<String,String> Hash = new HashMap<>();
		CsvParserSettings settings = new CsvParserSettings();
		final long startTime = System.currentTimeMillis();	
		
		settings.setProcessor(new AbstractRowProcessor() {
		    @Override
		    public void rowProcessed(String[] row, ParsingContext context) {
		    int length = row.length;
		    Hash.clear();
		   // Hash.put("File Extension", row.getField(0));
		    ArrayL.add(Hash);
		   // System.out.println(length);
		   // context.currentRecord();
		} 	 
	});

		CsvParser parser = new CsvParser(settings);
		//`parse` doesn't return anything. Rows go to the `rowProcessed` method.
		try {
			parser.parse(new File(filePath));
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		long elapsedTime = System.currentTimeMillis() - startTime;
		System.out.println("Execution Time in ms:" + elapsedTime);
		
	}	

	public void univocity(String filePath) {
		int linecounter = 1;
		CsvParserSettings settings = new CsvParserSettings();
		CsvParser parser = new CsvParser(settings);
		settings.setMaxColumns(1024);
		settings.setHeaderExtractionEnabled(true);
		settings.setLineSeparatorDetectionEnabled(true);
		for (String[] row : parser.iterate(new File(filePath))) {
			if((linecounter % 2) > 0) {
				System.out.println(Arrays.toString(row));
			}	
		}
		
		long elapsedTime = System.currentTimeMillis() - startTime;
		System.out.println("Execution Time in ms:" + elapsedTime);
		
	}
}
	

