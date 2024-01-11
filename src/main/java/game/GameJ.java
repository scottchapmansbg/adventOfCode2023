package game;

import advent.AdventOfCodeData;

import java.util.List;

public class GameJ extends AdventOfCodeData {
    private String id;
    private List<RoundJ> rounds;
    public GameJ(final String id, final List<RoundJ> rounds) {
        this.id = id;
        this.rounds = rounds;
    }

    public String getId() {
        return id;
    }
    public List<RoundJ> getRounds() {
        return rounds;
    }
}
