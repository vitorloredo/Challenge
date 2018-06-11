package graphic.catchdata

import graphic.model.CountrySalaryMedianInReal
import graphic.createchart.CreateHistogram

class ChartDistributionSalaryInReal {

    var title: String = "Distribuicao dos salarios em Reias(R$)"
    var salariesDistribution = mutableListOf<CountrySalaryMedianInReal>()

    fun insertNewData(chartMedianSalaryInReal: ChartMedianSalaryInReal) {
        salariesDistribution = chartMedianSalaryInReal.medianOfSalaries.filter { it ->
            it.country == "Brazil" || it.country == "United States" || it.country == "Germany"
        }.toMutableList()
    }

    fun generateChart() {
        val createHistogram = CreateHistogram(title)
        salariesDistribution.forEach { it ->
            createHistogram.setValue(it.removeInvalidNumbers().toDoubleArray(), it.country)
        }
        createHistogram.factory()
    }
}