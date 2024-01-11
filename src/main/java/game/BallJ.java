package game;

import advent.AdventOfCodeData;

public class BallJ extends AdventOfCodeData {
    String colour;
    int number;
    public BallJ(String colour, int number){
        this.colour = colour;
        this.number = number;
    }
    public String getColour(){
        return colour;
    }
    public int getNumber(){
        return number;
    }
}
