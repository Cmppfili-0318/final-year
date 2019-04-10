import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import de.siegmar.fastcsv.reader.CsvContainer;
import de.siegmar.fastcsv.reader.CsvReader;
import de.siegmar.fastcsv.reader.CsvRow;
import de.siegmar.fastcsv.reader.CsvParser;

public class CompleteDistilled {
	
/* First attempt at loading in the .csv file with data sets
 * Trying scanner first to get a basic benchmark
 * Improve later
 */
	CsvReader csvReader = new CsvReader();
	static long startTime = System.currentTimeMillis();
	public static void main(String[] args) {
		
		//csvScanner();
		fastCsv();
	}	
	
	public static void csvScanner() {
		String dataFile = "C:\\complete-distilled-sorted.csv"; // Declaring a string with file name
		File file = new File(dataFile);
	
		try {
			Scanner inputStream = new Scanner(file);
			while (inputStream.hasNext()) {
				String data = inputStream.next();
				System.out.println(data);
			}
			long elapsedTime = System.currentTimeMillis() - startTime;
			System.out.println("Execution Time in ms: " + elapsedTime);
			inputStream.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
	} 
	
	/*
	 * Custom .csv reader
	 * 1st test : 684766 ms ~ 11 minutes
	 */
	
	public static void fastCsv() { 
		File file = new File("E:\\complete-distilled-2.csv");
		CsvReader csvReader = new CsvReader();

		try (CsvParser csvParser = csvReader.parse(file, StandardCharsets.UTF_8)) {
		    CsvRow row;
		    while ((row = csvParser.nextRow()) != null) {
		       // System.out.println("Read line: " + row);
		        //System.out.println("First column of line: " + row.getField(0));
		    	System.out.println(row);
		    	}
		    long elapsedTime = System.currentTimeMillis() - startTime;
			System.out.println("Execution Time in ms: " + elapsedTime);
			csvParser.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
	}





