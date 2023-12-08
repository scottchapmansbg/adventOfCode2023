package Day1

import java.io.File

class Day1 {
    private val numberExtractor = NumberExtractor()

    fun part1(file: File): Int {
        val data = ReadData(file).readData()
        val numbers = numberExtractor.extractNumbers(data).sum()
        println(numbers)
        return numbers
    }

    fun part2(file: File): Int {
        val data = ReadData(file).readData()
        return numberExtractor.extractNumbersIncludeWords(data).sum()
    }

    private fun List<Int>.sum() = run { this.reduce { acc, i -> acc + i } }


}


