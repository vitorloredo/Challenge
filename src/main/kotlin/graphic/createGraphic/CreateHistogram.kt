package graphic.createGraphic

import org.jfree.chart.ChartFactory
import org.jfree.chart.ChartUtilities
import org.jfree.chart.JFreeChart
import org.jfree.chart.plot.PlotOrientation
import org.jfree.data.statistics.HistogramDataset
import java.io.File
import java.io.FileOutputStream

class CreateHistogram(private val title: String) {

    private val histogram = HistogramDataset()

    fun setValue(listDouble: DoubleArray, name: String) {

        val dm = Math.sqrt(listDouble.size.toDouble()).toInt()

        histogram.addSeries(name, listDouble, dm)
    }

    fun factory() {
        val graf = ChartFactory.createHistogram(title,
                "Paises",
                "Reais",
                histogram,
                PlotOrientation.VERTICAL,
                true,
                true,
                false)

        save(graf)
    }

    private fun save(graf: JFreeChart) {
        val baseName = File(".").canonicalPath
        val file = FileOutputStream("$baseName\\src\\info\\$title.png")
        ChartUtilities.writeChartAsPNG(file, graf, 1550, 1400)
        file.close()
    }


}