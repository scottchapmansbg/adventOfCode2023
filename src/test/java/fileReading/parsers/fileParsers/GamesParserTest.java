package fileReading.parsers.fileParsers;

import fileReading.parsers.lineParsers.GameParser;
import game.Game;
import game.Round;
import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.util.List;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GamesParserTest {
    @Test
    void parseFile() {
        BufferedReader testBuffer = mock(BufferedReader.class);
        Stream<String> testStream = Stream.of("1:1,2,3;4,5,6");
        when(testBuffer.lines()).thenReturn(testStream);

        Round round = mock(Round.class);
        List<Round> rounds = List.of(round);
        Game result = new Game("1",rounds );

        GameParser gameParser = mock(GameParser.class);

        when(gameParser.parseLine("1:1,2,3;4,5,6")).thenReturn(result);
        GamesParser gamesParser = new GamesParser(gameParser);
        List<Game> actual = gamesParser.parseFile(testBuffer);
        assertEquals(List.of(result), actual);
    }
}
