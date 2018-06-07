package graphic

import data.ManagerData


class ManagerGraphic(private val managerData: ManagerData,
                     title: String) {

    private val createHistogramDataSet = CreateHistogramDataSet(title)
    private val createBarSet = CreateBarSet(title)

    fun createHistogram(name: List<String>, countries: List<String>) {

        var cont = 0

        for (it in countries) {
            val listValueCountries = managerData.getCountriesValue(it)
            createHistogramDataSet.setValue(listValueCountries, name[cont])
            cont += 1
        }

        createHistogramDataSet.factory()
    }

    fun createBar() {
        val allCountry = managerData.allCountry()
        var id = 0

        for (it in allCountry) {
            var totalSum = 0.0
            val countriesValue = managerData.getCountriesValue(it)

            for (id in countriesValue) {
                totalSum += id
            }

            val averageCountry = totalSum / countriesValue.size

            createBarSet.setValue(it, averageCountry, id)
            id += 1
        }

        createBarSet.factory()
    }


}