package CsvParserAPI;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.univocity.parsers.csv.CsvParser;

public class Main {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {

	String filePath = "C:\\complete-distilled-sorted.csv";
	//FileReader in = new FileReader(filePath);

	FileReader in = new FileReader(filePath);
	//in.csvParser();
	in.fastCsv();
	
	}
}
