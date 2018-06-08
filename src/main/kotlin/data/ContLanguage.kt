package data

class ContLanguage(val contLanguage: HashMap<String, Int>) {
    fun cont(data: Data){
        val languageWorkedWith = data.languageWorkedWith
        val notUnknown = notUnknown(languageWorkedWith)

        if (notUnknown) {
            val listLanguage = extractList(languageWorkedWith)

            for (name in listLanguage) {
                val containsKey = contLanguage.containsKey(name)

                if (containsKey) {
                    addExistLanguage(name)
                } else {
                    addNotExistLanguage(name)
                }
            }
        }
    }

    private fun addExistLanguage(name: String) {
        var value = contLanguage.get(name)!!
        value += 1

        contLanguage[name] = value
    }

    private fun addNotExistLanguage(name: String) {
        contLanguage[name] = 1
    }

    private fun extractList(str: String) = str.split(";")

    private fun notUnknown(country: String) = country != "Unknown"
}