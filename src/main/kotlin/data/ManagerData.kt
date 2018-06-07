package data

class ManagerData {

    private val idCountry = hashMapOf<String, MutableList<Int>>()

    private val baseValueConvertedSalary = -1.0

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
        for (it in idCountry) {
            val idCountryUnknown = arrayListOf<Int>()
            val idList = it.value
            val idListSize = idList.size
            var allValuesSalaryCountry = 0.0

            allValuesSalaryCountry = createAverageCountry(idList, arryData, allValuesSalaryCountry, idCountryUnknown)

            val peopleHaveSalaryCountry = notZero(idListSize - idCountryUnknown.size)
            val averageValues = allValuesSalaryCountry / peopleHaveSalaryCountry

            setAllCountryValueUnknown(idCountryUnknown, arryData, averageValues)
        }
    }

    private fun notZero(people: Int): Int {
        if (people == 0) {
            return 1
        }
        return people
    }

    private fun createAverageCountry(idList: MutableList<Int>, arryData: ArrayList<Data>, allValuesSalaryCountry: Double, idCountryUnknown: ArrayList<Int>): Double {
        var allValuesCont = allValuesSalaryCountry
        for (id in idList) {
            val convertedSalaryCountry = arryData[id].convertedSalary


            if (convertedSalaryCountry != baseValueConvertedSalary) {
                allValuesCont += convertedSalaryCountry
            } else {
                idCountryUnknown.add(id)
            }
        }

        return allValuesCont
    }

    private fun setAllCountryValueUnknown(idCountryUnknown: ArrayList<Int>, arryData: ArrayList<Data>, averageValues: Double) {
        for (id in idCountryUnknown) {
            arryData[id].convertedSalary = averageValues
        }
    }
}