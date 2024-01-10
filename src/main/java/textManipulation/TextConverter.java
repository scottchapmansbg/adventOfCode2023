package textManipulation;

import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextConverter {
    public int stringToInt(String word) {
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

        if(numberWords.containsKey(word)) {
            return numberWords.get(word);
        } else if (numberRegex.matches(word)) {
            return Integer.parseInt(word);
        } else {
            throw new IllegalArgumentException("String must be a number or a number word");
        }
    }

    public List<List<Integer>> parseDigits(@NotNull List<String> data) {
        return data.stream().map(this::getDigitsFromLine).toList();
    }

    private List<Integer> getDigitsFromLine(String line){
        Pattern pattern = Pattern.compile("[0-9]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(line);
        List<Integer> row = new ArrayList<>();
        while (matcher.find()) {
            row.add(Integer.parseInt(matcher.group()));
        }
        return row;
    }


    public List<List<Integer>> parseDigitsAndWords(List<String> strings) {
        Regex regex = new Regex("[0-9]|one|two|three|four|five|six|seven|eight|nine");
        return strings.stream().map((line) -> findAllMatchesAndConvertToInt(line, regex)).toList();
    }

    public List<Integer> findAllMatchesAndConvertToInt(String line, Regex regex) {
        List<Integer> numbersInFoundInALine = new ArrayList<>();
        Matcher matcher = Pattern.compile(regex.toString(), Pattern.CASE_INSENSITIVE).matcher(line);
        while (matcher.find()) {
            numbersInFoundInALine.add(stringToInt(matcher.group()));
        }
        return numbersInFoundInALine;
    }
}
