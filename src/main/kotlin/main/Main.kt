package main

import data.ReadData
import data.WritData

fun main(args: Array<String>) {
    val arrayData = ReadData().read()
    WritData(arrayData).white()
}
