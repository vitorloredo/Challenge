package data

class SetCountrySalary(val arryData: ArrayList<Data>, val idCountry: HashMap<String, MutableList<Int>>) {

    private val baseValueConvertedSalary = -1.0

    fun managerConvertedSalary() {
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