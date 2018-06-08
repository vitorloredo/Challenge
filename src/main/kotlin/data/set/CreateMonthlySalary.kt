package data.set

import data.Data
import java.text.DecimalFormat
import java.util.*

class CreateMonthlySalary(private val arrayData: ArrayList<Data>) {

    private val format = DecimalFormat.getCurrencyInstance(Locale("en", "US"))

    fun setAll() {
        for (it in arrayData) {
            it.monthlySalary = format.format(it.convertedSalary/12)
        }
    }
}