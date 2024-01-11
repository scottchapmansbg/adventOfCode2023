package fileReading.parsers.listParsers;

import fileReading.parsers.lineParsers.RoundParser;
import game.RoundJ;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class RoundsParser implements ListParser<RoundJ> {
    @Override
    public List<RoundJ> parseList(String data) {
        return parseRounds(data);
    }

    private List<RoundJ> parseRounds(@NotNull String game) {
        RoundParser roundParser = new RoundParser();
        return Arrays.stream(game.split(";"))
                .map(roundParser::parseLine)
                .collect(toList());
    }

}
