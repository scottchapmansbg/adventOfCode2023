package fileReading.parsers.lineParsers;

import fileReading.parsers.lineParsers.BallParser;
import fileReading.parsers.lineParsers.LineParser;
import game.BallJ;
import game.RoundJ;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class RoundParser implements LineParser<RoundJ> {
    @Override
    public RoundJ parseLine(String line) {
        return parseRound(line);
    }
    @NotNull
    private RoundJ parseRound(@NotNull String round) {
        BallParser ballParser = new BallParser();
        List<BallJ> result = Arrays.stream(round.split(","))
                .map(ballParser::parseLine)
                .collect(toList());
        return new RoundJ(result);
    }
}
