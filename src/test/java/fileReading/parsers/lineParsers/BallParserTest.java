package fileReading.parsers.lineParsers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BallParserTest {

    @Test
    void parseLine() {
        BallParser ballParser = new BallParser();
        String data = "1 Blue";
        assertEquals(ballParser.parseLine(data).getNumber(),1);
        assertEquals(ballParser.parseLine(data).getColour(),"Blue");

    }
}
