package data

class ManagerData {
    private val idCountry = hashMapOf<String, MutableList<Int>>()

    fun idCountry(data: Data, value: Int) {
        val country = data.country
        val notEmpty = country != ""

        if (notEmpty) {
            val containsKey = idCountry.containsKey(country)

            if (containsKey) {
                addExist(country, value)
            } else {
                addNotExist(country, value)
            }
        } else {
            val valueBase = -1.0
            data.convertedSalary = valueBase
        }
    }

    private fun addExist(country: String, value: Int) {
        val listValue = idCountry.get(country)
        listValue!!.add(value)
        idCountry[country] = listValue
    }

    private fun addNotExist(country: String, value: Int) {
        val newMutableList = mutableListOf<Int>()
        newMutableList.add(value)
        idCountry[country] = newMutableList
    }
}