package fileReading.parsers.lineParsers;

import fileReading.parsers.Parser;

public interface LineParser<T> extends Parser {

    T parseLine(String data);
}
