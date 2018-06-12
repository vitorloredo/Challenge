package graphic.catchdata

import graphic.model.CountrySalaryInPercentageRelationEUA
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter


class CSVPercentageEUAInRelationToOthers {

    val title = "Media salário dos EUA em percentual em relação a outros países"
    private val arrayCountrySalary = arrayListOf<CountrySalaryInPercentageRelationEUA>()

    fun insertNewData(chartMedianSalaryInReal: ChartMedianSalaryInReal) {
        val eua = chartMedianSalaryInReal.medianOfSalaries.first { it.country == "United States" }

        arrayCountrySalary.add(CountrySalaryInPercentageRelationEUA(eua.country, eua.median(), eua.median()))

        val contries = chartMedianSalaryInReal.medianOfSalaries
                .filter { it.country != "United States" }
                .toMutableList()

        contries.forEach {
            arrayCountrySalary.add(CountrySalaryInPercentageRelationEUA(it.country, eua.median(), it.median()))
        }
    }

    fun generateCSV() {
        val baseName = File(".").canonicalPath
        val localFileName = FileWriter("$baseName\\src\\info\\$title.csv")
        val white = BufferedWriter(localFileName)

        white.write("Pais,Percentual em relacao ao EUA")
        white.newLine()

        for (it in arrayCountrySalary) {
            white.write(it.toString())
            white.newLine()
        }

        white.close()
    }
}