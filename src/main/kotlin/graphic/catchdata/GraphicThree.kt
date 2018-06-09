package graphic.catchdata

import data.Data
import graphic.data.GraphicThreeData

class GraphicThree(val title: String) {

    val arrayLanguage = arrayListOf<String>()
    val arrayGraphicThree = arrayListOf<GraphicThreeData>()

    fun setValue(data: Data) {
        val platformWorkedWith = data.platformWorkedWith

        val languageWorkedWith = data.languageWorkedWith

        val notUnknown = notUnknown(platformWorkedWith)
        val notUnknown2 = notUnknown(languageWorkedWith)

        if (notUnknown && notUnknown2) {
            getPlatform(platformWorkedWith.split(";"), languageWorkedWith.split(";"))
        }
    }

    private fun getPlatform(platformWorkedWith: List<String>, languageWorkedWith: List<String>) {
        for (it in platformWorkedWith) {
            if (counted(it)) {
                val indexOf = arrayLanguage.indexOf(it)
                arrayGraphicThree[indexOf].setLanguage(languageWorkedWith)

            } else {
                arrayGraphicThree.add(GraphicThreeData(it))
                arrayLanguage.add(it)

                val indexOf = arrayLanguage.indexOf(it)
                arrayGraphicThree[indexOf].setAll(languageWorkedWith)
            }
        }
    }

    private fun counted(string: String) = arrayLanguage.contains(string)

    private fun notUnknown(country: String) = country != "Unknown"

}