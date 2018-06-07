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
            data.country = "Unknown"
            data.convertedSalary = 0.0
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

    fun managerConvertedSalary(arryData: ArrayList<Data>) {
        SetCountrySalary(arryData,idCountry).managerConvertedSalary()
    }

    fun managerMonthlySalary(arryData: ArrayList<Data>){
        setMonthlySalary(arryData).setAll()
    }
}