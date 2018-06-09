package graphic.data

//sum
class GraphicThreeData(val platformWorkedWith: String) {

    val hashMap = hashMapOf<String, Int>()

    fun setLanguage(brazilMonthlySalary: List<String>) {
        for (it in brazilMonthlySalary) {
            if (contains(it)) {
                hashMap[it] = hashMap[it]!! + 1
            } else {
                hashMap[it] = 1
            }
        }
    }

    fun contains(string: String) = hashMap.contains(string)

    fun setAll(languageWorkedWith: List<String>) {
        for (it in languageWorkedWith) {
            hashMap[it] = 1
        }
    }
}
