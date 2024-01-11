package fileReading.parsers.lineParsers;

import calander.day2.Round;
import fileReading.parsers.listParsers.RoundsParser;
import game.GameJ;
import game.RoundJ;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GameParserTest {

    @Test
    void parseLine() {
        RoundsParser roundParser = mock(RoundsParser.class);
        RoundJ round = mock(RoundJ.class);
        when(roundParser.parseList("1,2,3,4,5,6,7,8,9,10")).thenReturn(List.of(round));
        GameParser gameParser = new GameParser(roundParser);
        String line = "1:1,2,3,4,5,6,7,8,9,10";
        GameJ result = gameParser.parseLine(line);
        assertEquals("1", result.getId());
        assertEquals(List.of(round), result.getRounds());

    }
}
