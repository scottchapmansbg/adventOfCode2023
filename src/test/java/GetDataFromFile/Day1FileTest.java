package GetDataFromFile;

import kotlin.text.Regex;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class Day1FileTest {
    private final fileReading.Day1File getDataFromFile = new fileReading.Day1File();

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
