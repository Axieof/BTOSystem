package BTO.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVLoaderService {
    
    public <T> List<T> loadcsv(String filePath, CSVProcessor<T> processor) {
        List<T> results = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip headers

            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                T obj = processor.process(columns);
                results.add(obj);
            }

        } catch (IOException e) {
            System.out.println("Error loading file: " + filePath);
            e.printStackTrace();
        }

        return results;
    }

    @FunctionalInterface
    public interface CSVProcessor<T> {
        T process(String[] columns);
    }
}
