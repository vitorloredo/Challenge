package graphic.catchdata

import graphic.model.CountrySalaryMedianInReal
import graphic.createchart.CreateHistogram

class ChartDistributionSalaryInReal {

    var title: String = "Frequência dos salários em Reais(R\$)"
    var salariesDistribution = mutableListOf<CountrySalaryMedianInReal>()

    fun insertNewData(chartMedianSalaryInReal: ChartMedianSalaryInReal) {
        salariesDistribution = chartMedianSalaryInReal.medianOfSalaries.filter { it ->
            it.country == "Brazil" || it.country == "Canada" || it.country == "Germany"
        }.toMutableList()
    }

    fun generateChart() {
        val createHistogram = CreateHistogram(title)
        salariesDistribution.forEach { it ->
            createHistogram.setValue(it.country,it.removeInvalidNumbers().toDoubleArray())
        }
        createHistogram.factory()
    }
}