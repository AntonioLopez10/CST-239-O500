package service;

import model.SalableProduct;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    public List<SalableProduct> loadFromFile(String filename) {
        List<SalableProduct> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                list.add(new SalableProduct(parts[0], parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void saveToFile(String filename, List<SalableProduct> inventory) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (SalableProduct p : inventory) {
                bw.write(p.getName() + "|" + p.getDescription() + "|" + p.getPrice() + "|" + p.getQuantity());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
