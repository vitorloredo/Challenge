package data

import extend.removeFormat

class ManagerData {

    private val idCountry = hashMapOf<String, MutableList<Int>>()
    private val contLanguage = hashMapOf<String, Int>()
    private lateinit var arrayData: ArrayList<Data>
    private val contIDE = hashMapOf<String, Int>()

    fun contIDE(data: Data) {
        val iDE = data.iDE
        val notUnknown = notUnknown(iDE)

        if (notUnknown) {
            val iDEList = extractList(iDE)

            for (name in iDEList) {
                val containsKey = contIDE.containsKey(name)

                if (containsKey) {
                    addExistIDE(name)
                } else {
                    addNotExistIDE(name)
                }
            }
        }
    }

    fun contLanguage(data: Data) {
        val languageWorkedWith = data.languageWorkedWith
        val notUnknown = notUnknown(languageWorkedWith)

        if (notUnknown) {
            val listLanguage = extractList(languageWorkedWith)

            for (name in listLanguage) {
                val containsKey = contLanguage.containsKey(name)

                if (containsKey) {
                    addExistLanguage(name)
                } else {
                    addNotExistLanguage(name)
                }
            }
        }
    }

    fun idCountry(data: Data, value: Int) {
        val country = data.country
        val notUnknown = notUnknown(country)

        if (notUnknown) {
            val containsKey = idCountry.containsKey(country)

            if (containsKey) {
                addExistCountry(country, value)
            } else {
                addNotExistCountry(country, value)
            }
        } else {
            data.country = "Unknown"
            data.convertedSalary = 0.0
        }
    }

    fun allCountry(): MutableSet<String> {
        return idCountry.keys
    }

    private fun addExistLanguage(name: String) {
        var value = contLanguage.get(name)!!
        value += 1

        contLanguage[name] = value
    }

    private fun addNotExistLanguage(name: String) {
        contLanguage[name] = 1
    }

    private fun addExistIDE(name: String) {
        var value = contIDE.get(name)!!
        value += 1

        contIDE[name] = value
    }

    private fun addNotExistIDE(name: String) {
        contIDE[name] = 1
    }

    private fun extractList(str: String) = str.split(";")

    private fun notUnknown(country: String) = country != "Unknown"

    private fun addExistCountry(country: String, value: Int) {
        val listValue = idCountry.get(country)!!

        listValue.add(value)
        idCountry[country] = listValue
    }

    private fun addNotExistCountry(country: String, value: Int) {
        val newMutableList = mutableListOf<Int>()

        newMutableList.add(value)
        idCountry[country] = newMutableList
    }

    fun manager(arrayData: ArrayList<Data>) {
        this.arrayData = arrayData
        managerConvertedSalary()
        managerMonthlySalary()
        managerBrazilMonthlySalary()
    }

    private fun managerConvertedSalary() {
        SetCountrySalary(arrayData, idCountry).managerConvertedSalary()
    }

    private fun managerMonthlySalary() {
        SetMonthlySalary(arrayData).setAll()
    }

    private fun managerBrazilMonthlySalary() {
        SetBrazilMonthlySalary(arrayData).setAll()
    }

    fun getCountriesValue(countries: String): List<Double> {
        val listValuesInReal = arrayListOf<Double>()

        val idList = idCountry.get(countries)!!

        for (id in idList) {
            listValuesInReal.add(arrayData[id].brazilMonthlySalary
                    .removeFormat()
                    .toDouble())
        }
        return listValuesInReal
    }
}