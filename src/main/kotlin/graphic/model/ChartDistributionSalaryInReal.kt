package graphic.model

import data.CountrySalaryMedianInReal
import graphic.catchdata.ChartMedianSalaryInReal
import graphic.createGraphic.CreateHistogram

class ChartDistributionSalaryInReal {
    var title: String = "Distribuicao dos salarios em Reias(R$)"
    var salariesDistrubuition = mutableListOf<CountrySalaryMedianInReal>()

    fun insertNewData(chartMedianSalaryInReal: ChartMedianSalaryInReal) {
        salariesDistrubuition = chartMedianSalaryInReal.medianOfSalaries.filter { it ->
            it.country == "Brazil" || it.country == "United States" || it.country == "Germany"
        }.toMutableList()
    }

    fun generateChart() {
        val createHistogram = CreateHistogram(title)
        salariesDistrubuition.forEach { it ->
            createHistogram.setValue(it.removeInvalidNumbers.toDoubleArray(), it.country)
        }
        createHistogram.factory()
    }
}