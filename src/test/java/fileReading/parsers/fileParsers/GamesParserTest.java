package fileReading.parsers.fileParsers;

import fileReading.parsers.lineParsers.GameParser;
import game.GameJ;
import game.RoundJ;
import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.IOException;
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

        RoundJ round = mock(RoundJ.class);
        List<RoundJ> rounds = List.of(round);
        GameJ result = new GameJ("1",rounds );

        GameParser gameParser = mock(GameParser.class);

        when(gameParser.parseLine("1:1,2,3;4,5,6")).thenReturn(result);
        GamesParser gamesParser = new GamesParser(gameParser);
        List<GameJ> actual = gamesParser.parseFile(testBuffer);
        assertEquals(List.of(result), actual);
    }
}
