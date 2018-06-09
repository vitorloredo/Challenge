package graphic.data

class GraphicOneData(val title: String) {
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