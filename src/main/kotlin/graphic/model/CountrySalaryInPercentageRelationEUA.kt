package graphic.model

import java.text.DecimalFormat

class CountrySalaryInPercentageRelationEUA(val country: String,
                                           private val euaAverageSalary: Double,
                                           private val SalaryAverage: Double) {

    private val decimalFormat = DecimalFormat("#0.00")

    fun percentage(): Double {
        return (SalaryAverage * 100) / euaAverageSalary
    }

    override fun toString(): String {
        return "$country,%${decimalFormat.format(percentage()).replace(",",".")}"
    }
}