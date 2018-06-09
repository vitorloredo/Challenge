package data

import graphic.GraphicOne
import graphic.GraphicTwo
import java.io.BufferedReader
import java.io.File
import java.io.FileReader

class ReadData {

    private var cont: Int = 0
    private val arrayData = arrayListOf<Data>()
    private val managerData = ManagerData()


    val graphicOne = GraphicOne("Brazil", "United States", "Germany", "Reais")
    val graphicTwo = GraphicTwo("Meia salarial")

    fun read(): ManagerData {
        val baseName = File(".").canonicalPath
        val localFileName = FileReader("$baseName\\src\\info\\base_de_respostas_10k_amostra.csv")
        val read = BufferedReader(localFileName)

        var line = read.readLine()
        line = read.readLine()

        while (line != null) {
            val data = Data(line)
            arrayData.add(data)

            managerData.setIdCountry(arrayData[cont], cont)

            graphicOne.getValue(arrayData[cont])

            graphicTwo.setValue(arrayData[cont])



            line = read.readLine()
            cont += 1
        }

        managerData.handleBrazilianSalary(arrayData)

        graphicOne.setAllUnknown()
        graphicTwo.setAllUnknown()

        //DEpois da um create Graphf


        WritData(arrayData).white()

        read.close()


        return managerData
    }


}