package calander.day1;

import coordinateMaths.CoordinateMaths;
import fileReading.CoordinateFileReader;
import textManipulation.TextConverter;

import java.io.IOException;
import java.util.List;

public class Day1J {
    private final CoordinateFileReader coordinateFileReader = new CoordinateFileReader();
    private final CoordinateMaths coordinateMaths = new CoordinateMaths();
    private final TextConverter textConverter = new TextConverter();

    public Integer doDay1P1(String fileName) throws IOException {
        return coordinateMaths.getSumOfDigits(coordinateMaths.ConvertEachRowToNumber(
                textConverter.parseDigits(coordinateFileReader.readFileDataIntoArrayList(
                fileName))));
    }

    public Integer doDay1P2(String fileName) throws IOException {
        List<String> data = coordinateFileReader.readFileDataIntoArrayList(fileName);
        List<List<Integer>> digits = textConverter.parseDigitsAndWords(data);
        List<Integer> sums = coordinateMaths.ConvertEachRowToNumber(digits);
        return coordinateMaths.getSumOfDigits(sums);
    }


}

