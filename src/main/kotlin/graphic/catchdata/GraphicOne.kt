package graphic.catchdata

import data.Data
import graphic.data.GraphicOneData

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