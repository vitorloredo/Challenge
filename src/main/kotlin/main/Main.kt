package main

import data.ReadData
import data.WritData
import graphic.ManagerGraphic

private val readData = ReadData()

fun main(args: Array<String>) {
    val arrayData = readData.read()
    val managerData = readData.managerData
    WritData(arrayData).white()


    val names = listOf("Brazil","United States","Germany")

    ManagerGraphic(managerData,"Reais").createHistogram(names,names)

}
