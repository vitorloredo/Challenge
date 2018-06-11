package graphic.model

class ModelHigherEducation(val title: String) {

    var salaryListBachelor = arrayListOf<Double>()
        private set(value) {}
    var salaryListMaster = arrayListOf<Double>()
        private set(value) {}
    var salaryListOther = arrayListOf<Double>()
        private set(value) {}

    fun medianBachelor() = removeInvalidNumbers(salaryListBachelor).average()
    fun medianMaster() = removeInvalidNumbers(salaryListMaster).average()
    fun medianOther() = removeInvalidNumbers(salaryListOther).average()

    fun removeInvalidNumbers(array: ArrayList<Double>) = array.filter { it != -1.0 }
}