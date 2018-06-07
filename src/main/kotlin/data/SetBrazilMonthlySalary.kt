package data

import java.text.DecimalFormat
import java.util.*

class SetBrazilMonthlySalary(private val arrayData: ArrayList<Data>) {
    private val format = DecimalFormat.getCurrencyInstance(Locale("pt", "br"))

    fun setAll() {
        for (it in arrayData) {
            val salaryBrazil = it.convertedSalary * 3.81
            val salaryBrazilFormat = format.format(salaryBrazil)
            it.brazilMonthlySalary = salaryBrazilFormat
        }
    }
}