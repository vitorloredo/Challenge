package data

class ManagerData {

    private val idCountry = hashMapOf<String, MutableList<Int>>()
    private lateinit var arrayData: ArrayList<Data>

    fun contLanguage(){

    }

    fun idCountry(data: Data, value: Int) {
        val country = data.country
        val notEmpty = country != ""

        if (notEmpty) {
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

    private fun addExistCountry(country: String, value: Int) {
        val listValue = idCountry.get(country)
        listValue!!.add(value)
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