package fileReading;

import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Day1File {
    public List<String> getDataFromFile(String fileName) throws IOException {
        List<String> data = new ArrayList<>();
        BufferedReader bf = new BufferedReader(new FileReader(fileName));
        String line = bf.readLine();
        while (line != null) {
            System.out.println(line);
            data.add(line);
            line = bf.readLine();
        }
        return data;
    }

    public List<List<Integer>> parseDigits(@NotNull List<String> data) {
        return data.stream().map((line) -> {
            Pattern pattern = Pattern.compile("[0-9]", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(line);
            List<Integer> row = new ArrayList<>();
            while (matcher.find()) {
                row.add(Integer.parseInt(matcher.group()));
            }
            return row;
        }).toList();
    }

    public List<List<Integer>> parseDigitsAndWords(List<String> strings) {
        List<List<Integer>> numbers = new ArrayList<>();
        Regex regex = new Regex("[0-9]|one|two|three|four|five|six|seven|eight|nine");
        numbers = strings.stream().map((line) -> findAllMatchesAndConvertToInt(line, regex)).toList();
        return numbers;
    }

    public List<Integer> findAllMatchesAndConvertToInt(String line, Regex regex) {
        List<Integer> matches = new ArrayList<>();
        Matcher matcher = Pattern.compile(regex.toString(), Pattern.CASE_INSENSITIVE).matcher(line);
        while (matcher.find()) {
            matches.add(stringToInt(matcher.group()));
        }
        System.out.println(matches);
        return matches;
    }

    private int stringToInt(String string) {
        Map<String, Integer> numberWords = new HashMap<>();
        numberWords.put("zero", 0);
        numberWords.put("one", 1);
        numberWords.put("two", 2);
        numberWords.put("three", 3);
        numberWords.put("four", 4);
        numberWords.put("five", 5);
        numberWords.put("six", 6);
        numberWords.put("seven", 7);
        numberWords.put("eight", 8);
        numberWords.put("nine", 9);


        Regex numberRegex = new Regex("[0-9]");
        if(numberWords.containsKey(string)) {
            return numberWords.get(string);
        } else if (numberRegex.matches(string)) {
            return Integer.parseInt(string);
        } else {
            throw new IllegalArgumentException("String must be a number or a number word");
        }
    }
}
