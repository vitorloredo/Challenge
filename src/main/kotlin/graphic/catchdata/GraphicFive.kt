package graphic.catchdata

import data.Data
import graphic.createGraphic.CreateBarSet
import graphic.data.GraphicFireData

class GraphicFive(val title: String) {
    private val graphicFireData = GraphicFireData("Brazil")
    private val graphicFireData2 = GraphicFireData("United States")
    private val graphicFireData3 = GraphicFireData("Germany")
    private val createBarSet = CreateBarSet(title, "Type", "Escolaridade")

    fun createGraphic() {
        createBarSet.setValue("Brazil/Bachelor", graphicFireData.amountBachelor())
        createBarSet.setValue("United States/Bachelor", graphicFireData2.amountBachelor())
        createBarSet.setValue("Germany/Bachelor", graphicFireData3.amountBachelor())

        createBarSet.setValue("Brazil/Master", graphicFireData.amountMaster())
        createBarSet.setValue("United States/Master", graphicFireData2.amountMaster())
        createBarSet.setValue("Germany/Master", graphicFireData3.amountMaster())

        createBarSet.setValue("Brazil/Other", graphicFireData.amountOther())
        createBarSet.setValue("United States/Other", graphicFireData2.amountOther())
        createBarSet.setValue("Germany/Other", graphicFireData3.amountOther())

        createBarSet.factory()
    }


    fun setValues(data: Data) {

        val brazilMonthlySalary = data.brazilMonthlySalary
        val formalEducation = data.formalEducation

        when {
            graphicFireData.title == data.country ->
                teachingSet(formalEducation, graphicFireData, brazilMonthlySalary)

            graphicFireData2.title == data.country ->
                teachingSet(formalEducation, graphicFireData2, brazilMonthlySalary)

            graphicFireData3.title == data.country ->
                teachingSet(formalEducation, graphicFireData3, brazilMonthlySalary)
        }


    }

    private fun teachingSet(formalEducation: String, graphicFireData: GraphicFireData, brazilMonthlySalary: String) {

        when {
            formalEducation.contains("Bachelor", true) ->
                graphicFireData.salaryListBachelor.add(brazilMonthlySalary.toDouble())

            formalEducation.contains("Master", true) ->
                graphicFireData.salaryListMaster.add(brazilMonthlySalary.toDouble())

            formalEducation.contains("Other", true) ->
                graphicFireData.salaryListOther.add(brazilMonthlySalary.toDouble())
        }
    }

    fun setAllUnknown() {
        graphicFireData.completeUnknown()
        graphicFireData2.completeUnknown()
        graphicFireData3.completeUnknown()
    }
}

