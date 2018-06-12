package graphic.catchdata

import data.Data
import extend.isUnknown
import graphic.createchart.CreateBarStacked
import graphic.model.ModelLanguageInPlatform

class ChartLanguagesXPlatform() {

    val title = "Linguagem x IDE"
    private val arrayLanguage = arrayListOf<String>()
    private val arrayGraphicThree = arrayListOf<ModelLanguageInPlatform>()
    private val createBarSet = CreateBarStacked("Linguagem de programação x Sistema operacional",
            "Sistema operacional","Quantidade de pessoas")

    fun generateChart() {
        for (it in arrayGraphicThree) {
            for (id in it.hashMap.keys) {
                createBarSet.setValue(it.title, it.have(id), id)
            }
        }

        createBarSet.factory()
    }

    fun setValue(data: Data) {
        val platformWorkedWith = data.platformWorkedWith

        val languageWorkedWith = data.languageWorkedWith

        val notUnknown = platformWorkedWith.isUnknown()
        val notUnknown2 = languageWorkedWith.isUnknown()

        if (!notUnknown && !notUnknown2) {
            getPlatform(platformWorkedWith.split(";"), languageWorkedWith.split(";"))
        }
    }

    private fun getPlatform(platformWorkedWith: List<String>, languageWorkedWith: List<String>) {
        for (it in languageWorkedWith) {
            if (counted(it)) {
                val indexOf = arrayLanguage.indexOf(it)
                arrayGraphicThree[indexOf].setPlatform(platformWorkedWith)

            } else {
                arrayGraphicThree.add(ModelLanguageInPlatform(it))
                arrayLanguage.add(it)

                val indexOf = arrayLanguage.indexOf(it)
                arrayGraphicThree[indexOf].setAllPlatform(platformWorkedWith)
            }
        }
    }

    private fun counted(string: String) = arrayLanguage.contains(string)

}