import calander.day2.Day2
import java.io.File
import kotlin.test.Test

class day2Test {
    @Test
    fun `part 1`() {
        val day2 = Day2()
        val result = day2.part1(File("src/main/resources/Day2Data.txt"))
        assert(result == 2720)
        println("result = $result")

    }
}
