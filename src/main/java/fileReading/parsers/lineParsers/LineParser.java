package fileReading.parsers.lineParsers;

import fileReading.parsers.Parser;
import game.BallJ;

public interface LineParser<T> extends Parser {

    T parseLine(String data);
}
