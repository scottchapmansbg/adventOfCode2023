package Numbers

class NumberExtractor {
    fun extractNumbers(data: List<String>): List<Int> {
        val numbers = data.map { it.findIntegers() }
        val rowOutput = numbers.map { it.first().toString() + it.last().toString() }
        return rowOutput.map { Integer.parseInt(it) }
    }

    fun extractNumbersIncludeWords(data: List<String>): List<Int> {
        val numbers = data.map { it.findIntegersFromWordsAndNumbers() }
        val rowOutput = numbers.map { it.first().toString() + it.last().toString() }
        return rowOutput.map { Integer.parseInt(it) }
    }

    private fun String.findIntegers():List<String>{
        val numbers = mutableListOf<String>()
        val regex = Regex("[0-9]")
        val matches = regex.findAll(this)
        matches.forEach {
            numbers.add(it.value)
        }
        return numbers
    }

    private fun String.findIntegersFromWordsAndNumbers():List<Int>{
        val numbers = mutableListOf<Int>()
        val regex = Regex("[0-9]|one|two|three|four|five|six|seven|eight|nine")
        val matches = regex.findAll(this)
        matches.forEach {
            numbers.add(it.value.toInt())
        }
        return numbers
    }

    private fun String.toInt() : Int{
        val wordsToInt = mapOf(
            "one" to 1,
            "two" to 2,
            "three" to 3,
            "four" to 4,
            "five" to 5,
            "six" to 6,
            "seven" to 7,
            "eight" to 8,
            "nine" to 9
        )
        val regex = Regex("[0-9]")
        return if(wordsToInt.keys.contains(this)){
            wordsToInt[this]!!
        } else if (regex.matches(this)){
            Integer.parseInt(this)
        } else{
            throw Exception("Not a number")
        }
    }


//return when(val testString = this){
//    wordsToInt.keys.contains(testString) -> {
//        wordsToInt[this]!!
//    }
//    regex.matches(this).toString() -> this.toInt()
//    else -> throw Exception("Not a number")

}

