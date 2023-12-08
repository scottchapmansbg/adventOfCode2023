package fileReading

import calander.day2.Ball
import calander.day2.Game
import calander.day2.Round
import java.io.File

class ReadFileToArrayByLine(val file:File) {
    fun readFileToListOfStrings():List<String> {
        val data = mutableListOf<String>()
        file.forEachLine {
            data.add(it)
        }
        return data
    }

    fun readFileToListOfGames():List<Game>{
        val data = mutableListOf<Game>()
        file.forEachLine { it ->
            val id = it.split(":")[0]
            val game = it.split(":")[1]
            val balls = game.split(";").map {
                rounds -> rounds.split(",").map { ball ->
                    ball.trim().split(" ")
                }.map {
                    Ball(it[1], it[0].toInt())
                }

            }

            val rounds = balls.map {
                Round(it)
            }
            data.add(Game(id, rounds))
        }
        return data
    }
}
