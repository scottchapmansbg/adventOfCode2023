package fileReading.parsers.lineParsers;

import game.Ball;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RoundParserTest {

    @Test
    void parseLine() {
        BallParser ballParser = mock(BallParser.class);
        when(ballParser.parseLine("1 red")).thenReturn(new Ball("Red",1));
        when(ballParser.parseLine("10 blue")).thenReturn(new Ball("Blue",10));
        RoundParser roundParser = new RoundParser(ballParser);
        String data = "1 red,10 blue";

        assertEquals(2, roundParser.parseLine(data).getBalls().size());
        assertEquals(1, roundParser.parseLine(data).getBalls().get(0).getNumber());
        assertEquals("Red", roundParser.parseLine(data).getBalls().get(0).getColour());
        assertEquals(10,roundParser.parseLine(data).getBalls().get(1).getNumber());
        assertEquals("Blue",roundParser.parseLine(data).getBalls().get(1).getColour());
    }
}
