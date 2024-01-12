package fileReading;

import fileReading.parsers.fileParsers.GamesParser;
import game.Game;
import java.io.BufferedReader;
import java.util.List;

public class GameFileReader {

    private final GamesParser gamesParser;
    private final BufferedReader bufferedReader;

    public GameFileReader(GamesParser gamesParser,
                           BufferedReader bufferedReader
    )
    {
        this.gamesParser = gamesParser;
        this.bufferedReader = bufferedReader;
    }

    public List<Game> readGameFileDataIntoGameList() {
        return gamesParser.parseFile(bufferedReader);
    }
}

