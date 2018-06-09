package data

import data.set.CountrySalary
import data.set.CreateBrazilMonthlySalary
import data.set.CreateMonthlySalary
import simplifiedclass.BrazilMonthlySalaryTeaching

class ManagerData {

    private val idCountry = hashMapOf<String, MutableList<Int>>()

    fun setIdCountry(data: Data, position: Int) {
        val country = data.country
        val notUnknown = notUnknown(country)

        if (notUnknown) {
            val containsKey = idCountry.containsKey(country)

            if (containsKey) {
                addExistCountry(country, position)
            } else {
                addNotExistCountry(country, position)
            }
        } else {
            data.convertedSalary = 0.0
        }
    }

    private fun notUnknown(str: String) = str != "Unknown"

    private fun addExistCountry(country: String, position: Int) {
        val listValue = idCountry.get(country)!!
        listValue.add(position)
        idCountry[country] = listValue
    }

    private fun addNotExistCountry(country: String, value: Int) {
        val newMutableList = mutableListOf<Int>()
        newMutableList.add(value)
        idCountry[country] = newMutableList
    }

    fun handleBrazilianSalary(arrayData: ArrayList<Data>) {
        countrySalaryUnknown(arrayData)
        createMonthlySalary(arrayData)
        createBrazilMonthlySalary(arrayData)
    }

    private fun countrySalaryUnknown(arrayData: ArrayList<Data>) {
        CountrySalary(arrayData, idCountry).setConvertedSalaryUnknown()
    }

    private fun createMonthlySalary(arrayData: ArrayList<Data>) {
        CreateMonthlySalary(arrayData).setAll()
    }

    private fun createBrazilMonthlySalary(arrayData: ArrayList<Data>) {
        CreateBrazilMonthlySalary(arrayData).setAll()
    }

    fun getAverageSchool(str: String, arrayData: ArrayList<Data>): BrazilMonthlySalaryTeaching {
        val brazilMonthlySalaryTeaching = BrazilMonthlySalaryTeaching(str)
        val country = idCountry[str]!!
        for (it in country) {
            val brazilMonthlySalary = arrayData[it].brazilMonthlySalary
            if (arrayData[it].formalEducation.contains("Bachelor", true)) {
                brazilMonthlySalaryTeaching.salaryListBachelor.add(brazilMonthlySalary)
            }

            if (arrayData[it].formalEducation.contains("Master", true)) {
                brazilMonthlySalaryTeaching.salaryListMaster.add(brazilMonthlySalary)
            }

            if (arrayData[it].formalEducation.contains("Other", true)) {
                brazilMonthlySalaryTeaching.salaryListOther.add(brazilMonthlySalary)
            }
        }
        return brazilMonthlySalaryTeaching
    }
}