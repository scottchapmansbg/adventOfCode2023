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
            List<String> result = getDataFromFile.getDataFromFile("src/test/resources/Day1TestFile.txt");
            assert (result.size() == 5);
        } catch (IOException e) {
            e.printStackTrace();
            fail("Exception thrown");
        }
    }

    @Test
    public void testParseDigits() {
        var testData = List.of("sixsrvldfour4seven", "53hvhgchljnlxqjsgrhxgf1zfoureightmlhvvv", "fives2dznl");
        var expectedResult = List.of(List.of(4), List.of(5, 3, 1), List.of(2));
        List<List<Integer>> result = getDataFromFile.parseDigits(testData);
        assert (result.size() == 3);
        assertEquals(expectedResult, result);

    }

//    @Test
//    public void testParseWordsToDigits() {
//        var testData = List.of("sixsrvldfour4seven", "53hvhgchljnlxqjsgrhxgf1zfoureightmlhvvv", "fives2dznl","gtjtwonefourone6fouronefccmnpbpeightnine");
//        var expectedResult = List.of("6srvld447", "53hvhgchljnlxqjsgrhxgf1z48mlhvvv", "5s2dznl","gtj2ne41641fccmnpbp89");
//        List<String> result = getDataFromFile.parseWordsToDigits(testData);
//        assert (result.size() == 4);
//        assertEquals(expectedResult, result);
//    }

    @Test
    public void testFindAll() {
        Regex regex = new Regex("[0-9]|one|two|three|four|five|six|seven|eight|nine");
        var testData = "sixsrvldfour4seven";
        var expectedResult = List.of(6,4,4,7);
        List<Integer> result = getDataFromFile.findAllMatchesAndConvertToInt(testData, regex);
        assertEquals(expectedResult, result);
    }

//    @Test
//    public void testParseWordsAndDigits() {
//        var testData = List.of("sixsrvldfour4seven", "53hvhgchljnlxqjsgrhxgf1zfoureightmlhvvv", "fives2dznl");
//        var expectedResult = List.of(List.of(6, 4, 4, 7), List.of(5, 3, 1, 4, 8), List.of(5, 2));
//        List<List<Integer>> result = getDataFromFile.parseDigitsAndWords(getDataFromFile.parseWordsToDigits(testData));
//        assert (result.size() == 3);
//        assertEquals(expectedResult, result);
//    }
}
