package fileReading.parsers.listParsers;

import fileReading.parsers.Parser;

import java.util.List;

public interface ListParser <T> extends Parser {
    public List<T> parseList(String data);
}
