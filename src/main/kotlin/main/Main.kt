package main

import data.ReadData
import graphic.ManagerGraphic


private val readData = ReadData()

fun main(args: Array<String>) {
    val rt = Runtime.getRuntime()

    val totalMemory = rt.totalMemory()

    val managerData = readData.read()

    val brazilBrazilMonthly = managerData.getCountriesBrazilMonthlyAnyCountry("Brazil")
    val unitedBrazilMonthly = managerData.getCountriesBrazilMonthlyAnyCountry("United States")
    val germanyBrazilMonthly = managerData.getCountriesBrazilMonthlyAnyCountry("Germany")

    val managerGraphic = ManagerGraphic()

    managerGraphic.createHistograma(brazilBrazilMonthly, unitedBrazilMonthly, germanyBrazilMonthly, "Reais")

    managerGraphic.createBarMonthly(managerData = managerData,title = "Media de salarios")



    val ides = managerData.createIDE()
    val anguage = managerData.createLanguage()



    println(rt.freeMemory() - totalMemory)

}
