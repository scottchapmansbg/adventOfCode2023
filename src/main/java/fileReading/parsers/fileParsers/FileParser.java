package fileReading.parsers.fileParsers;

import fileReading.parsers.Parser;

import java.io.BufferedReader;
import java.util.List;

public interface FileParser<T> extends Parser {
    List<T> parseFile(BufferedReader reader);
}
