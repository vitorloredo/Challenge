package graphic.catchdata

import data.Data
import extend.isUnknown
import graphic.createchart.CreateBarSet

class ChartIDE() {

    val title = "IDE"
    private val contIDE = hashMapOf<String, Double>()

    fun generateChart() {
        val createBarSet = CreateBarSet(title, "IDE", "Quantidade de pessoas que usam a IDE")
        for (it in contIDE.keys) {
            createBarSet.setValue(it, contIDE[it]!!, "IDE")
        }

        createBarSet.factory()
    }

    fun insertNewData(data: Data) {
        val iDE = data.iDE

        if (!iDE.isUnknown()) {
            val iDEList = extractList(iDE)

            for (name in iDEList) {
                val containsKey = contIDE.containsKey(name)

                if (containsKey) {
                    addExistIDE(name)
                } else {
                    addNotExistIDE(name)
                }
            }
        }
    }

    private fun addExistIDE(name: String) {
        var value = contIDE.get(name)!!
        value += 1

        contIDE[name] = value
    }

    private fun addNotExistIDE(name: String) {
        contIDE[name] = 1.0
    }

    private fun extractList(str: String) = str.split(";")

}