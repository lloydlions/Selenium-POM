package utils;

import java.io.IOException;
import java.util.List;

public class DataProviderUtil {

    public static Object[][] readTestData(String csvFile) throws IOException {
        CSVReaderUtil csvReader = new CSVReaderUtil(csvFile);
        List<String[]> testData = csvReader.readTestData();

        // Get the number of columns from the first row
        int numColumns = testData.get(0).length;

        // Convert List<String[]> to Object[][]
        Object[][] data = new Object[testData.size()][numColumns];
        for (int i = 0; i < testData.size(); i++) {
            data[i] = testData.get(i);
        }
        return data;
    }


}
