package IO;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class OpenCSVParser {
    private static Logger logger = LogManager.getLogger(CSVParser.class);

    public static ArrayList parseCSV(String source) {
        ArrayList<ArrayList> csvData = new ArrayList<>();
        try(CSVReader csvReader = new CSVReader(new FileReader(source));) {
            String[] data = null;
            while((data = csvReader.readNext()) != null) {
                csvData.add(new ArrayList(Arrays.asList(data)));
            }
        } catch (FileNotFoundException e){
            logger.error(e);
        } catch (IOException ioException){
            logger.error(ioException);
        } catch (CsvValidationException csvValidationException) {
            logger.error(csvValidationException);
        }

        return (ArrayList) csvData;
    }
}
