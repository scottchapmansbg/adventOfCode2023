package GetDataFromFile;

import fileReading.CoordinateFileReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class CoordinateFileReaderTest {
    private final CoordinateFileReader getDataFromFile = new CoordinateFileReader();

    @Test
    public void testGetDataFromFile() {

        try {
            List<String> result = getDataFromFile.readFileDataIntoArrayList("src/test/resources/Day1TestFile.txt");
            assert (result.size() == 5);
        } catch (IOException e) {
            e.printStackTrace();
            fail("Exception thrown");
        }
    }
}
