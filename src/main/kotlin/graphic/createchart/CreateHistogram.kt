package graphic.createchart

import org.jfree.chart.ChartFactory
import org.jfree.chart.ChartUtilities
import org.jfree.chart.JFreeChart
import org.jfree.chart.plot.DefaultDrawingSupplier
import org.jfree.chart.plot.PlotOrientation
import org.jfree.chart.plot.XYPlot
import org.jfree.chart.renderer.xy.StandardXYBarPainter
import org.jfree.chart.renderer.xy.XYBarRenderer
import org.jfree.data.statistics.HistogramDataset
import java.awt.Color
import java.awt.Paint
import java.io.File
import java.io.FileOutputStream

class CreateHistogram(private val title: String) {

    private val histogramDataSet = HistogramDataset()

    fun setValue(name: String, list: DoubleArray) {
        histogramDataSet.addSeries(name, list, 256)
    }

    fun factory() {
        val jfreechart = ChartFactory.createHistogram(title,
                null, null, histogramDataSet, PlotOrientation.VERTICAL, true, true, false)

        val xyplot = jfreechart.plot as XYPlot
        xyplot.foregroundAlpha = 0.85f
        val xybarrenderer = xyplot.renderer as XYBarRenderer
        xybarrenderer.barPainter = StandardXYBarPainter()
        val paintArray = arrayOf<Paint>(
                Color(-0x7f010000, true), Color(-0x7fff0100, true), Color(-0x7fffff01, true))

        xyplot.drawingSupplier = DefaultDrawingSupplier(
                paintArray,
                DefaultDrawingSupplier.DEFAULT_FILL_PAINT_SEQUENCE,
                DefaultDrawingSupplier.DEFAULT_OUTLINE_PAINT_SEQUENCE,
                DefaultDrawingSupplier.DEFAULT_STROKE_SEQUENCE,
                DefaultDrawingSupplier.DEFAULT_OUTLINE_STROKE_SEQUENCE,
                DefaultDrawingSupplier.DEFAULT_SHAPE_SEQUENCE)

        save(jfreechart)
    }

    private fun save(graf: JFreeChart) {
        val baseName = File(".").canonicalPath
        val file = FileOutputStream("$baseName\\src\\info\\$title.png")
        ChartUtilities.writeChartAsPNG(file, graf, 1550, 1400)
        file.close()
    }
}