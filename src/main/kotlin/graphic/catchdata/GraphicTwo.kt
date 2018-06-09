package graphic.catchdata

import data.Data
import graphic.data.GraphicTwoDate

class GraphicTwo(val title: String) {
    val arrayCountry = arrayListOf<String>()
    val arrayGraphicTwo = arrayListOf<GraphicTwoDate>()

    private fun counted(string: String) = arrayCountry.contains(string)

    fun setAllUnknown() {
        for (it in arrayGraphicTwo) {
            it.completeUnknown()
        }
    }

    fun setValue(data: Data) {
        val country = data.country
        val brazilMonthlySalary = data.brazilMonthlySalary.toDouble()

        if (counted(country)) {
            val indexOf = arrayCountry.indexOf(country)
            arrayGraphicTwo[indexOf].setSalary(brazilMonthlySalary)
        } else {
            arrayGraphicTwo.add(GraphicTwoDate(country))
            arrayCountry.add(country)
            val indexOf = arrayCountry.indexOf(country)
            arrayGraphicTwo[indexOf].setSalary(brazilMonthlySalary)
        }

    }

}