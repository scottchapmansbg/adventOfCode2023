package fileReading.parsers.lineParsers;

import fileReading.parsers.listParsers.RoundsParser;
import game.Game;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class GameParser implements LineParser<Game> {

    private final RoundsParser roundsParser;

    public GameParser(RoundsParser roundsParser) {
        this.roundsParser = roundsParser;
    }
    @Override
    public Game parseLine(String data) {
        return parseGame(data);
    }

    @NotNull
    @Contract("_ -> new")
    private Game parseGame(@NotNull String line) {
        String id = line.split(":")[0];
        String gameRounds = line.split(":")[1];
        return new Game(id, roundsParser.parseList(gameRounds));
    }
}
