package graphic.createchart

import org.jfree.chart.ChartFactory
import org.jfree.chart.ChartUtilities
import org.jfree.chart.JFreeChart
import org.jfree.chart.plot.PlotOrientation
import org.jfree.data.category.DefaultCategoryDataset
import java.io.File
import java.io.FileOutputStream


class CreateBarStacked(val title: String) {

    private var defaultCategory = DefaultCategoryDataset()

    fun setValue(name: String, value: Double, nameGroup: String) {
        defaultCategory.setValue(value, name, nameGroup)
    }

    fun factory() {
        val createStackedBarChart = ChartFactory.createStackedBarChart(title,
                "Paises",
                "Reais",
                defaultCategory,
                PlotOrientation.VERTICAL,
                true,
                true,
                false)

        create(createStackedBarChart)
    }

    private fun create(graf: JFreeChart) {
        val baseName = File(".").canonicalPath
        val file = FileOutputStream("$baseName\\src\\info\\$title.png")
        ChartUtilities.writeChartAsPNG(file, graf, 2550, 2400)
        file.close()
    }
}