package data

import data.handle.SetUnknownValuesCountrySalary
import data.handle.CreateBrazilMonthlySalary
import data.handle.CreateMonthlySalary
import extend.isUnknown

class ManagerData {

    private val idCountry = hashMapOf<String, MutableList<Int>>()

    fun setIdCountry(data: Data, position: Int) {
        val country = data.country
        val notUnknownCountry = country.isUnknown()

        if (!notUnknownCountry) {
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

    private fun addExistCountry(country: String, position: Int) {
        val listValue = idCountry.get(country)!!
        listValue.add(position)
        idCountry[country] = listValue
    }

    private fun addNotExistCountry(country: String, position: Int) {
        val newMutableList = mutableListOf<Int>()
        newMutableList.add(position)
        idCountry[country] = newMutableList
    }

    fun handleBrazilianSalary(arrayData: ArrayList<Data>) {
        countrySalaryUnknown(arrayData)
        createMonthlySalary(arrayData)
        createBrazilMonthlySalary(arrayData)
    }

    private fun countrySalaryUnknown(arrayData: ArrayList<Data>) {
        SetUnknownValuesCountrySalary(arrayData, idCountry).setConvertedSalaryUnknown()
    }

    private fun createMonthlySalary(arrayData: ArrayList<Data>) {
        CreateMonthlySalary(arrayData).setAll()
    }

    private fun createBrazilMonthlySalary(arrayData: ArrayList<Data>) {
        CreateBrazilMonthlySalary(arrayData).setAll()
    }
}