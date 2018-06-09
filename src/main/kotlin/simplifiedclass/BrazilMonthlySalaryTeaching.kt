package simplifiedclass

import extend.convertsStringFormatToDouble

class BrazilMonthlySalaryTeaching(val str: String) {
    val salaryListBachelor = arrayListOf<String>()
    val salaryListMaster = arrayListOf<String>()
    val salaryListOther = arrayListOf<String>()

    fun amountBachelor (): Double {
        var cont = 0.0
        for (it in salaryListBachelor) {
            cont += it.convertsStringFormatToDouble() / 100
        }
        return cont / notZero(salaryListBachelor.size)
    }

    fun amountMaster (): Double {
        var cont = 0.0
        for (it in salaryListMaster) {
            cont += it.convertsStringFormatToDouble() / 100
        }
        return cont / notZero(salaryListMaster.size)
    }

    fun amountOther (): Double {
        var cont = 0.0
        for (it in salaryListOther) {
            cont += it.convertsStringFormatToDouble() / 100
        }
        return cont / notZero(salaryListOther.size)
    }

    private fun notZero(value: Int): Int {
        if (value == 0){
            return 1
        }
        return value
    }
}