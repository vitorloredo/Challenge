package graphic.model

data class CountrySalaryMedianInReal(val country: String, val salaryInReal: ArrayList<Double>) {

    override fun equals(other: Any?): Boolean {
        val another = other as CountrySalaryMedianInReal
        return this.country == another.country
    }

    fun median() = removeInvalidNumbers().average()

    fun removeInvalidNumbers() = salaryInReal.filter { it != -1.0 }

}