package graphic.model

class JobSatisfaction(val name: String) {
    var notInterestedNewJob = 0
    var notLookingButOpenNewJob = 0
    var lookingJob = 0

    fun insertNewData(string: String) {
        when {
            string.contains("new job opportunities") ->
                notInterestedNewJob += 1
            string.contains("open to new opportunities") ->
                notLookingButOpenNewJob += 1
            string.contains("actively looking") ->
                lookingJob += 1
        }
    }
}