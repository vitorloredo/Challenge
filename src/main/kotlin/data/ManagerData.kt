package data

import data.cont.PullAllBrazilMonthlySalary
import data.cont.IncreaseIDE
import data.cont.IncreaseLanguage
import data.set.CountrySalary
import data.set.CreateBrazilMonthlySalary
import data.set.CreateMonthlySalary
import extend.convertsStringFormatToDouble
import extend.removeFormat
import simplifiedclass.BrazilMonthlySalaryTeaching
import simplifiedclass.CountriesBrazilMonthly
import simplifiedclass.IDE
import simplifiedclass.Language

class ManagerData {

    private val idCountry = hashMapOf<String, MutableList<Int>>()
    private val contLanguage = hashMapOf<String, Int>()
    private val contIDE = hashMapOf<String, Double>()
    private val allBrazilMonthlySalaryCountryAllCountries = hashMapOf<String, List<String>>()
    val languageVsSystem = hashMapOf<String, HashMap<String, Double>>()


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

    fun handleLanguageVsSystem(data: Data) {

    }

    fun allCountry(): MutableSet<String> {
        return idCountry.keys
    }

    fun increaseIDE(data: Data) {
        //IncreaseIDE(contIDE).cont(data)
    }

    fun increaseLanguage(data: Data) {
        //IncreaseLanguage(contLanguage).cont(data)
    }

    private fun contPeopleCountry(name: String) = idCountry[name]!!.size

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
        pullAllBrazilMonthlySalary(arrayData)
    }

    private fun pullAllBrazilMonthlySalary(arrayData: ArrayList<Data>) {
        PullAllBrazilMonthlySalary(idCountry).getAll(arrayData, allBrazilMonthlySalaryCountryAllCountries)
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

    fun getCountriesBrazilMonthlyAnyCountry(countries: String): CountriesBrazilMonthly {
        val listMonthlySalary = allBrazilMonthlySalaryCountryAllCountries[countries]!!

        val listValuesInReal = arrayListOf<Double>()
        for (id in listMonthlySalary) {
            listValuesInReal.add(id.convertsStringFormatToDouble())
        }

        return CountriesBrazilMonthly(listValuesInReal, countries, contPeopleCountry(countries))
    }

    fun createIDE() = IDE(contIDE)
    fun createLanguage() = Language(contLanguage)

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