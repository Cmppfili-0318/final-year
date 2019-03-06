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
	String filePath = "E:\\complete-distilled-2.csv";
	
	// Instantiating the FileRead class
	FileRead in = new FileRead();
	
	/*
	 * 1.2 m using SSD
	 * 2.8 m using HDD
	 */
	in.univocityIterativeParser(filePath);
	
	// in.usingCustBuffReader();
	
	// in.fastCsvAtOnce(filePath);
	
	/*
	 * fastCsv Parser working but slow
	 * @param path to the file to be read by the parser
	 */
	
	// in.fastCsv(filePath);
	 
	 
	}
}
