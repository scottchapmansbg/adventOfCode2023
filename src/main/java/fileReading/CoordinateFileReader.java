package fileReading;

import java.io.*;
import java.util.*;

public class CoordinateFileReader {
    public List<String> readFileDataIntoArrayList(String fileName) throws IOException {
        List<String> data = new ArrayList<>();
        BufferedReader bf = new BufferedReader(new FileReader(fileName));

        for(String line; (line = bf.readLine()) != null;) {
            System.out.println(line);
            data.add(line);
        }

        return data;
    }


}
