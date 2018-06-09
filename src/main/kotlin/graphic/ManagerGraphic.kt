package graphic

import data.ManagerData
import simplifiedclass.CountriesBrazilMonthly
import simplifiedclass.IDE


class ManagerGraphic {

    fun createHistograma() {
        GraphicOne("Brazil", "United States", "Germany","Reais")
    }

    fun creteBarIDE(title: String,ide: IDE,strX: String,strY: String){
        val createBarSet = CreateBarSet(title, strX, strY)

        var cont = 0

        for (it in ide.contPerson){
            createBarSet.setValue(it,ide.countryList[cont])
            cont += 1
        }

        createBarSet.factory()

    }

    fun createBarMonthly(title: String, managerData: ManagerData,strX:String,strY:String) {
        val allCountry = managerData.allCountry()
        val createBarSet = CreateBarSet(title, strX, strY)

        for (it in allCountry) {
            val countries = managerData.getCountriesBrazilMonthlyAnyCountry(it)

            createBarSet.setValue(countries.country, countries.amount())
        }

        createBarSet.factory()
    }
}