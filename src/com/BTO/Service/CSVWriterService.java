package src.com.BTO.Service;

import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVWriterService {
    public static void writeCSV(List<? extends ICSVWritable> objects, String filePath, List<String> headers) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {

            if (headers != null && !headers.isEmpty()) {
                writer.println(String.join(",", headers));
            }

            for (ICSVWritable obj : objects) {
                writer.println(obj.toCSV());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
