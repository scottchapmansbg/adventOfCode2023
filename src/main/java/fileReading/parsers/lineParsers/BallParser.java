package fileReading.parsers.lineParsers;

import game.BallJ;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class BallParser implements LineParser<BallJ> {

    @Override
    public BallJ parseLine(String data) {
        return parseBall(data);
    }

    @NotNull
    @Contract("_ -> new")
    private BallJ parseBall(@NotNull String ball) {
        String[] result = ball.trim().split(" ");
        return new BallJ(result[1], Integer.parseInt(result[0]));
    }
}
