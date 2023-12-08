package calander.day2

import kotlinx.serialization.Serializable

@Serializable
data class Game(val id: String, val rounds: List<Round>)

@Serializable
data class Round(val balls: List<Ball>)
@Serializable
data class Ball(val colour: String, val number: Int)
