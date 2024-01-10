package fileReading;

import java.io.*;
import java.util.*;

public class Day1File {
    public List<String> readFileDataIntoArrayList(String fileName) throws IOException {
        List<String> data = new ArrayList<>();
        BufferedReader bf = new BufferedReader(new FileReader(fileName));
        String line = bf.readLine();
        while (line != null) {
            System.out.println(line);
            data.add(line);
            line = bf.readLine();
        }
        return data;
    }
}
