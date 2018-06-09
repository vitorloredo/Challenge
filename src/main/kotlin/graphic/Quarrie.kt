package graphic

import extend.convertsStringFormatToDouble
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths

class Quarrie {

    private val baseName = File(".").canonicalPath
    private val newBufferedReader = Files.newBufferedReader(Paths.get("$baseName\\src\\info\\base_de_respostas_final.csv"))

    private val csvParser = CSVParser(newBufferedReader, CSVFormat.DEFAULT.withDelimiter(',')
            .withQuote('\"')
            .withIgnoreEmptyLines(false)
            .withFirstRecordAsHeader()
            .withTrim())


    fun searchTwoDouble(value1: String, value2: String, what: String): ArrayList<Double> {
        val array = arrayListOf<Double>()
        for (it in csvParser) {
            val value = it.get(value1)
            if (value == what) {
                array.add(it.get(value2).convertsStringFormatToDouble())
            }
        }
        return array
    }


}