package data

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

class ReadData {

    private var cont: Int = 0
    private val arrayData = arrayListOf<Data>()
    private val managerData = ManagerData()

    fun read(): ManagerData {
        val baseName = File(".").canonicalPath
        val localFileName = FileReader("$baseName\\src\\info\\base_de_respostas_10k_amostra.csv")
        val read = BufferedReader(localFileName)

        var line = read.readLine()

        while (line != null) {
            val data = Data(line)
            arrayData.add(data)

            managerData.setIdCountry(arrayData[cont], cont)
            managerData.increaseLanguage(arrayData[cont])
            managerData.increaseIDE(arrayData[cont])



            line = read.readLine()
            cont += 1
        }

        managerData.handleBrazilianSalary(arrayData)

        println(managerData.getAverageSchool("United States",arrayData).amountBachelor())
        println(managerData.getAverageSchool("United States",arrayData).amountMaster())
        println(managerData.getAverageSchool("United States",arrayData).amountOther())


        WritData(arrayData).white()

        read.close()


        return managerData
    }


}