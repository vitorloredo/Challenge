package data

import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths

class Quarries {

    private val baseName = File(".").canonicalPath
    private val newBufferedReader = Files.newBufferedReader(Paths.get("$baseName\\src\\info\\base_de_respostas_final.csv"))

    private val csvParser = CSVParser(newBufferedReader, CSVFormat.DEFAULT.withDelimiter(',')
            .withQuote('\"')
            .withIgnoreEmptyLines(false)
            .withFirstRecordAsHeader()
            .withTrim())

    fun seatchTwoString(what: String, what2: String): ArrayList<ArrayList<String>> {
        val array = arrayListOf<String>()
        val array2 = arrayListOf<String>()
        val superArray = arrayListOf<ArrayList<String>>()

        for (it in csvParser) {
            val value = it.get(what)
            array.add(value)
            val value2 = it.get(what2)
            array2.add(value2)
        }

        superArray.add(array)
        superArray.add(array2)
        return superArray
    }
}