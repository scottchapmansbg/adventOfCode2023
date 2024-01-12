package fileReading.parsers.lineParsers;

import game.Ball;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class BallParser implements LineParser<Ball> {

    @Override
    public Ball parseLine(String data) {
        return parseBall(data);
    }

    @NotNull
    @Contract("_ -> new")
    private Ball parseBall(@NotNull String ball) {
        String[] result = ball.trim().split(" ");
        return new Ball(result[1], Integer.parseInt(result[0]));
    }
}
