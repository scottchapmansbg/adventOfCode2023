package calander.day1

import Numbers.NumberExtractor
import fileReading.ReadFileToArrayByLine
import java.io.File

class Day1 {
    private val numberExtractor = NumberExtractor()

    fun part1(file: File): Int {
        val data = ReadFileToArrayByLine(file).readFileToListOfStrings()
        val numbers = numberExtractor.extractNumbers(data).sum()
        println(numbers)
        return numbers
    }

    fun part2(file: File): Int {
        val data = ReadFileToArrayByLine(file).readFileToListOfStrings()
        return numberExtractor.extractNumbersIncludeWords(data).sum()
    }

    private fun List<Int>.sum() = run { this.reduce { acc, i -> acc + i } }


}


