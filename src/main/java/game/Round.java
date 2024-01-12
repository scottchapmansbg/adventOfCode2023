package game;

import advent.AdventOfCodeData;

import java.util.List;

public class Round {
    List<Ball> balls;
    public Round(List<Ball> balls){
        this.balls = balls;
    }
    public List<Ball> getBalls(){
        return balls;
    }
}
