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
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
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

	private Trace[] traceList;
	private ArrayList<Trace> arrayList = new ArrayList<>();
	private CsvParserSettings parseSettings = new CsvParserSettings();
	private CsvWriterSettings writeSettings = new CsvWriterSettings();
	private String[] headers = {"Trace File Name", "Trace Job ID", "Workflow Phase", "Past Error of Phase", "Future Error of Phase", "Job 1 Runtime", "Job 2 Runtime", "Job 3 Runtime", "Job 4 Runtime", "Job 5 Runtime", "Job 6 Runtime", "Job 7 Runtime", "Job 8 Runtime", "Job 9 Runtime", "Job 10 Runtime", "Job 11 Runtime", "Job 12 Runtime", "Job 13 Runtime", "Job 14 Runtime", "Job 15 Runtime", "Job 16 Runtime", "Job 17 Runtime", "Job 18 Runtime", "Job 19 Runtime", "Job 20 Runtime"};
	
	public FileRead() {
		
	}

	public void processFileWithSample(String filePath, int linesToRead) {
		//writeSettings.setHeaderWritingEnabled(true);
		//writeSettings.setHeaders(headers);
		parseSettings.setNumberOfRecordsToRead(linesToRead);
		parseSettings.setHeaderExtractionEnabled(false);
		parseSettings.setHeaders(headers);
		// Prints out only file extension name and job ID
		//settings.selectIndexes(0,1);
		final long startTime = System.currentTimeMillis();	
		
		parseSettings.setProcessor(new AbstractRowProcessor() {
		    @Override
		    public void rowProcessed(String[] row, ParsingContext context) {
		    //writeSettings.setHeaders(headers);
		    //System.out.println(Arrays.toString(row));
		    //System.out.println(context.headers());
		    arrayList.clear();
		    //arrayList.add(Hash);
		} 	 
	});
		
		CsvParser parser = new CsvParser(parseSettings);
		CsvWriter writer = new CsvWriter(writeSettings);
		//parser.getContext().header
	
		if(filePath.endsWith(".csv")) {
			
		//`parse` doesn't return anything. Rows go to the `rowProcessed` method.
		try {
			parser.parse(new File(filePath));
			parser.getContext().headers();
			//writer.writeHeaders(headers);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		long elapsedTime = System.currentTimeMillis() - startTime;
		System.out.println("Execution Time in ms:" + elapsedTime);
	}
	
		else {
			throw new java.lang.Error("Incorrect File Format, must be a .csv File");
		}
	}
	
	//skipping lines doesn't work - parser behaviour
	public void processFileSkipLines(String filePath, int linesToSkip) throws Exception {
		// No header so the parser doesn't need to read the first line of file
		parseSettings.setHeaderExtractionEnabled(false);
		//parseSettings.setHeaders(headers);
		CsvParser parser = new CsvParser(parseSettings);
		InputStream stream = new FileInputStream(filePath);
		int avgNo = 257;
		int skipByBytes = avgNo*linesToSkip;
		stream.skip(skipByBytes);
		
		// Prints out only file extension name and job ID
		//settings.selectIndexes(0,1);
		//settings.setHeaders(headers);
		final long startTime = System.currentTimeMillis();	
		
		parseSettings.setProcessor(new AbstractRowProcessor() {
		    @Override
		    public void rowProcessed(String[] row, ParsingContext context) {
		    //System.out.println(Arrays.toString(row));;
		} 	 
	});
		
		if(filePath.endsWith(".csv")) {
			
		//`parse` doesn't return anything. Rows go to the `rowProcessed` method.
		try {
			parser.parse(stream);
			//writeSettings.getHeaders();
			} catch (Exception e) {
			e.printStackTrace();
		} 
		
		long elapsedTime = System.currentTimeMillis() - startTime;
		System.out.println("Execution Time in ms:" + elapsedTime);
		stream.close();
		}
		else {
			throw new java.lang.Error("Incorrect File Format, Must be a .csv File");
			//System.out.println("Incorrect file format");
		}
	}
}
	

