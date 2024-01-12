package calander.day2

import kotlinx.serialization.Serializable

@Serializable
data class Gamek(val id: String, val roundKS: List<RoundK>)


@Serializable
data class RoundK(val ballKS: List<BallK>)
@Serializable
data class BallK(val colour: String, val number: Int) {
    fun findMaxBall() {
        TODO()
    }
}
