package fileReading

import calander.day2.BallK
import calander.day2.Gamek
import calander.day2.RoundK
import java.io.File

class ReadFileToArrayByLine(val file:File) {
    fun readFileToListOfStrings():List<String> {
        val data = mutableListOf<String>()
        file.forEachLine {
            data.add(it)
        }
        return data
    }

    fun readFileToListOfGames():List<Gamek>{
        val data = mutableListOf<Gamek>()
        file.forEachLine { it ->
            val id = it.split(":")[0]
            val game = it.split(":")[1]
            val ballKS = game.split(";").map {
                rounds -> rounds.split(",").map { ball ->
                    ball.trim().split(" ")
                }.map {
                    BallK(it[1], it[0].toInt())
                }

            }

            val roundKS = ballKS.map {
                RoundK(it)
            }
            data.add(Gamek(id, roundKS))
        }
        return data
    }
}
