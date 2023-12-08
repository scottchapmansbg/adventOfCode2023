import Day1.Day1
import java.io.File
import kotlin.test.Test

class Day1Test {
    @Test
    fun `part 1`() {
        val day1 = Day1()
        val result = day1.process(File("src/main/resources/Day1Data.txt"))
        println("result = $result")

    }


}
