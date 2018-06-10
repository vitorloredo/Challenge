package graphic.catchdata

import extend.isUnknown
import graphic.model.JobYears
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter

class CSVJobPermanence {
    private var title: String = "Sastifacao do trabalho"

    private val jobYearsModeratelySatisfied = JobYears("Moderately satisfied")
    private val jobYearsExtremelyDissatisfied = JobYears("Extremely dissatisfied")
    private val jobYearsSlightlySatisfied = JobYears("Slightly satisfied")

    private val jobYearsModeratelyDissatisfied = JobYears("Moderately dissatisfied")
    private val jobYearsSlightlyDissatisfied = JobYears("Slightly dissatisfied")
    private val jobYearsExtremelySatisfied = JobYears("Extremely satisfied")

    private val jobYearsNeitherSatisfied = JobYears("Neither satisfied nor dissatisfied")

    fun insertNewData(careerSatisfaction: String, lastNewJob: String) {
        val unknown = careerSatisfaction.isUnknown()
        val unknown2 = lastNewJob.isUnknown()

        if (!unknown && !unknown2) {
            when {
                careerSatisfaction.contains("Moderately satisfied") ->
                    jobYearsModeratelySatisfied.insertNewData(lastNewJob)
                careerSatisfaction.contains("Extremely dissatisfied") ->
                    jobYearsExtremelyDissatisfied.insertNewData(lastNewJob)
                careerSatisfaction.contains("Slightly satisfied") ->
                    jobYearsSlightlySatisfied.insertNewData(lastNewJob)

                careerSatisfaction.contains("Moderately dissatisfied") ->
                    jobYearsModeratelyDissatisfied.insertNewData(lastNewJob)
                careerSatisfaction.contains("Slightly dissatisfied") ->
                    jobYearsSlightlyDissatisfied.insertNewData(lastNewJob)
                careerSatisfaction.contains("Extremely satisfied") ->
                    jobYearsExtremelySatisfied.insertNewData(lastNewJob)

                careerSatisfaction.contains("Neither satisfied nor dissatisfied") ->
                    jobYearsNeitherSatisfied.insertNewData(lastNewJob)
            }
        }
    }

    fun generateCSV() {
        val baseName = File(".").canonicalPath
        val localFileName = FileWriter("$baseName\\src\\info\\$title.csv")
        val white = BufferedWriter(localFileName)

        white.write("Permanence,Moderately satisfied,Extremely dissatisfied,Slightly satisfied,Moderately dissatisfied,Slightly dissatisfied,Extremely satisfied,Neither satisfied nor dissatisfied")
        white.newLine()

        white.write("Between 1 and 2 years ago," +
                "${jobYearsModeratelySatisfied.between1and2}," +
                "${jobYearsExtremelyDissatisfied.between1and2}," +
                "${jobYearsSlightlySatisfied.between1and2}," +
                "${jobYearsModeratelyDissatisfied.between1and2}," +
                "${jobYearsSlightlyDissatisfied.between1and2}," +
                "${jobYearsExtremelySatisfied.between1and2}," +
                "${jobYearsNeitherSatisfied.between1and2}")

        white.newLine()

        white.write("Between 2 and 4 years ago," +
                "${jobYearsModeratelySatisfied.between2and4}," +
                "${jobYearsExtremelyDissatisfied.between2and4}," +
                "${jobYearsSlightlySatisfied.between2and4}," +
                "${jobYearsModeratelyDissatisfied.between2and4}," +
                "${jobYearsSlightlyDissatisfied.between2and4}," +
                "${jobYearsExtremelySatisfied.between2and4}," +
                "${jobYearsNeitherSatisfied.between2and4}")

        white.newLine()

        white.write("Less than a year ago," +
                "${jobYearsModeratelySatisfied.lessOne}," +
                "${jobYearsExtremelyDissatisfied.lessOne}," +
                "${jobYearsSlightlySatisfied.lessOne}," +
                "${jobYearsModeratelyDissatisfied.lessOne}," +
                "${jobYearsSlightlyDissatisfied.lessOne}," +
                "${jobYearsExtremelySatisfied.lessOne}," +
                "${jobYearsNeitherSatisfied.lessOne}")

        white.newLine()

        white.write("More than 4 years ago," +
                "${jobYearsModeratelySatisfied.moreFour}," +
                "${jobYearsExtremelyDissatisfied.moreFour}," +
                "${jobYearsSlightlySatisfied.moreFour}," +
                "${jobYearsModeratelyDissatisfied.moreFour}," +
                "${jobYearsSlightlyDissatisfied.moreFour}," +
                "${jobYearsExtremelySatisfied.moreFour}," +
                "${jobYearsNeitherSatisfied.moreFour}")

        white.newLine()

        white.write("I've never had a job," +
                "${jobYearsModeratelySatisfied.never}," +
                "${jobYearsExtremelyDissatisfied.never}," +
                "${jobYearsSlightlySatisfied.never}," +
                "${jobYearsModeratelyDissatisfied.never}," +
                "${jobYearsSlightlyDissatisfied.never}," +
                "${jobYearsExtremelySatisfied.never}," +
                "${jobYearsNeitherSatisfied.never}")

        white.newLine()

        white.close()

    }

}