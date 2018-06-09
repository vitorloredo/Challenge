package graphic

import data.Data

class GraphicOne(val country1: String,
                 val country2: String,
                 val country3: String,
                 title: String) {

    val graphicOneData1 = GraphicOneData(country1)
    val graphicOneData2 = GraphicOneData(country2)
    val graphicOneData3 = GraphicOneData(country3)

    fun setAllUnknown() {
        graphicOneData1.completeUnknown()
        graphicOneData2.completeUnknown()
        graphicOneData3.completeUnknown()
    }

    fun setValue(data: Data) {
        val country = data.country
        val brazilMonthlySalary = data.brazilMonthlySalary.toDouble()
        when (country) {
            country1 -> {
                graphicOneData1.setSalary(brazilMonthlySalary)
            }
            country2 -> {
                graphicOneData2.setSalary(brazilMonthlySalary)
            }
            country3 -> {
                graphicOneData3.setSalary(brazilMonthlySalary)
            }
        }
    }

}

class GraphicOneData(val title: String) {
    val salaryTotal = arrayListOf<Double>()
    private val salaryUnknown = arrayListOf<Double>()
    var contPerson = salaryTotal.size

    fun setSalary(double: Double) {
        val valueUnknown = -1.0
        if (double == valueUnknown) {
            salaryUnknown.add(0.0)
        } else {
            salaryTotal.add(double)
        }
    }

    fun completeUnknown() {
        val amount = amount()
        for (it in salaryUnknown) {
            salaryTotal.add(amount)
        }
        salaryUnknown.clear()
    }


    fun amount() = salaryTotal.average()

}