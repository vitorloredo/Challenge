package data.io

import data.Data
import graphic.catchdata.CSVJobSearch
import data.ManagerData
import graphic.catchdata.*
import graphic.catchdata.ChartPercentageFutureStudy
import java.io.BufferedReader
import java.io.File
import java.io.FileReader

class ReadData {

    private val arrayData = arrayListOf<Data>()
    private val managerData = ManagerData()

    private val chartLanguagesVSPlatform = ChartLanguagesXPlatform()
    private val chartIDE = ChartIDE()
    private val higherEducation = HigherEducation()
    private val chartMedianSalaryInReal = ChartMedianSalaryInReal()

    private val languageStudy = ChartPercentageFutureStudy("Quantidade de pessoas que querem estudar uma nova linguagem")
    private val platformStudy = ChartPercentageFutureStudy("Quantidade de pessoas que querem estudar uma nova plataforma")
    private val frameworkStudy = ChartPercentageFutureStudy("Quantidade de pessoas que querem estudar uma nova Framework")
    private val dataBaseStudy = ChartPercentageFutureStudy("Quantidade de pessoas que querem estudar uma nova Database")

    private val jobSearch = CSVJobSearch()
    private val jobPermanence = CSVJobPermanence()

    private val hopeFiveYears = HopeFiveYears()


    fun read() {
        val baseName = File(".").canonicalPath
        val localFileName = FileReader("$baseName\\src\\info\\base_de_respostas.csv")
        val read = BufferedReader(localFileName)

        var line = read.readLine()
        line = read.readLine()

        while (line != null) {
            val data = Data(line)
            arrayData.add(data)

            managerData.setIdCountry(data)

            higherEducation.insertNewData(data)
            chartIDE.insertNewData(data)
            chartLanguagesVSPlatform.setValue(data)

            languageStudy.insertNewData(data.languageWorkedWith, data.languageDesireNextYear)
            platformStudy.insertNewData(data.platformWorkedWith, data.platformDesireNextYear)
            frameworkStudy.insertNewData(data.frameworkWorkedWith, data.frameworkDesireNextYear)
            dataBaseStudy.insertNewData(data.databaseWorkedWith, data.databaseDesireNextYear)

            jobSearch.insertNewData(data.jobSatisfaction, data.jobSearchStatus)
            jobPermanence.insertNewData(data.careerSatisfaction, data.lastNewJob)

            chartMedianSalaryInReal.insertNewData(data)

            hopeFiveYears.insertNewData(data)

            line = read.readLine()
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
        chartLanguagesVSPlatform.generateChart()

        val csvPercentageEUARegardingOthers = CSVPercentageEUAInRelationToOthers()
        csvPercentageEUARegardingOthers.insertNewData(chartMedianSalaryInReal)
        csvPercentageEUARegardingOthers.generateCSV()

        languageStudy.generateCSV()
        platformStudy.generateCSV()
        frameworkStudy.generateCSV()
        dataBaseStudy.generateCSV()

        jobSearch.generateCSV()
        jobPermanence.generateCSV()

        hopeFiveYears.generateChart()

    }

}