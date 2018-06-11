package graphic.model

class JobYears(name: String) {

    var lessOne = 0
    var moreFour = 0
    var between2and4 = 0
    var between1and2 = 0
    var never = 0

    fun insertNewData(string: String) {
        when {
            string.contains("Less than a year ago") ->
                lessOne += 1
            string.contains("More than 4 years ago") ->
                moreFour += 1
            string.contains("Between 2 and 4 years ago") ->
                between2and4 += 1
            string.contains("Between 1 and 2 years ago") ->
                between1and2 += 1

            string.contains("I've never had a job") ->
                never += 1
        }
    }
}