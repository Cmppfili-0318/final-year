package FinalYearProject;

import org.simpleflatmapper.*;
import org.simpleflatmapper.csv.CsvParser;
import org.simpleflatmapper.util.CloseableIterator;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Stream;

public class SimpleFlatMapper_csvParser {
    public static void main(String[] args) throws Exception {
        File file = new File(SimpleFlatMapper_csvParser.class.getClassLoader().getResource("E:\\complete-distilled-2.csv").getFile());

        // Callback
        CsvParser
                .forEach(file, row -> System.out.println(Arrays.toString(row)));

    }
}
