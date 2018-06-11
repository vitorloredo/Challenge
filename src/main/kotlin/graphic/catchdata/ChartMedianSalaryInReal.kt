package graphic.catchdata

import graphic.model.CountrySalaryMedianInReal
import data.Data
import extend.isUnknown
import graphic.createGraphic.CreateBarSet

class ChartMedianSalaryInReal {
    var title: String = "Media dos salarios em Reais(R$)"
    var medianOfSalaries = mutableListOf<CountrySalaryMedianInReal>()

    fun insertNewData(data: Data) {
        if (data.country.isUnknown()) {
            return
        }

        val notContainsCountry = !medianOfSalaries.any { x -> x.country == data.country }

        if (notContainsCountry) { //se nao existe o pais
            val salaryInReal = ArrayList<Double>()
            salaryInReal.add(data.brazilMonthlySalary.toDouble())
            val model = CountrySalaryMedianInReal(data.country, salaryInReal)
            medianOfSalaries.add(model)

        } else {
            val index = medianOfSalaries.indexOfFirst { it.country == data.country }
            medianOfSalaries[index].salaryInReal.add(data.brazilMonthlySalary.toDouble())
        }
    }

    fun generateChart() {
        val createBarSet = CreateBarSet(title, "Paises", "Salarios")
        medianOfSalaries.forEach { it -> createBarSet.setValue(it.country, it.median(),"Paises") }
        createBarSet.factory()
    }
}