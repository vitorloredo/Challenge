package graphic

import org.jfree.chart.ChartFactory
import org.jfree.chart.ChartUtilities
import org.jfree.chart.JFreeChart
import org.jfree.chart.plot.PlotOrientation
import org.jfree.data.category.DefaultCategoryDataset
import java.io.File
import java.io.FileOutputStream


class CreateBarStacked(val title: String){

    private var defaultCategory = DefaultCategoryDataset()

    fun setValue(name: String, value: Double){

        defaultCategory.setValue(value,name,name)
    }

    fun factory() {
        ChartFactory.createStackedBarChart(title,
                "Paises",
                "Reais",
                defaultCategory,
                PlotOrientation.VERTICAL,
                true,
                true,
                false)
    }

    private fun create(graf: JFreeChart) {
        val baseName = File(".").canonicalPath
        val file = FileOutputStream("$baseName\\src\\info\\Stacked.png")
        ChartUtilities.writeChartAsPNG(file, graf, 1550, 1400)
        file.close()
    }

}