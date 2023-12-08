package calander.day2

import fileReading.ReadFileToArrayByLine
import java.io.File

class Day2 {
    fun part1(file: File): Int{
        val gameData = ReadFileToArrayByLine(file).readFileToListOfGames()
        val bag = mapOf("red" to 12,"green" to 13, "blue" to 14)
        val winningGames = gameData.filter { it.isValid(bag) }
        val answer = winningGames.sumOfIds()
        return answer
    }

    private fun List<Game>.sumOfIds(): Int{
        val numbers = this.map { Integer.parseInt(it.id.split(" ")[1]) }
        return numbers.sum()
    }
    private fun Game.isValid(bag:Map<String,Int>): Boolean {
        for (round in  this.rounds){
            for (ball in round)
            {
                if (!bag.containsKey(ball.colour) || (ball.number > bag[ball.colour]!!))
                {
                    return false
                }
            }
        }
        return true
    }
}


