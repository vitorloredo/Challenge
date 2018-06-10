package main

import data.Quarries
import data.io.ReadData
import graphic.ManagerGraphic
import java.util.*


private val readData = ReadData()

fun main(args: Array<String>) {
    readData.read()

    Quarries().seatchTwoString("JobSatisfaction", "JobSearchStatus")
}