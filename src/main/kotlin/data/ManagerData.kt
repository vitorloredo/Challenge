package data

import data.cont.*
import data.set.*
import extend.removeFormat
import simplifiedclass.CountriesBrazilMonthly
import simplifiedclass.IDE
import simplifiedclass.Language

class ManagerData {

    private val idCountry = hashMapOf<String, MutableList<Int>>()
    private val contLanguage = hashMapOf<String, Int>()
    private val contIDE = hashMapOf<String, Int>()
    private val contBrazilMonthlySalaryCountry = hashMapOf<String, List<String>>()

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

    fun allCountry(): MutableSet<String> {
        return idCountry.keys
    }

    fun increaseIDE(data: Data) {
        IncreaseIDE(contIDE).cont(data)
    }

    fun increaseLanguage(data: Data) {
        IncreaseLanguage(contLanguage).cont(data)
    }

    private fun contPeopleCountry(name: String) = idCountry[name]!!.size

    private fun notUnknown(country: String) = country != "Unknown"

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
        contAllBrazilMonthlySalary(arrayData)
    }

    private fun contAllBrazilMonthlySalary(arrayData: ArrayList<Data>) {
        GetAllBrazilMonthlySalary(idCountry).getAll(arrayData, contBrazilMonthlySalaryCountry)
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

    fun getCountriesBrazilMonthly(countries: String): CountriesBrazilMonthly {
        val listMonthlySalary = contBrazilMonthlySalaryCountry[countries]!!

        val listValuesInReal = arrayListOf<Double>()
        for (id in listMonthlySalary) {
            listValuesInReal.add(id
                    .removeFormat()
                    .replace(".", "")
                    .toDouble())
        }

        return CountriesBrazilMonthly(listValuesInReal)
    }

    fun createIDE() = IDE(contIDE)
    fun createLanguage() = Language(contLanguage)

}