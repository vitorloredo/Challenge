package graphic.catchdata

import data.Data
import graphic.data.GraphicFireData

class GraphicFive(val title: String) {
    val graphicFireData = GraphicFireData("Brazil")
    val graphicFireData2 = GraphicFireData("United States")
    val graphicFireData3 = GraphicFireData("Germany")


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

