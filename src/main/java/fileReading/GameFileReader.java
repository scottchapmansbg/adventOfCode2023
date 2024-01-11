package fileReading;

import fileReading.parsers.fileParsers.GamesParser;
import fileReading.parsers.lineParsers.GameParser;
import fileReading.parsers.lineParsers.RoundParser;
import fileReading.parsers.listParsers.RoundsParser;
import game.GameJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class GameFileReader {
    public List<GameJ> readGameFileDataIntoGameList(String fileName) throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
        assert inputStream != null;
        InputStreamReader streamReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(streamReader);
        RoundsParser roundsParser = new RoundsParser();
        GameParser gameParser = new GameParser(roundsParser);
        GamesParser gamesParser = new GamesParser(gameParser);
        return gamesParser.parseFile(reader);
    }
}

