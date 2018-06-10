package data.io

import data.Data
import data.ManagerData
import graphic.catchdata.*
import graphic.createGraphic.CreateBarSet
import java.io.BufferedReader
import java.io.File
import java.io.FileReader

data class CountrySalaryMedianInReal(val country: String, val salaryInReal: ArrayList<Double>) {
    override fun equals(other: Any?): Boolean {
        val another = other as CountrySalaryMedianInReal
        return this.country == another.country
    }

    fun median(): Double {
        return salaryInReal.filter { it != -1.0 }.average()
    }
}

class ChartMedianSalaryInReal {
    var title: String = "Media dos salarios em Reais(R$)"
    var medianOfSalaries = mutableListOf<CountrySalaryMedianInReal>()

    fun insertNewData(data: Data) {
        if (data.country == "Unknown") { return }
        if (!medianOfSalaries.any { x -> x.country == data.country }) { //se nao existe o pais
            val salaryInReal = ArrayList<Double>()
            salaryInReal.add(data.brazilMonthlySalary.toDouble())
            val model = CountrySalaryMedianInReal(data.country, salaryInReal)
            medianOfSalaries.add(model)
        } else {
            val index = medianOfSalaries.indexOfFirst { it.country == data.country }
            medianOfSalaries[index].salaryInReal.add(data.brazilMonthlySalary.toDouble())
        }
    }

    fun generateChart() {
        val createBarSet = CreateBarSet(title, "Paises", "Salarios")
        medianOfSalaries.forEach { it -> createBarSet.setValue(it.country, it.salaryInReal.average()) }
        createBarSet.factory()
    }
}

class ReadData {

    private var cont: Int = 0
    private val arrayData = arrayListOf<Data>()
    private val managerData = ManagerData()

    private val graphicOne = GraphicOne("Brazil", "United States", "Germany", "Reais")
    private val graphicTwo = GraphicTwo("Meia de salario")
    private val graphicThree = GraphicThree("languagem vs IDE")
    private val graphicFour = GraphicFour("IDE")
    private val graphicFive = GraphicFive("Media de pessoas que fizeram ensino superior vs renda")

    fun read(): ManagerData {
        val baseName = File(".").canonicalPath
        val localFileName = FileReader("$baseName\\src\\info\\base_de_respostas_10k_amostra.csv")
        val read = BufferedReader(localFileName)

        val chartMedianSalaryInReal = ChartMedianSalaryInReal()

        var line = read.readLine()
        line = read.readLine()

        while (line != null) {
            val data = Data(line)
            arrayData.add(data)

            managerData.setIdCountry(data, cont)

            graphicOne.setValue(data)
            graphicTwo.setValue(data)
            graphicThree.setValue(data)
            graphicFour.setValue(data)
            graphicFive.setValues(data)

            chartMedianSalaryInReal.insertNewData(data)

            line = read.readLine()
            cont += 1
        }

        managerData.handleBrazilianSalary(arrayData)
        WritData(arrayData).white()
        arrayData.clear()

        chartMedianSalaryInReal.generateChart()

        graphicOne.setAllUnknown()
        graphicTwo.setAllUnknown()
        graphicFive.setAllUnknown()


        graphicOne.createGraphic()
        graphicTwo.createGraphic()
        //NAO FUNCIONA
        graphicThree.createGraphic()
        /////////////
        graphicFour.createGraphic()
        graphicFive.createGraphic()



        for (it in chartMedianSalaryInReal.medianOfSalaries){
            println("Helio "+it.country)

        }

        for (it in graphicTwo.arrayCountry){
            println("vitor "+it)
        }


        val csvEight = CSVEight(graphicTwo.arrayGraphicTwo, graphicTwo.arrayCountry)
        csvEight.createCSV()



        read.close()


        return managerData
    }


}