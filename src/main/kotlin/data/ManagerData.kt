package data

class ManagerData {

    private val idCountry = hashMapOf<String, MutableList<Int>>()
    private val contLanguage = hashMapOf<String, Int>()
    private lateinit var arrayData: ArrayList<Data>

    fun contLanguage(data: Data) {
        val languageWorkedWith = data.languageWorkedWith
        val notUnknown = notUnknown(languageWorkedWith)

        if (notUnknown) {
            val listLanguage = extractLanguage(languageWorkedWith)

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

    private fun addExistLanguage(name: String) {
        var value = contLanguage.get(name)!!
        value += 1

        contLanguage[name] = value
    }

    private fun addNotExistLanguage(name: String) {
        contLanguage[name] = 1
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

    private fun extractLanguage(languageWorkedWith: String) = languageWorkedWith.split(";")

    private fun notUnknown(country: String) = country != "Unknown"

    fun allCountry(): MutableSet<String> {
        return idCountry.keys
    }

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
        val listValuesInReais = arrayListOf<Double>()

        val idList = idCountry.get(countries)!!

        for (id in idList) {
            listValuesInReais.add(arrayData[id].brazilMonthlySalary
                    .replace("R\$ ", "")
                    .replace(".", "")
                    .replace(",", "")
                    .toDouble())
        }

        return listValuesInReais
    }
}