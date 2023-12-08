package Day1

import java.io.File

class ReadData(val file:File) {
    fun readData():List<String> {
        val data = mutableListOf<String>()
        file.forEachLine {
            data.add(it)
        }
        return data
    }

}
