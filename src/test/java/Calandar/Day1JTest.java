package Calandar;

import calander.day1.Day1J;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.fail;

public class Day1JTest {
    private final Day1J day1J = new Day1J();

    @Test
    public void testDoDay1(){
        try {
            assert (day1J.doDay1P1("src/main/resources/Day1Data.txt")) == 54561;
        }catch (IOException e){
            e.printStackTrace();
            fail("Exception thrown");

        }
    }

    @Test
    public void testDoDay1P2(){
        try {
            assert (day1J.doDay1P2("src/main/resources/Day1Data.txt")) == 54076;
        }catch (IOException e){
            e.printStackTrace();
            fail("Exception thrown");
        }
    }
}
