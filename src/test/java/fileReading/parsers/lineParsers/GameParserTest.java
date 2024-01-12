package fileReading.parsers.lineParsers;

import fileReading.parsers.listParsers.RoundsParser;
import game.Game;
import game.Round;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GameParserTest {

    @Test
    void parseLine() {
        RoundsParser roundParser = mock(RoundsParser.class);
        Round round = mock(Round.class);
        when(roundParser.parseList("1,2,3,4,5,6,7,8,9,10")).thenReturn(List.of(round));
        GameParser gameParser = new GameParser(roundParser);
        String line = "1:1,2,3,4,5,6,7,8,9,10";
        Game result = gameParser.parseLine(line);
        assertEquals("1", result.getId());
        assertEquals(List.of(round), result.getRounds());

    }
}
