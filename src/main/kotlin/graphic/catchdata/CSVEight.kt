package graphic.catchdata

import graphic.data.CSVEightData
import graphic.data.GraphicTwoDate
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter

class CSVEight(countryList: ArrayList<GraphicTwoDate>, arrayCountry: ArrayList<String>) {
    private val arrayData = arrayListOf<CSVEightData>()
    private val indexEUA = arrayCountry.indexOf("United States")
    private val valueEUA = countryList[indexEUA].amount()

    init {
        for (it in countryList) {
            arrayData.add(CSVEightData(it.amount(), it.title))
        }
        average()
    }

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