package data

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

class ReadData {

    private val list: MutableList<String> = mutableListOf()

    fun read() {
        val baseName = File(".").canonicalPath
        val localFileName = FileReader("$baseName\\src\\info\\base_de_respostas_10k_amostra.csv")
        val read = BufferedReader(localFileName)

        var line = read.readLine()


//        while (line != null) {
//            list.add(line)
//            line = read.readLine()
//        }

        read.close()
    }
}