package calander.day1;

import coordinateMaths.CoordinateMaths;
import fileReading.Day1File;
import textManipulation.TextConverter;

import java.io.IOException;
import java.util.List;

public class Day1J {
    private final Day1File day1File = new Day1File();
    private final CoordinateMaths coordinateMaths = new CoordinateMaths();
    private final TextConverter textConverter = new TextConverter();

    public Integer doDay1P1(String fileName) throws IOException {
        List<String> data = day1File.readFileDataIntoArrayList(fileName);
        List<List<Integer>> digits = textConverter.parseDigits(data);
        List<Integer> sums = coordinateMaths.ConvertEachRowToNumber(digits);
        return coordinateMaths.getSumOfDigits(sums);
    }

    public Integer doDay1P2(String fileName) throws IOException {
        List<String> data = day1File.readFileDataIntoArrayList(fileName);
        List<List<Integer>> digits = textConverter.parseDigitsAndWords(data);
        List<Integer> sums = coordinateMaths.ConvertEachRowToNumber(digits);
        return coordinateMaths.getSumOfDigits(sums);
    }


}

