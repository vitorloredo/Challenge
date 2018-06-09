package graphic

import data.Data

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

class GraphicFireData(val title: String) {
    var salaryListBachelor = arrayListOf<Double>()
        private set(value) {}
    var salaryListMaster = arrayListOf<Double>()
        private set(value) {}
    var salaryListOther = arrayListOf<Double>()
        private set(value) {}

    fun completeUnknown() {
        salaryListBachelor = unknown(salaryListBachelor)
        salaryListMaster = unknown(salaryListMaster)
        salaryListOther = unknown(salaryListOther)
    }

    private fun unknown(array: ArrayList<Double>): ArrayList<Double> {
        val countZero = array.count { it == -1.0 }
        array.removeAll { it == -1.0 }
        val amount = array.average()
        for (i in 0..countZero) {
            array.add(amount)
        }
        return array
    }

    fun amountBachelor() = salaryListBachelor.average()

    fun amountMaster() = salaryListMaster.average()

    fun amountOther() = salaryListOther.average()
}