package data.handle

import data.Data
import java.util.*

class SetUnknownValuesCountrySalary(private val arrayData: ArrayList<Data>,
                                    private val idCountry: HashMap<String, MutableList<Int>>) {

    private val baseValueConvertedSalary = -1.0

    fun setConvertedSalaryUnknown() {

        for (it in idCountry) {
            val idCountryUnknown = arrayListOf<Int>()
            val idList = it.value
            val idListSize = idList.size
            var allValuesSalaryCountry = 0.0

            allValuesSalaryCountry = createAverageCountryAndSearchUnknown(idList, arrayData, allValuesSalaryCountry, idCountryUnknown)

            val peopleHaveSalaryCountry = notZero(idListSize - idCountryUnknown.size)
            val averageValues = allValuesSalaryCountry / peopleHaveSalaryCountry

            setAllCountryValueUnknown(idCountryUnknown, arrayData, averageValues)
        }
    }

    private fun notZero(people: Int): Int {
        if (people == 0) {
            return 1
        }
        return people
    }

    private fun createAverageCountryAndSearchUnknown(idList: MutableList<Int>, arrayData: ArrayList<Data>,
                                                     allValuesSalaryCountry: Double,
                                                     idCountryUnknown: ArrayList<Int>): Double {
        var allValuesCont = allValuesSalaryCountry
        for (id in idList) {
            val convertedSalaryCountry = arrayData[id].convertedSalary

            if (convertedSalaryCountry != baseValueConvertedSalary) {
                allValuesCont += convertedSalaryCountry
            } else {
                idCountryUnknown.add(id)
            }
        }

        return allValuesCont
    }

    private fun setAllCountryValueUnknown(idCountryUnknown: ArrayList<Int>, arrayData: ArrayList<Data>, averageValues: Double) {
        for (id in idCountryUnknown) {
            arrayData[id].convertedSalary = averageValues
        }
    }
}