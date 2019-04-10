import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Stream;

// Efficiency benchmark for different methods of reading .csv file
public class FileInput { 
	
	static long startTime = System.currentTimeMillis();
	private static long total = 0;
	
	//Last 2 backslashes are not followed by any special characters
	private static final Pattern FIELD_DELIMETER_PATTERN = Pattern.compile("\\^\\|\\^");	
	
/*	private void usingScanner() throws FileNotFoundException {
		String s;
		try (Scanner data = new Scanner(new File(this.getClass().getResource("complete-distilled-sorted.csv").getPath()))) {
			while (data.hasNextLine()) {
				s = data.nextLine();
				String[] fields = FIELD_DELIMETER_PATTERN.split(s, 0);
				total = total + fields.length;
				long elapsedTime = System.currentTimeMillis() - startTime;
				System.out.println("Execution Time in ms: " + elapsedTime);
				data.close();
			}
		} catch (Exception e) {
			System.err.println("Error");
	}
} 
	//Around 9 minutes
	private void usingBuffReader() throws FileNotFoundException, IOException {
		try (BufferedReader data = new BufferedReader(new FileReader(this.getClass().getResource("complete-distilled-sorted.csv").getPath()))) {
			String s;
			while ((s = data.readLine()) != null) {
				String[] fields = FIELD_DELIMETER_PATTERN.split(s, 0);
				total += fields.length;
				long elapsedTime = System.currentTimeMillis() - startTime;
				System.out.println("Execution Time in ms: " + elapsedTime);
				data.close();
			}
		} catch (Exception e) {
			System.err.println("Error");
	}
} 
	/*Fastest = 8.6 minutes
	* 2nd attempt 481155ms
	* 3rd attempt 469065ms
	* Using the custom buffered reader in comparison to buffered reader
	*/
	
	public void usingCustBuffReader() throws FileNotFoundException, IOException {
		try (CustomBufferedReader data = new CustomBufferedReader(new FileReader(new File(this.getClass().getResource("E:\\complete-distilled-2.csv").getPath())))) {;
		String s;
				while ((s = data.readLine()) != null) {
					String [] fields = FIELD_DELIMETER_PATTERN.split(s, 0);
					total += fields.length;
					long elapsedTime = System.currentTimeMillis() - startTime;
					System.out.println("Execution Time in ms:" + elapsedTime);
					data.close();
				}
			
	} catch (Exception e) {
		System.err.println("Error");
		}
	}
	
/*	private void readFileUsingLineReader() {

	        try (LineNumberReader data = new LineNumberReader(new FileReader(new File(this.getClass().getResource("complete-distilled-sorted.csv").getPath())))) {
	            String s;
	            while ((s = data.readLine()) != null) {
	                String[] fields = FIELD_DELIMETER_PATTERN.split(s, 0);
	                total += fields.length;
	                long elapsedTime = System.currentTimeMillis() - startTime;
					System.out.println("Execution Time in ms: " + elapsedTime);
					data.close();
	            }
	        } catch (Exception e) {
	            System.err.println("Error");
	        }
	    } 
	 
	 private void readFileUsingStreams() {

	        try (Stream<String> stream = Files.lines((new File(this.getClass().getResource("complete-distilled-sorted.csv").getPath())).toPath())) {
	            total += stream.mapToInt(s -> FIELD_DELIMETER_PATTERN.split(s, 0).length).sum();
	            long elapsedTime = System.currentTimeMillis() - startTime;
				System.out.println("Execution Time in ms: " + elapsedTime);
				stream.close();
	        } catch (IOException e1) {
	            e1.printStackTrace();
	        }
	    } 

	 private void readFileUsingBufferedReaderFileChannel() {
	        try (FileInputStream inputStream = new FileInputStream(this.getClass().getResource("complete-distilled-sorted.csv").getPath())) {
	            try (FileChannel inputChannel = inputStream.getChannel()) {
	                try (CustomBufferedReader data = new CustomBufferedReader(Channels.newReader(inputChannel, "UTF-8"))) {
	                    String s;
	                    while ((s = data.readLine()) != null) {
	                        String[] fields = FIELD_DELIMETER_PATTERN.split(s, 0);
	                        total = total + fields.length;
	                    }
	                }
	            } catch (Exception e) {
	                System.err.println("Error");
	            }
	        } catch (Exception e) {
	            System.err.println("Error");
	        }

	   } */
}
