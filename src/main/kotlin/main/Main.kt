package main

import data.ReadData
import graphic.ManagerGraphic


private val readData = ReadData()

fun main(args: Array<String>) {
    val rt = Runtime.getRuntime()

    val totalMemory = rt.totalMemory()

    val arrayData = readData.read()
    val managerData = readData.managerData


    val names = listOf("Brazil", "United States", "Germany")

    val managerGraphic = ManagerGraphic(managerData, "Reais")
    managerGraphic.createHistogram(names, names)
    managerGraphic.createBar()

    println(rt.freeMemory() - totalMemory)

}
