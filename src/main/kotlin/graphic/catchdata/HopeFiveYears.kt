package graphic.catchdata

import data.Data
import extend.isUnknown
import graphic.createchart.CreatePiaChart

class HopeFiveYears {
    val title = "Hope Five Years"
    private val contHope = hashMapOf<String, Double>()

    fun generateChart() {
        val createBarSet = CreatePiaChart(title)
        for (it in contHope.keys) {
            createBarSet.setValue(it, contHope[it]!!)
        }

        createBarSet.factory()
    }

    fun insertNewData(data: Data) {
        val hope = data.hopeFiveYears

        if (!hope.isUnknown()) {
            val containsKey = contHope.containsKey(hope)
            if (containsKey) {
                addExistHope(hope)
            } else {
                addNotExistIDE(hope)
            }
        }
    }

    private fun addExistHope(name: String) {
        var value = contHope.get(name)!!
        value += 1

        contHope[name] = value
    }

    private fun addNotExistIDE(name: String) {
        contHope[name] = 1.0
    }
}