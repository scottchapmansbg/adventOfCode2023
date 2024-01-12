package GetDataFromFile;

import fileReading.GameFileReader;
import fileReading.parsers.fileParsers.GamesParser;
import game.Game;
import game.Round;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameFileReaderTest {

    @Test
    public void readGameFileDataIntoGameList() {
        GamesParser gamesParser = mock(GamesParser.class);
        BufferedReader bufferedReader = mock(BufferedReader.class);
        Round round = mock(Round.class);
        when(gamesParser.parseFile(bufferedReader)).thenReturn(List.of(
                new Game("Game 1", List.of(round)),
                new Game("Game 2", List.of()),
                new Game("Game 3", List.of()),
                new Game("Game 4", List.of()),
                new Game("Game 5", List.of())
        ));
        GameFileReader getDataFromFile = new GameFileReader(gamesParser,bufferedReader);
            List<Game> games =  getDataFromFile.readGameFileDataIntoGameList();
            assertEquals(5 , games.size());
            assertEquals(games.get(0).getId(),"Game 1");
            assertEquals(games.get(0).getRounds().get(0),round);


    }
}
