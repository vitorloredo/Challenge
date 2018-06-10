package graphic.createGraphic

import org.jfree.chart.ChartFactory
import org.jfree.chart.ChartUtilities
import org.jfree.chart.JFreeChart
import org.jfree.chart.plot.PlotOrientation
import org.jfree.data.category.DefaultCategoryDataset
import java.io.File
import java.io.FileOutputStream

class CreateBarSet(private val title: String,
                   private val strX: String,
                   private val strY: String) {

    private val defaultCategory = DefaultCategoryDataset()

    fun setValue(name: String, value: Double) {
        defaultCategory.addValue(value, name, name)
    }

    fun factory() {
        val graf = ChartFactory.createBarChart(title,
                strX,
                strY,
                defaultCategory,
                PlotOrientation.VERTICAL,
                true,
                true,
                false)

        create(graf)
    }

    private fun create(graf: JFreeChart) {
        val baseName = File(".").canonicalPath
        val file = FileOutputStream("$baseName\\src\\info\\$title.png")
        ChartUtilities.writeChartAsPNG(file, graf, 1550, 1400)
        file.close()
    }

}