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

import com.univocity.parsers.csv.CsvParser;

public class Main {
	
	public static void main(String[] args) throws Exception {

	// Creating a path to the file
	String filePath = "C:\\complete-distilled-sorted.csv";
	
	// Instantiating the FileRead class
	FileRead in = new FileRead();
	
	// Transforming the file into an InputStream for iterative univocity parser
	InputStream stream = new ByteArrayInputStream(filePath.getBytes(StandardCharsets.UTF_8));
	
	
	in.usingCustBuffReader();
	
	
	in.fastCsvAtOnce(filePath);

	/*
	 * Univocity csv Parsers not working
	 * NullPointer
	 */
	
	 // in.univocityParserIterative(stream);
	 // in.univocityParserAtOnce(filePath);
	 
	
	
	/*
	 * fastCsv Parser working but slow
	 * @param path to the file to be read by the parser
	 */
	
	 in.fastCsv(filePath);
	 
	 
	}
}
