package fileReading.parsers.listParsers;

import fileReading.parsers.lineParsers.BallParser;
import fileReading.parsers.lineParsers.RoundParser;
import game.Round;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RoundsParserTest {

    @Test
    void parseList() {
        RoundParser roundParser = mock(RoundParser.class);
        Round firstResult = mock(Round.class);
        Round secondResult = mock(Round.class);

        when(roundParser.parseLine("1 red,10 blue")).thenReturn(firstResult);
        when(roundParser.parseLine("2 yellow,3 green")).thenReturn(secondResult);
        RoundsParser roundsParser = new RoundsParser(roundParser);
        String data = "1 red,10 blue;2 yellow,3 green";

        List<Round> rounds = roundsParser.parseList(data);
        assertEquals(2, rounds.size());
        assertEquals(firstResult, rounds.get(0));
        assertEquals(secondResult, rounds.get(1));

    }
}
