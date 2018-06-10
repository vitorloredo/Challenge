package graphic.catchdata

import data.Data
import graphic.createGraphic.CreateHistogram
import graphic.data.GraphicOneData

class GraphicOne(private val country1: String,
                 private val country2: String,
                 private val country3: String,
                 title: String) {

    private val graphicOneData1 = GraphicOneData(country1)
    private val graphicOneData2 = GraphicOneData(country2)
    private val graphicOneData3 = GraphicOneData(country3)
    private val createHistogram = CreateHistogram(title)

    fun createGraphic() {
        val toDoubleArrayGraphic1 = graphicOneData1.salaryTotal.toDoubleArray()
        createHistogram.setValue(toDoubleArrayGraphic1, graphicOneData1.title)

        val toDoubleArrayGraphic2 = graphicOneData2.salaryTotal.toDoubleArray()
        createHistogram.setValue(toDoubleArrayGraphic2, graphicOneData2.title)

        val toDoubleArrayGraphic3 = graphicOneData3.salaryTotal.toDoubleArray()
        createHistogram.setValue(toDoubleArrayGraphic3, graphicOneData3.title)

        createHistogram.factory()
    }

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