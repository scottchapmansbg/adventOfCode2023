package Day1

import java.io.File

class Day1 {
    fun process(file: File): Int {
        val data = ReadData(file).readData()
        val numberExtractor = NumberExtractor()
        val numbers = numberExtractor.extractNumbers(data).sum()
        println(numbers)
        return numbers
    }

    private fun List<Int>.sum() = run { this.reduce { acc, i -> acc + i } }


}


