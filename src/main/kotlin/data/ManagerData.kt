package data

class ManagerData {
    private val idCountry = hashMapOf<String, MutableList<Int>>()

    fun idCountry(data: Data, value: Int) {
        val exist = exist(data.country)

        if (exist) {
            addExist(data.country, value)
        } else {
            addNotExist(data.country,value)
        }

    }

    private fun exist(str: String): Boolean {
        if (idCountry.containsKey(str)) {
            return true
        }
        return false
    }

    private fun addExist(str: String, value: Int) {
        val listValue = idCountry.get(str)
        listValue!!.add(value)
        idCountry[str] = listValue
    }

    private fun addNotExist(str: String, value: Int) {
        val newMutableList = mutableListOf<Int>()
        newMutableList.add(value)
        idCountry[str] = newMutableList
    }
}