package graphic

import data.ManagerData


class ManagerGraphic(private val managerGraphic: ManagerData,
                     title: String) {

    private val createHistogramDataSet = CreateHistogramDataSet(title)

    fun createHistogram(name: List<String>, countries: List<String>) {

        var cont = 0

        for (it in countries) {
            val listValueCountries = managerGraphic.getCountriesValue(it)
            createHistogramDataSet.setValue(listValueCountries, name[cont])
            cont += 1
        }

        createHistogramDataSet.factory()
    }

}