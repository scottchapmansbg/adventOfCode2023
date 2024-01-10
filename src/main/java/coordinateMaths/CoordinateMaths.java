package coordinateMaths;

import java.util.List;

public class CoordinateMaths {

    public List<Integer> ConvertEachRowToNumber(List<List<Integer>> data) {
        return data.stream().map(this::convertRowToNumber).toList();
    }

    private int convertRowToNumber(List<Integer> row) {
        return Integer.parseInt(row.get(0) + "" + row.get(row.size() - 1));
    }

    public int getSumOfDigits(List<Integer> data) {
        return data.stream().mapToInt(Integer::intValue).sum();
    }

}
