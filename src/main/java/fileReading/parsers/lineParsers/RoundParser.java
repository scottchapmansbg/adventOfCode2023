package fileReading.parsers.lineParsers;

import game.Ball;
import game.Round;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class RoundParser implements LineParser<Round> {
    private final BallParser ballParser;

    public RoundParser(BallParser ballParser) {
        this.ballParser = ballParser;
    }

    @Override
    public Round parseLine(String line) {
        return parseRound(line);
    }

    @NotNull
    private Round parseRound(@NotNull String round) {
        System.out.println(round);
        List<Ball> result = Arrays.stream(round.split(","))
                .map(ballParser::parseLine)
                .collect(toList());
        return new Round(result);
    }
}
