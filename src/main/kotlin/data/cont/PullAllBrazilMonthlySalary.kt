package data.cont

import data.Data

class PullAllBrazilMonthlySalary (private val idCountry: HashMap<String, MutableList<Int>>) {
    fun getAll(arrayData: ArrayList<Data>, contBrazilMonthlySalaryCountry: HashMap<String, List<String>>) {
        val allCountry = allCountry()
        for (name in allCountry) {
            val listValue = arrayListOf<String>()

            for (index in idCountry.get(name)!!) {
                listValue.add(arrayData[index].brazilMonthlySalary)
            }
            contBrazilMonthlySalaryCountry[name] = listValue
        }
    }

    private fun allCountry(): MutableSet<String> {
        return idCountry.keys
    }

}