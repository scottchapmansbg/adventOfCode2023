package fileReading.parsers.listParsers;

import fileReading.parsers.lineParsers.BallParser;
import fileReading.parsers.lineParsers.RoundParser;
import game.Round;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class RoundsParser implements ListParser<Round> {

    private final RoundParser roundParser;

    public RoundsParser(RoundParser roundParser) {
        this.roundParser = roundParser;
    }

    @Override
    public List<Round> parseList(String data) {
        return parseRounds(data);
    }

    private List<Round> parseRounds(@NotNull String game) {
        return Arrays.stream(game.split(";"))
                .map(roundParser::parseLine)
                .collect(toList());
    }

}
