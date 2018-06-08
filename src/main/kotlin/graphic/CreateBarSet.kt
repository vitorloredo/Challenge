package graphic

import org.jfree.chart.ChartFactory
import org.jfree.chart.ChartUtilities
import org.jfree.chart.JFreeChart
import org.jfree.chart.plot.PlotOrientation
import org.jfree.data.category.DefaultCategoryDataset
import java.io.File
import java.io.FileOutputStream

class CreateBarSet(val title: String) {

    private val histogramDataset = DefaultCategoryDataset()

    fun setValue(name: String, value: Double, id: Int) {
        histogramDataset.addValue(value, name, id)
    }

    fun factory() {
        val graf = ChartFactory.createBarChart(title,
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
        val file = FileOutputStream("$baseName\\src\\info\\Barra.png")
        ChartUtilities.writeChartAsPNG(file, graf, 1550, 1400)
        file.close()
    }

}