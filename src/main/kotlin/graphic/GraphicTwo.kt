package graphic

import data.Data


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

class GraphicTwoDate(val title: String) {
    val salaryTotal = arrayListOf<Double>()
    private val salaryUnknown = arrayListOf<Double>()
    var contPerson = salaryTotal.size

    fun setSalary(double: Double) {
        val valueUnknown = -1.0
        if (double == valueUnknown) {
            salaryUnknown.add(0.0)
        } else {
            salaryTotal.add(double)
        }
    }

    fun completeUnknown() {
        val amount = amount()
        for (it in salaryUnknown) {
            salaryTotal.add(amount)
        }
        salaryUnknown.clear()
    }

    fun amount() = salaryTotal.average()
}