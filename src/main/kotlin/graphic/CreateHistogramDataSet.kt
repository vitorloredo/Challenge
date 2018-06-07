package graphic

import org.jfree.chart.ChartFactory
import org.jfree.chart.ChartUtilities
import org.jfree.chart.JFreeChart
import org.jfree.chart.plot.PlotOrientation
import org.jfree.data.statistics.HistogramDataset
import java.io.File
import java.io.FileOutputStream

class CreateHistogramDataSet(private val title: String) {

    private val histogramDataset = HistogramDataset()

    fun setValue(listDouble: List<Double>, name: String) {
        val doubleArray = DoubleArray(listDouble.size)
        var id = 0

        for (it in listDouble) {
            doubleArray[id] = it
            id += 1
        }

        val dm = Math.sqrt(listDouble.size.toDouble()).toInt()

        histogramDataset.addSeries(name, doubleArray, dm)
    }

    fun factory() {
        val graf = ChartFactory.createHistogram(title,
                "Paises",
                "Reais",
                histogramDataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false)

        create(graf)
    }

    private fun create(graf: JFreeChart) {
        val baseName = File(".").canonicalPath
        val file = FileOutputStream("$baseName\\src\\info\\Histogra.png")
        ChartUtilities.writeChartAsPNG(file, graf, 1550, 1400)
        file.close()
    }


}