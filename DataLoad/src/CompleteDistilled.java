import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CompleteDistilled {
	
/* First attempt at loading in the .csv file with data sets
 * Trying scanner first to get a basic benchmark
 * Improve later
 */

	static long startTime = System.currentTimeMillis();
	public static void main(String[] args) {
		String dataFile = "complete-distilled-sorted.csv"; // Declaring a string with file name
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
}



