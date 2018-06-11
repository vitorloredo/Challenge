package graphic.catchdata

import extend.isUnknown
import graphic.createchart.CreatePiaChart
import java.text.DecimalFormat

class ChartPercentageFutureStudy(val title: String) {
    var totalOfUsers: Int = 0
    var wantLearnNewLanguage: Int = 0

    fun insertNewData(workedWith: String, desireNextYear: String) {

        if (workedWith.isUnknown() || desireNextYear.isUnknown()) {
            return
        }
        val languageWorkedWith = workedWith.split(";")
        val languageDesireNextYear = desireNextYear.split(";")

        totalOfUsers += 1
        for (language in languageDesireNextYear) {
            if (!languageWorkedWith.contains(language)) {
                wantLearnNewLanguage += 1
                break
            }
        }
    }

    private fun math(): Double {

        return (wantLearnNewLanguage * 100) / totalOfUsers.toDouble()
    }

    fun generateCSV() {
        val decimalFormat = DecimalFormat("#0.00")
        val createPie = CreatePiaChart(title)

        val new = decimalFormat.format(math())
        val total = decimalFormat.format(100 - math())

        createPie.setValue("Nova linguagem : %$total", wantLearnNewLanguage.toDouble())
        createPie.setValue("Usuarios : %$new", totalOfUsers.toDouble())
        createPie.factory()
    }
}