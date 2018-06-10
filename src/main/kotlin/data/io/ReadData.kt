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

    private val chartThree = ChartLanguagesPlatform("languagem vs IDE")
    private val chartFour = ChartFour("IDE")
    private val chartFive = ChartFive("Media de pessoas que fizeram ensino superior vs renda")
    private val chartMedianSalaryInReal = ChartMedianSalaryInReal()

    fun read(): ManagerData {
        val baseName = File(".").canonicalPath
        val localFileName = FileReader("$baseName\\src\\info\\base_de_respostas_10k_amostra.csv")
        val read = BufferedReader(localFileName)


        var line = read.readLine()
        line = read.readLine()

        while (line != null) {
            val data = Data(line)
            arrayData.add(data)

            managerData.setIdCountry(data, cont)

//            chartThree.setValue(data)
//            chartFour.setValue(data)
//            chartFive.setValues(data)

            chartMedianSalaryInReal.insertNewData(data)

            line = read.readLine()
            cont += 1
        }

        managerData.handleBrazilianSalary(arrayData)
        WritData(arrayData).white()
        arrayData.clear()

        chartMedianSalaryInReal.generateChart()
        val chartDistributionSalaryInReal = ChartDistributionSalaryInReal()
        chartDistributionSalaryInReal.insertNewData(chartMedianSalaryInReal)
        chartDistributionSalaryInReal.generateChart()


//        chartFive.setAllUnknown()
//
//

//        //NAO FUNCIONA
//        chartThree.createGraphic()
//        /////////////
//        chartFour.createGraphic()
//        chartFive.createGraphic()


        val csvPercentageEUARegardingOthers = CSVPercentageEUAInRelationToOthers()
        csvPercentageEUARegardingOthers.insertNewData(chartMedianSalaryInReal)
        csvPercentageEUARegardingOthers.createCSV()


        read.close()


        return managerData
    }


}