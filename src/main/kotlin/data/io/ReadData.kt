package data.io

import data.Data
import data.ManagerData
import graphic.catchdata.*
import java.io.BufferedReader
import java.io.File
import java.io.FileReader

class ReadData {

    private var cont: Int = 0
    private val arrayData = arrayListOf<Data>()
    private val managerData = ManagerData()

    val graphicOne = GraphicOne("Brazil", "United States", "Germany", "Reais")
    val graphicTwo = GraphicTwo("Meia de salario")
    val graphicThree = GraphicThree("languagem vs IDE")
    val graphicFour = GraphicFour("IDE")
    val graphicFive = GraphicFive("Media de pessoas que fizeram ensino superior vs renda")

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

            graphicOne.setValue(arrayData[cont])
            graphicTwo.setValue(arrayData[cont])
            graphicThree.setValue(arrayData[cont])
            graphicFour.setValue(arrayData[cont])
            graphicFive.setValues(arrayData[cont])

            line = read.readLine()
            cont += 1
        }

        managerData.handleBrazilianSalary(arrayData)

        graphicOne.setAllUnknown()
        graphicTwo.setAllUnknown()
        graphicFive.setAllUnknown()


        graphicOne.createGraphic()
        graphicTwo.createGraphic()
        //NAO FUNCIONA
        graphicThree.createGraphic()
        /////////////
        graphicFour.createGraphic()
        graphicFive.createGraphic()

        WritData(arrayData).white()

        read.close()


        return managerData
    }


}