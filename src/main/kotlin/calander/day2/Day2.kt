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

    private fun Gamek.findLargestOfEachColour():RoundK{
        val numberOfBallsRed = BallK("",this.roundKS.map { round -> round.ballKS.maxOf { ball -> ball.returnNumberOfColour("red")  } }.maxOfOrNull {it}!!)
        val numberOfBallsGreen = BallK("",this.roundKS.map { round -> round.ballKS.maxOf { ball -> ball.returnNumberOfColour("green")  } }.maxOfOrNull {it}!!)
        val numberOfBallsBlue = BallK("",this.roundKS.map { round -> round.ballKS.maxOf { ball -> ball.returnNumberOfColour("blue")  } }.maxOfOrNull {it}!!)
        return RoundK(listOf(numberOfBallsBlue,numberOfBallsGreen,numberOfBallsRed))
    }


   private fun BallK.returnNumberOfColour(colour:String) : Int{
       return if (this.colour == colour){
           this.number
       } else{
           0
       }
   }

    private fun RoundK.multiplyOutBalls():Int {
        return this.getBallNumber().reduce{acc, i -> acc * i}
    }

    private fun RoundK.getBallNumber():List<Int>{
        return this.ballKS.map { it.number }
    }

    private fun List<Gamek>.sumOfIds(): Int{
        val numbers = this.map { Integer.parseInt(it.id.split(" ")[1]) }
        return numbers.sum()
    }

    private fun Gamek.isValid(bag:Map<String,Int>): Boolean {
        for (round in  this.roundKS){
            for (ball in round.ballKS)
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


