package fileReading.parsers.lineParsers;

import fileReading.parsers.listParsers.RoundsParser;
import game.GameJ;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class GameParser implements LineParser<GameJ> {

    private final RoundsParser roundsParser;

    public GameParser(RoundsParser roundsParser) {
        this.roundsParser = roundsParser;
    }
    @Override
    public GameJ parseLine(String data) {
        return parseGame(data);
    }

    @NotNull
    @Contract("_ -> new")
    private GameJ parseGame(@NotNull String line) {
        String id = line.split(":")[0];
        String gameRounds = line.split(":")[1];
        return new GameJ(id, roundsParser.parseList(gameRounds));
    }
}
