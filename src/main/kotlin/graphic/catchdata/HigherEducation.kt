package graphic.catchdata

import graphic.model.CountrySalaryMedianInReal
import data.Data
import graphic.createchart.CreateBarSet
import graphic.model.ModelHigherEducation

class HigherEducation() {

    val title = "Media do alto grau de escolaridade (Bacharelado, Mestre e Doutorado) em comparação a media salarial de alguns países"
    private val graphicFireData = ModelHigherEducation("United States")
    private var contriy = mutableListOf<CountrySalaryMedianInReal>()


    fun generateChart() {
        val createBarSet = CreateBarSet(title, "EUA/Outros paises", "Salario em reais(R$)")

        createBarSet.setValue("United States/Master", graphicFireData.medianMaster(), "")
        createBarSet.setValue("United States/Bachelor", graphicFireData.medianBachelor(), "")
        createBarSet.setValue("United States/Other", graphicFireData.medianOther(), "")

        contriy.forEach {
            createBarSet.setValue(it.country, it.median(), "")
        }

        createBarSet.factory()
    }


    fun insertNewData(data: Data) {

        val brazilMonthlySalary = data.brazilMonthlySalary
        val formalEducation = data.formalEducation

        when {
            graphicFireData.title == data.country ->
                teachingSet(formalEducation, graphicFireData, brazilMonthlySalary)
        }
    }

    fun insertAverage(chartDistributionSalaryInReal: ChartMedianSalaryInReal) {
        contriy = chartDistributionSalaryInReal.medianOfSalaries
                .filter { it.country == "Brazil" || it.country == "Belgium" }
                .toMutableList()
    }

    private fun teachingSet(formalEducation: String, graphicFireData: ModelHigherEducation, brazilMonthlySalary: String) {

        when {
            formalEducation.contains("Bachelor", true) ->
                graphicFireData.salaryListBachelor.add(brazilMonthlySalary.toDouble())

            formalEducation.contains("Master", true) ->
                graphicFireData.salaryListMaster.add(brazilMonthlySalary.toDouble())

            formalEducation.contains("Other", true) ->
                graphicFireData.salaryListOther.add(brazilMonthlySalary.toDouble())
        }
    }
}