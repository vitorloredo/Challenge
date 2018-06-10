package graphic.catchdata

import data.Data
import extend.isUnknown
import graphic.createGraphic.CreateBarSet
import graphic.model.ModelLanguageInIDE

class ChartLanguagesVSPlatform() {
    val title = "languagem vs IDE"
    private val arrayLanguage = arrayListOf<String>()
    private val arrayGraphicThree = arrayListOf<ModelLanguageInIDE>()
    private val createBarSet = CreateBarSet("Teste", "TsteX", "TExtY")

    fun createGraphic() {
        for (it in arrayGraphicThree) {
            for (id in it.hashMap.keys)
                createBarSet.setValue(it.title, it.have(id))
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
        for (it in platformWorkedWith) {
            if (counted(it)) {
                val indexOf = arrayLanguage.indexOf(it)
                arrayGraphicThree[indexOf].setLanguage(languageWorkedWith)

            } else {
                arrayGraphicThree.add(ModelLanguageInIDE(it))
                arrayLanguage.add(it)

                val indexOf = arrayLanguage.indexOf(it)
                arrayGraphicThree[indexOf].setAll(languageWorkedWith)
            }
        }
    }

    private fun counted(string: String) = arrayLanguage.contains(string)

}