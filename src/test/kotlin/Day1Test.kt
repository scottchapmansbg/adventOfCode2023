import Day1.Day1
import java.io.File
import kotlin.test.Test

class Day1Test {
    @Test
    fun `part 1`() {
        val day1 = Day1()
        val result = day1.part1(File("src/main/resources/Day1Data.txt"))
        assert(result == 54561)
        println("result = $result")

    }

    @Test
    fun `part 2`() {
        val day1 = Day1()
        val result = day1.part2(File("src/main/resources/Day1Data.txt"))
        println("result = $result")

    }


}
