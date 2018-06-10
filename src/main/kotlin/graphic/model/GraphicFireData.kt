package graphic.model

class GraphicFireData(val title: String) {
    var salaryListBachelor = arrayListOf<Double>()
        private set(value) {}
    var salaryListMaster = arrayListOf<Double>()
        private set(value) {}
    var salaryListOther = arrayListOf<Double>()
        private set(value) {}

    fun completeUnknown() {
        salaryListBachelor = unknown(salaryListBachelor)
        salaryListMaster = unknown(salaryListMaster)
        salaryListOther = unknown(salaryListOther)
    }

    private fun unknown(array: ArrayList<Double>): ArrayList<Double> {
        val countZero = array.count { it == -1.0 }
        array.removeAll { it == -1.0 }
        val amount = array.average()
        for (i in 0..countZero) {
            array.add(amount)
        }
        return array
    }

    fun amountBachelor() = salaryListBachelor.average()

    fun amountMaster() = salaryListMaster.average()

    fun amountOther() = salaryListOther.average()
}