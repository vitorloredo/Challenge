package data

import graphic.GraphicOne
import graphic.GraphicTwo
import simplifiedclass.BrazilMonthlySalaryTeaching
import java.io.BufferedReader
import java.io.File
import java.io.FileReader

class ReadData {

    private var cont: Int = 0
    private val arrayData = arrayListOf<Data>()
    private val managerData = ManagerData()
//    val arrayBrazilMonthlySalaryTeaching = arrayListOf<BrazilMonthlySalaryTeaching>()

    val graphicOne = GraphicOne("Brazil", "United States", "Germany","Reais")
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

            //managerData.increaseLanguage(arrayData[cont])
            //managerData.increaseIDE(arrayData[cont])

            line = read.readLine()
            cont += 1
        }

        managerData.handleBrazilianSalary(arrayData)

        graphicOne.setAllUnknown()
        graphicTwo.setAllUnknown()

        //arrayBrazilMonthlySalaryTeaching.add(managerData.getAverageSchool("Brazil",arrayData))
        //arrayBrazilMonthlySalaryTeaching.add(managerData.getAverageSchool("United States",arrayData))
        //arrayBrazilMonthlySalaryTeaching.add(managerData.getAverageSchool("Germany",arrayData))

        WritData(arrayData).white()

        read.close()


        return managerData
    }


}