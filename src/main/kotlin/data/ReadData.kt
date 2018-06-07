package data

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

class ReadData {

    private val list: MutableList<String> = mutableListOf()
    private var cont: Int = 1
    private val arryData = arrayListOf<Data>()
    private val managerData = ManagerData()

    fun read() {
        val baseName = File(".").canonicalPath
        val localFileName = FileReader("$baseName\\src\\info\\base_de_respostas_10k_amostra.csv")
        val read = BufferedReader(localFileName)

        var line = read.readLine()
        arryData.add(Data(line))


        while (line != null) {
            list.add(line)
            arryData.add(Data(line))
            managerData.idCountry(arryData[cont],cont)
            line = read.readLine()
            cont += 1
        }

        read.close()
    }
}