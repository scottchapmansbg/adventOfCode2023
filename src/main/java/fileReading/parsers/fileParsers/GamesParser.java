package fileReading.parsers.fileParsers;

import fileReading.parsers.lineParsers.GameParser;
import game.GameJ;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class GamesParser implements FileParser<GameJ> {
    private final GameParser gameParser;
    public GamesParser(GameParser gameParser) {
        this.gameParser = gameParser;
    }
    @Override
    public List<GameJ> parseFile(BufferedReader reader) {
        return parseGames(reader);
    }


    private List<GameJ> parseGames(@NotNull BufferedReader reader) {

        return reader.lines()
                .map(
                        this.gameParser::parseLine)
                .collect(toList());
    }

}
