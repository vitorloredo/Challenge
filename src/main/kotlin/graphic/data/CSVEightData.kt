package graphic.data

import java.text.DecimalFormat

class CSVEightData(val average: Double, val name: String) {
    var percentage: Double = 0.0

    private val format = DecimalFormat("#0.00")

    override fun toString(): String {
        return "%${format.format(percentage)},$name"
    }
}