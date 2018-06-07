package Graphic

import org.jfree.chart.ChartFactory
import org.jfree.chart.ChartUtilities
import org.jfree.chart.JFreeChart
import org.jfree.chart.plot.PlotOrientation
import org.jfree.data.statistics.HistogramDataset
import java.io.FileOutputStream

class CreateHistogramDataset(val title: String,
                             val xAxisLabel: String,
                             val yAxisLabel: String) {

    private val histogramDataset = HistogramDataset()

    fun setValue(listDouble: List<Double>, name: String) {
        val doubleArray = doubleArrayOf()
        var id = 0

        for (it in listDouble) {
            doubleArray[id] = it
            id += 1
        }

        val dm = Math.sqrt(listDouble.size.toDouble()).toInt()

        histogramDataset.addSeries(name, doubleArray, dm)
    }

    fun factory() {
        val graf = ChartFactory.createHistogram("teste",
                "Real",
                "Paises",
                histogramDataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false)


        create(graf)
    }

    private fun create(graf: JFreeChart) {
        val file = FileOutputStream("Histogra.png")
        ChartUtilities.writeChartAsPNG(file, graf, 550, 400)
        file.close()
    }


}