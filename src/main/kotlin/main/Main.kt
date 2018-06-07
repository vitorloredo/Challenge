package main

import data.ReadData
import data.WritData

private val readData = ReadData()

fun main(args: Array<String>) {
    val arrayData = readData.read()
    val managerData = readData.managerData
    WritData(arrayData).white()
}
