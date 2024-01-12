package game;

import advent.AdventOfCodeData;

import java.util.List;

public class Game extends AdventOfCodeData {
    private final String id;
    private final List<Round> rounds;
    public Game(final String id, final List<Round> rounds) {
        this.id = id;
        this.rounds = rounds;
    }

    public String getId() {
        return id;
    }
    public List<Round> getRounds() {
        return rounds;
    }
}
