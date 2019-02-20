package CsvParserAPI;

import java.io.File;
import java.util.Arrays;
import com.univocity.parsers.common.ParsingContext;
import com.univocity.parsers.common.processor.AbstractRowProcessor;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

public class TestingUnivocity {

	public static void main(String[] args) {
		
		String filePath = "E:\\complete-distilled-2.csv";
			
		CsvParserSettings settings = new CsvParserSettings();
		final long startTime = System.currentTimeMillis();	
		
		settings.setProcessor(new AbstractRowProcessor() {
		    @Override
		    public void rowProcessed(String[] row, ParsingContext context) {
		       System.out.println(Arrays.toString(row));				
		       // context.skipLines(3); //use the context object to control the parser
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
}

