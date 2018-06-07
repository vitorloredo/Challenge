package graphic

import org.jfree.chart.ChartFactory
import org.jfree.chart.ChartUtilities
import org.jfree.chart.JFreeChart
import org.jfree.chart.plot.PlotOrientation
import org.jfree.data.category.DefaultCategoryDataset
import java.io.File
import java.io.FileOutputStream


class CreateBarStacked(val title: String){

    private var defaultCategoryDataSet = DefaultCategoryDataset()

    fun setValue(name: String, value: Double, id: Int){

    }

    fun factory() {
        ChartFactory.createStackedBarChart(title,
                "Paises",
                "Reais",
                defaultCategoryDataSet,
                PlotOrientation.VERTICAL,
                true,
                true,
                false)
    }

    private fun create(graf: JFreeChart) {
        val baseName = File(".").canonicalPath
        val file = FileOutputStream("$baseName\\src\\info\\Barra em cima.png")
        ChartUtilities.writeChartAsPNG(file, graf, 1550, 1400)
        file.close()
    }

}