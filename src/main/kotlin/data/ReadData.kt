package data

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

class ReadData {

    private val list: MutableList<String> = mutableListOf()
    private var cont: Int = 0
    private val arrayData = arrayListOf<Data>()
    val managerData = ManagerData()

    fun read(): ArrayList<Data> {
        val baseName = File(".").canonicalPath
        val localFileName = FileReader("$baseName\\src\\info\\base_de_respostas_10k_amostra.csv")
        val read = BufferedReader(localFileName)

        var line = read.readLine()

        while (line != null) {
            list.add(line)
            arrayData.add(Data(line))
            managerData.idCountry(arrayData[cont], cont)
            managerData.contLanguage(arrayData[cont])
            line = read.readLine()
            cont += 1
        }

        managerData.manager(arrayData)

        read.close()
        return arrayData
    }
}