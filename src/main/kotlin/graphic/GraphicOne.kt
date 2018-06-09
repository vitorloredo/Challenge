package graphic

import simplifiedclass.CountriesBrazilMonthly


class GraphicOne(country1: String,
                 country2: String,
                 country3: String,
                 title: String) {


    private val country = "Country"
    private val brazilMonthly = "BrazilMonthlySalary"
    val histogram = CreateHistogram(title)

    init {
        var listCountry = Quarrie().searchTwoDouble(country, brazilMonthly, country1)

        val brazilBrazilMonthly = CountriesBrazilMonthly(listCountry, country1, listCountry.size)

        listCountry = Quarrie().searchTwoDouble(country, brazilMonthly, country2)

        val unitedBrazilMonthly = CountriesBrazilMonthly(listCountry, country2, listCountry.size)

        listCountry = Quarrie().searchTwoDouble(country, brazilMonthly, country3)

        val germanyBrazilMonthly = CountriesBrazilMonthly(listCountry, country3, listCountry.size)

        histogram.setValue(brazilBrazilMonthly.value, brazilBrazilMonthly.country)

        histogram.setValue(unitedBrazilMonthly.value, unitedBrazilMonthly.country)

        histogram.setValue(germanyBrazilMonthly.value, germanyBrazilMonthly.country)

        histogram.factory()
    }
}