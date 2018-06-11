package graphic.model

class ModelLanguageInPlatform(val title: String) {

    val hashMap = hashMapOf<String, Int>()

    fun setPlatform(brazilMonthlySalary: List<String>) {
        for (it in brazilMonthlySalary) {
            if (contains(it)) {
                hashMap[it] = hashMap[it]!! + 1
            } else {
                hashMap[it] = 1
            }
        }
    }

    fun have(string: String) = hashMap[string]!!.toDouble()

    fun contains(string: String) = hashMap.contains(string)

    fun setAllPlatform(languageWorkedWith: List<String>) {
        for (it in languageWorkedWith) {
            hashMap[it] = 1
        }
    }
}