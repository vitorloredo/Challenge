package data.io

import data.Data
import data.ManagerData
import graphic.catchdata.*
import graphic.createGraphic.CSVPercentageFutureStudy
import java.io.BufferedReader
import java.io.File
import java.io.FileReader

class ReadData {

    private var cont: Int = 0
    private val arrayData = arrayListOf<Data>()
    private val managerData = ManagerData()

    private val chartLanguagesVSPlatform = ChartLanguagesVSPlatform()
    private val chartIDE = ChartIDE()
    private val higherEducation = HigherEducation()
    private val chartMedianSalaryInReal = ChartMedianSalaryInReal()

    private val languageStudy = CSVPercentageFutureStudy("Novo estudo de linguagem")
    private val platformStudy = CSVPercentageFutureStudy("Novo estudo de plataforma")
    private val frameworkStudy = CSVPercentageFutureStudy("Novo estudo de Framework")
    private val dataBaseStudy = CSVPercentageFutureStudy("Novo estudo Database")

    fun read() {
        val baseName = File(".").canonicalPath
        val localFileName = FileReader("$baseName\\src\\info\\base_de_respostas_10k_amostra.csv")
        val read = BufferedReader(localFileName)

        var line = read.readLine()
        line = read.readLine()

        while (line != null) {
            val data = Data(line)
            arrayData.add(data)

            managerData.setIdCountry(data, cont)

            higherEducation.insertNewData(data)
            chartIDE.insertNewData(data)
            chartLanguagesVSPlatform.setValue(data) //Not fac nao funciona direito

            languageStudy.insertNewData(data.languageWorkedWith, data.languageDesireNextYear)
            platformStudy.insertNewData(data.platformWorkedWith, data.platformDesireNextYear)
            frameworkStudy.insertNewData(data.frameworkWorkedWith, data.frameworkDesireNextYear)
            dataBaseStudy.insertNewData(data.databaseWorkedWith, data.databaseDesireNextYear)


            chartMedianSalaryInReal.insertNewData(data)

            line = read.readLine()
            cont += 1
        }

        read.close()
        managerData.handleBrazilianSalary(arrayData)
        WritData(arrayData).white()
        arrayData.clear()

        chartMedianSalaryInReal.generateChart()

        val chartDistributionSalaryInReal = ChartDistributionSalaryInReal()
        chartDistributionSalaryInReal.insertNewData(chartMedianSalaryInReal)
        chartDistributionSalaryInReal.generateChart()

        higherEducation.insertAverage(chartMedianSalaryInReal)
        higherEducation.generateChart()

        chartIDE.generateChart()

        val csvPercentageEUARegardingOthers = CSVPercentageEUAInRelationToOthers()
        csvPercentageEUARegardingOthers.insertNewData(chartMedianSalaryInReal)
        csvPercentageEUARegardingOthers.createCSV()

        languageStudy.generateCSV()
        platformStudy.generateCSV()
        frameworkStudy.generateCSV()
        dataBaseStudy.generateCSV()

    }

}