/*
 * Main class created for testing purposes
 * Not to be implemented into final API
 */

package CsvParserAPI;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import com.univocity.parsers.csv.CsvParser;

public class Main {
	
	public static void main(String[] args) throws Exception {

	// Creating a path to the file
	String filePath = "C:\\complete-distilled-2.csv";
	String testPath = "C:\\bdlog.txt";
	
	// Instantiating the FileRead class
	FileRead in = new FileRead();
	ParserSolutions in2 = new ParserSolutions();
	
	/*
	 * Calling the parseFile function in order to process the file
	 * @param filePath is the specified destination of the file subjected to processing
	 * @param n (int) specifies how many traces are to be processed by the fileRead class (sample size)
	 */
	
	 // in.processFileWithSample(filePath, 45000000);
	 
	 //in.firstParser(filePath);
	
	/*
	 * @param specified file path for the parser
	 * @param number of lines to be skipped by the parser
	 *	test 1: 92498
	 *	test 2: 91499
	 *	test 3: 92249
	 */
	// in.processFileSkipLines(filePath, 0);
	
	in2.fastCsv(filePath);
	 
	
	 // testing the incorrect file format exception throwing with a simple .txt file
   	 //in.processFileWithSample(testPath, 5);
	
	// in.fastCsvAtOnce(filePath);
	
	/*
	 * fastCsv Parser working but slow
	 * @param path to the file to be read by the parser
	 */
	
	// in.fastCsv(filePath);
	 
	 
	}
}
