package graphic.createchart

import org.jfree.chart.ChartFactory
import org.jfree.chart.ChartUtilities
import org.jfree.chart.JFreeChart
import org.jfree.data.general.DefaultPieDataset
import java.io.File
import java.io.FileOutputStream

class CreatePiaChart(val title: String) {

    private val defaultCategory = DefaultPieDataset()

    fun setValue(name: String, value: Double) {
        defaultCategory.setValue(name, value)
    }

    fun factory() {
        val graf = ChartFactory.createPieChart(title,
                defaultCategory,
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