package IO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CSVParser {

    private static Logger logger = LogManager.getLogger(CSVParser.class);

    public static ArrayList parseCSV(String source) {
        ArrayList<ArrayList> csvData = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(source))) {
            String line;
            while((line = bufferedReader.readLine()) != null) {
                String[] lineData = line.split(",");
                csvData.add(new ArrayList(Arrays.asList(lineData)));
            }
        } catch (FileNotFoundException e) {
            logger.error(e);
        } catch (IOException ioException) {
            logger.error(ioException);
        };

//        System.out.println(csvData);
        return (ArrayList) csvData;
    }
}
