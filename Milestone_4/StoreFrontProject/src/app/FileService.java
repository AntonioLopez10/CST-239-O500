package app;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

/**
 * FileService reads inventory from a JSON file using Gson.
 */
public class FileService {
    public static List<SalableProduct> readJSON(String filePath) throws IOException {
        try (FileReader reader = new FileReader(filePath)) {
            Type listType = new TypeToken<List<SalableProduct>>() {}.getType();
            return new Gson().fromJson(reader, listType);
        }
    }
}
