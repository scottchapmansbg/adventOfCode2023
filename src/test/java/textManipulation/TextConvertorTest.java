package textManipulation;

import kotlin.text.Regex;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextConvertorTest {
    private final TextConverter textConverter = new TextConverter();

    @Test
    public void testWordToInt() {
        String testInput = "one";
        assert (textConverter.stringToInt(testInput) == 1);
    }

    @Test
    public void parseDigitsAndWords() {
        var testData = List.of("sixsrvldfour4seven", "53hvhgchljnlxqjsgrhxgf1zfoureightmlhvvv", "fives2dznl");
        var expectedResult = List.of(List.of(6,4,4,7), List.of(5,3,1,4,8), List.of(5,2));
        List<List<Integer>> result = textConverter.parseDigitsAndWords(testData);
        assert (result.size() == 3);
        assertEquals(expectedResult, result);
    }


    @Test
    public void testNumberInStringToInt() {
        String testInput = "1";
        assert (textConverter.stringToInt(testInput) == 1);
    }

    @Test
    public void testInvalidArgumentThrowsException() {
        String testInput = "invalid";
        try {
            textConverter.stringToInt(testInput);
        } catch (IllegalArgumentException e) {
            assert (e.getMessage().equals("String must be a number or a number word"));
        }
    }

    @Test
    public void testParseDigits() {
        var testData = List.of("sixsrvldfour4seven", "53hvhgchljnlxqjsgrhxgf1zfoureightmlhvvv", "fives2dznl");
        var expectedResult = List.of(List.of(4), List.of(5, 3, 1), List.of(2));
        List<List<Integer>> result = textConverter.parseDigits(testData);
        assert (result.size() == 3);
        assertEquals(expectedResult, result);

    }

    @Test
    public void testFindAll() {
        Regex regex = new Regex("[0-9]|one|two|three|four|five|six|seven|eight|nine");
        var testData = "sixsrvldfour4seven";
        var expectedResult = List.of(6,4,4,7);
        List<Integer> result = textConverter.findAllMatchesAndConvertToInt(testData, regex);
        assertEquals(expectedResult, result);
    }
}
