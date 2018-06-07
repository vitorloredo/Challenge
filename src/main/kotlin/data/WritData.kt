package data

import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter

class WritData(private val arrayData: ArrayList<Data>) {
    fun white(){
        val baseName = File(".").canonicalPath
        val localFileName = FileWriter("$baseName\\src\\info\\base_de_respostas_final.csv")
        val white = BufferedWriter(localFileName)

        for (it in arrayData){
            white.write(it.toString())
            white.newLine()
        }


    }
}