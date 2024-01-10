package calander.day2

import fileReading.ReadFileToArrayByLine
import java.io.File

class Day2 {
    fun part1(file: File): Int {
        val gameData = ReadFileToArrayByLine(file).readFileToListOfGames()
        val bag = mapOf("red" to 12, "green" to 13, "blue" to 14)
        val winningGames = gameData.filter { it.isValid(bag) }
        return winningGames.sumOfIds()
    }

    fun part2(file:File): Int {
        val gameData = ReadFileToArrayByLine(file).readFileToListOfGames()
        val gamePower=  mutableListOf<Int>()
        for (game in gameData) {
            print(game.findLargestOfEachColour())
            println(game.findLargestOfEachColour().multiplyOutBalls())
          gamePower.add(game.findLargestOfEachColour().multiplyOutBalls())

        }
        return gamePower.sum()
    }

    private fun Game.findLargestOfEachColour():Round{
        val numberOfBallsRed = Ball("",this.rounds.map { round -> round.balls.maxOf { ball -> ball.returnNumberOfColour("red")  } }.maxOfOrNull {it}!!)
        val numberOfBallsGreen = Ball("",this.rounds.map { round -> round.balls.maxOf { ball -> ball.returnNumberOfColour("green")  } }.maxOfOrNull {it}!!)
        val numberOfBallsBlue = Ball("",this.rounds.map { round -> round.balls.maxOf { ball -> ball.returnNumberOfColour("blue")  } }.maxOfOrNull {it}!!)
        return Round(listOf(numberOfBallsBlue,numberOfBallsGreen,numberOfBallsRed))
    }


   private fun Ball.returnNumberOfColour(colour:String) : Int{
       return if (this.colour == colour){
           this.number
       } else{
           0
       }
   }

    private fun Round.multiplyOutBalls():Int {
        return this.getBallNumber().reduce{acc, i -> acc * i}
    }

    private fun Round.getBallNumber():List<Int>{
        return this.balls.map { it.number }
    }

    private fun List<Game>.sumOfIds(): Int{
        val numbers = this.map { Integer.parseInt(it.id.split(" ")[1]) }
        return numbers.sum()
    }

    private fun Game.isValid(bag:Map<String,Int>): Boolean {
        for (round in  this.rounds){
            for (ball in round.balls)
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


