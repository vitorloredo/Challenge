package graphic

import data.ManagerData
import simplifiedclass.CountriesBrazilMonthly


class ManagerGraphic {

    fun createHistograma(brazilMonthly: CountriesBrazilMonthly,
                         brazilMonthly2: CountriesBrazilMonthly,
                         brazilMonthly3: CountriesBrazilMonthly,
                         title: String) {
        val histogram = CreateHistogram(title)

        histogram.setValue(brazilMonthly.value, brazilMonthly.country)

        histogram.setValue(brazilMonthly2.value, brazilMonthly2.country)

        histogram.setValue(brazilMonthly3.value, brazilMonthly3.country)

        histogram.factory()

    }

    fun createBarMonthly(title: String, managerData: ManagerData) {
        val allCountry = managerData.allCountry()
        val createBarSet = CreateBarSet(title)

        var cont = 0

        for (it in allCountry) {
            val countries = managerData.getCountriesBrazilMonthlyAnyCountry(it)

            createBarSet.setValue(countries.country, countries.amount(), cont)

            cont += 1
        }

        createBarSet.factory()
    }
}