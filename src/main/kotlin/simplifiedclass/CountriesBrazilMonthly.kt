package simplifiedclass

class CountriesBrazilMonthly(listValuesInReal: ArrayList<Double>, val country: String, val amountPeople: Int) {
    val value = listValuesInReal.toDoubleArray()

    fun amount(): Double {
        var cont = 0.0
        for (it in value){
            cont += it
        }
        return cont
    }

    fun average() = amount()/amountPeople

}
