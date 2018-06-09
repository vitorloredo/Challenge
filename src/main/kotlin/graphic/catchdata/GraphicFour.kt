package graphic.catchdata

import data.Data

class GraphicFour(val title: String) {

    private val contIDE = hashMapOf<String,Double>()

    fun setValue(data: Data) {
        val iDE = data.iDE
        val notUnknown = notUnknown(iDE)

        if (notUnknown) {
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

    private fun notUnknown(country: String) = country != "Unknown"

}