package game;

import advent.AdventOfCodeData;

public class Ball extends AdventOfCodeData {
    String colour;
    int number;
    public Ball(String colour, int number){
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
