package coordinateMaths;

import org.junit.jupiter.api.Test;

import java.util.List;

public class CoordinateMathsTest {
    @Test
    public void AddUpRow() {
        var testData = List.of(List.of(1, 2, 3), List.of(4, 5, 6), List.of(7, 8, 9));
        var expectedResult = List.of(13, 46, 79);
        var coordinateMaths = new CoordinateMaths();
        var result = coordinateMaths.ConvertEachRowToNumber(testData);
        assert (result.size() == 3);
        assert (result.equals(expectedResult));
    }

    @Test
    public void GetSumOfDigits() {
        var testData = List.of(1, 2, 3);
        var expectedResult = 6;
        var coordinateMaths = new CoordinateMaths();
        var result = coordinateMaths.getSumOfDigits(testData);
        assert (result == expectedResult);
    }
}
