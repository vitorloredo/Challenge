package main

import data.ReadData
import graphic.GraphicOne
import graphic.GraphicTwo
import graphic.ManagerGraphic


private val readData = ReadData()

fun main(args: Array<String>) {
    var rt = Runtime.getRuntime()

    val totalMemory = rt.totalMemory()

    readData.read()

    println(rt.freeMemory() - totalMemory)

    rt = Runtime.getRuntime()



    val managerGraphic = ManagerGraphic()

    managerGraphic.createHistograma()
    //GraphicTwo("")

    println(rt.freeMemory() - totalMemory)

//
//    val brazilBrazilMonthly = managerData.getCountriesBrazilMonthlyAnyCountry("Brazil")
//    val unitedBrazilMonthly = managerData.getCountriesBrazilMonthlyAnyCountry("United States")
//    val germanyBrazilMonthly = managerData.getCountriesBrazilMonthlyAnyCountry("Germany")
//
//    val managerGraphic = ManagerGraphic()
//
//    managerGraphic.createHistograma(brazilBrazilMonthly, unitedBrazilMonthly, germanyBrazilMonthly, "Reais")
//    managerGraphic.createBarMonthly(managerData = managerData,title = "Media de salarios",strX =  "Paises", strY = "Reais")
////
//    val ides = managerData.createIDE()
//
//    managerGraphic.creteBarIDE("IDE",ides,"IDE","Teste")
//
//    val arrayBrazilMonthlySalaryTeaching = readData.arrayBrazilMonthlySalaryTeaching
//
//
//
//
//    val anguage = managerData.createLanguage()




}
