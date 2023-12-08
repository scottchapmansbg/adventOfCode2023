package calander.day2

import kotlinx.serialization.Serializable

@Serializable
data class Game(val id: String, val rounds: List<List<Ball>>)
@Serializable
data class Ball(val colour: String, val number: Int)
