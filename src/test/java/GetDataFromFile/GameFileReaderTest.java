package GetDataFromFile;

import fileReading.GameFileReader;
import game.GameJ;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class GameFileReaderTest {
    private final GameFileReader getDataFromFile = new GameFileReader();
    @Test
    public void readGameFileDataIntoGameList() {
        try {
            List<GameJ> games =  getDataFromFile.readGameFileDataIntoGameList("Day2Data.txt");
            assertEquals(games.size(),5);
            assertEquals(3,games.get(0).getRounds().size());
            assertEquals(games.get(1).getId(),"Game 2");

        } catch (IOException e) {
            e.printStackTrace();
            fail("Exception thrown");
        }
    }
}
