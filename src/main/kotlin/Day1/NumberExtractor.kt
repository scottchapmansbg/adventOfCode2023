package Day1

class NumberExtractor {
    fun extractNumbers(data: List<String>): List<Int> {
        val numbers = data.map { findIntegers(it) }
        val rowOutput = numbers.map { it.first().toString() + it.last().toString() }
        return rowOutput.map { it.toInt() }
    }

    private fun findIntegers(input:String):List<String>{
        val numbers = mutableListOf<String>()
        val regex = Regex("[0-9]")
        val matches = regex.findAll(input)
        matches.forEach {
            numbers.add(it.value)
        }
        return numbers
    }
}

