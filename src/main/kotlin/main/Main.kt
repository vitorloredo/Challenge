package main

import data.ReadData
import data.WritData
import graphic.ManagerGraphic
import java.time.Clock.system



private val readData = ReadData()

fun main(args: Array<String>) {
    val rt = Runtime.getRuntime()

    val totalMemory = rt.totalMemory()

    val arrayData = readData.read()
    val managerData = readData.managerData
    WritData(arrayData).white()


    val names = listOf("Brazil","United States","Germany")

    val managerGraphic = ManagerGraphic(managerData, "Reais")
    managerGraphic.createHistogram(names,names)
    managerGraphic.createBar()

    println(rt.freeMemory() - totalMemory )

}
