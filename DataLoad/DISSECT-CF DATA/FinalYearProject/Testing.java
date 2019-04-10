package FinalYearProject;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Testing {

	public void main(String[] args) throws FileNotFoundException, IOException {
	
	String file = "E:\\complete-distilled-2.csv";
	//FileInputStream inputStream = new FileInputStream(this.getClass().getResource("complete-distilled-sorted.csv").getPath());
	FileRead csvReader = new FileRead(file);
	//csvReader.fastCsv();
	csvReader.fastCsv();
	}
}
