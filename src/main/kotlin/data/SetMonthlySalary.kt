package data

import java.text.DecimalFormat
import java.util.*

class SetMonthlySalary(private val arrayData: ArrayList<Data>) {

    private val format = DecimalFormat.getCurrencyInstance(Locale("en", "US"))

    fun setAll() {
        for (it in arrayData) {
            it.monthlySalary = format.format(it.convertedSalary)
        }
    }
}