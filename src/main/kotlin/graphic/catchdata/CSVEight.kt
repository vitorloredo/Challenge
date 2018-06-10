package graphic.catchdata

import graphic.data.CSVEightData
import graphic.data.GraphicTwoDate
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import java.text.DecimalFormat

class CSVEight(val countryList: ArrayList<GraphicTwoDate>, arrayCountry: ArrayList<String>) {
    val arrayPerse = arrayListOf<CSVEightData>()

    val indexEUA = arrayCountry.indexOf("United States")
    val valueEUA = countryList[indexEUA].amount()

    fun createCSV() {
        val baseName = File(".").canonicalPath
        val localFileName = FileWriter("$baseName\\src\\info\\Media salario EUA em all.csv")
        val white = BufferedWriter(localFileName)

        white.write("Pais,Persentual em relacao ao EUA")
        white.newLine()

        for (it in arrayPerse) {
            white.write(it.toString())
            white.newLine()
        }

        white.close()

    }

    init {
        for (it in countryList) {
            arrayPerse.add(CSVEightData(it.amount(), it.title))
        }
        average()
    }

    private fun average() {
        for (it in arrayPerse) {
            it.percentage = (it.average * 100) / valueEUA
        }
    }
}