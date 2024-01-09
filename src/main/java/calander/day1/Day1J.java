package calander.day1;

import fileReading.Day1File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day1J {
    private final Day1File day1File = new Day1File();

    public Integer doDay1P1(String fileName) throws IOException {
        List<String> data = day1File.getDataFromFile(fileName);
        List<List<Integer>> digits = day1File.parseDigits(data);
        List<Integer> sums = addUpRow(digits);
        return getSumOfDigits(sums);
    }

    public Integer doDay1P2(String fileName) throws IOException {
        List<String> data = day1File.getDataFromFile(fileName);
        List<List<Integer>> digits = day1File.parseDigitsAndWords(data);
        List<Integer> sums = addUpRow(digits);
        return getSumOfDigits(sums);
    }

//    public Integer doDay1P2(String fileName) throws IOException {
//        return getSumOfDigits(addUpRow(day1File.parseDigitsAndWords(day1File.getDataFromFile(fileName))));
//    }

    private List<Integer> addUpRow(List<List<Integer>> data) {
        List<Integer> result = new ArrayList<>();
        for (List<Integer> row : data) {
            int sum =Integer.parseInt( row.get(0) + "" + row.get(row.size()-1));
            result.add(sum);
        }
        return result;
    }

    public int getSumOfDigits(List<Integer> data) {
        int sum = 0;
        for (int digit : data) {
                sum += digit;
        }
        return sum;
    }
}

