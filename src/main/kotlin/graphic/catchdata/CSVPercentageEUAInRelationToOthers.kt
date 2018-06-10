package graphic.catchdata

import data.CountrySalaryMedianInReal
import graphic.data.CSVEightData
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter

class CSVPercentageEUAInRelationToOthers {
    val title = "Media salario dos EUA em percentual em relacao outros paises"
    var salariesDistrubuition = mutableListOf<CountrySalaryMedianInReal>()

    fun insertNewData(chartMedianSalaryInReal: ChartMedianSalaryInReal) {
        chartMedianSalaryInReal.medianOfSalaries.ta { it.salaryInReal ==  "United States"}
    }

    private val arrayData = arrayListOf<CSVEightData>()
    private val indexEUA = arrayCountry.indexOf("United States")
    private val valueEUA = countryList[indexEUA].amount()

//    init {
//        for (it in countryList) {
//            arrayData.add(CSVEightData(it.amount(), it.title))
//        }
//        average()
//    }

    fun createCSV() {
        val baseName = File(".").canonicalPath
        val localFileName = FileWriter("$baseName\\src\\info\\Media salario EUA em all.csv")
        val white = BufferedWriter(localFileName)

        white.write("Pais,Persentual em relacao ao EUA")
        white.newLine()

        for (it in arrayData) {
            white.write(it.toString())
            white.newLine()
        }

        white.close()

    }

    private fun average() {
        for (it in arrayData) {
            it.percentage = (it.average * 100) / valueEUA
        }
    }
}