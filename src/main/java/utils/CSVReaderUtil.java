package utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReaderUtil {

    private String csvFile;

    public CSVReaderUtil(String csvFile) {
        this.csvFile = csvFile;
    }

    public List<String[]> readTestData() throws IOException {
        List<String[]> testData = new ArrayList<>();
        String path = "src/test/java/e2e/testdata/" + csvFile;
        System.out.println("Path:: "+ path);
        try (CSVReader reader = new CSVReader(new FileReader(path))) {
            String[] line;
            boolean firstLine = true; // Flag to skip the first line (header)
            while ((line = reader.readNext()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue; // Skip the first line (header)
                }
                // Check if any field is null
                boolean hasNullField = false;
                for (String field : line) {
                    if (field == null || field.trim().isEmpty()) {
                        hasNullField = true;
                        break;
                    }
                }
                if (!hasNullField) {
                    testData.add(line);
                }
            }
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
        return testData;
    }

}

