package graphic.catchdata

import extend.isUnknown
import graphic.model.JobSatisfaction
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter

class CSVJobSearch {

    private var title: String = "Satisfação do trabalho em relação à busca de novos trabalhos"
    private val jobSatisfactionModeratelySatisfied = JobSatisfaction("Moderately satisfied")
    private val jobSatisfactionExtremelyDissatisfied = JobSatisfaction("Extremely dissatisfied")
    private val jobSatisfactionSlightlySatisfied = JobSatisfaction("Slightly satisfied")

    private val jobSatisfactionModeratelyDissatisfied = JobSatisfaction("Moderately dissatisfied")
    private val jobSatisfactionSlightlyDissatisfied = JobSatisfaction("Slightly dissatisfied")
    private val jobSatisfactionExtremelySatisfied = JobSatisfaction("Extremely satisfied")

    private val jobSatisfactionNeitherSatisfied = JobSatisfaction("Neither satisfied nor dissatisfied")


    fun insertNewData(jobSatisfaction: String, jobSearchStatus: String) {
        val unknown = jobSatisfaction.isUnknown()
        val unknown2 = jobSearchStatus.isUnknown()

        if (!unknown && !unknown2) {
            when {
                jobSatisfaction.contains("Moderately satisfied") ->
                    jobSatisfactionModeratelySatisfied.insertNewData(jobSearchStatus)
                jobSatisfaction.contains("Extremely dissatisfied") ->
                    jobSatisfactionExtremelyDissatisfied.insertNewData(jobSearchStatus)
                jobSatisfaction.contains("Slightly satisfied") ->
                    jobSatisfactionSlightlySatisfied.insertNewData(jobSearchStatus)

                jobSatisfaction.contains("Moderately dissatisfied") ->
                    jobSatisfactionModeratelyDissatisfied.insertNewData(jobSearchStatus)
                jobSatisfaction.contains("Slightly dissatisfied") ->
                    jobSatisfactionSlightlyDissatisfied.insertNewData(jobSearchStatus)
                jobSatisfaction.contains("Extremely satisfied") ->
                    jobSatisfactionExtremelySatisfied.insertNewData(jobSearchStatus)

                jobSatisfaction.contains("Neither satisfied nor dissatisfied") ->
                    jobSatisfactionNeitherSatisfied.insertNewData(jobSearchStatus)
            }
        }
    }

    fun generateCSV() {
        val baseName = File(".").canonicalPath
        val localFileName = FileWriter("$baseName\\src\\info\\$title.csv")
        val white = BufferedWriter(localFileName)

        white.write("Interest,Moderately satisfied,Extremely dissatisfied,Slightly satisfied,Moderately dissatisfied,Slightly dissatisfied,Extremely satisfied,Neither satisfied nor dissatisfied")
        white.newLine()

        white.write("I'm not actively looking but I am open to new opportunities,${jobSatisfactionModeratelySatisfied.notLookingButOpenNewJob}," +
                "${jobSatisfactionExtremelyDissatisfied.notLookingButOpenNewJob}," +
                "${jobSatisfactionSlightlySatisfied.notLookingButOpenNewJob}," +
                "${jobSatisfactionModeratelyDissatisfied.notLookingButOpenNewJob}," +
                "${jobSatisfactionSlightlyDissatisfied.notLookingButOpenNewJob}," +
                "${jobSatisfactionExtremelySatisfied.notLookingButOpenNewJob}," +
                "${jobSatisfactionNeitherSatisfied.notLookingButOpenNewJob}")

        white.newLine()

        white.write("I am not interested in new job opportunities,${jobSatisfactionModeratelySatisfied.notInterestedNewJob}," +
                "${jobSatisfactionExtremelyDissatisfied.notInterestedNewJob}," +
                "${jobSatisfactionSlightlySatisfied.notInterestedNewJob}," +
                "${jobSatisfactionModeratelyDissatisfied.notInterestedNewJob}," +
                "${jobSatisfactionSlightlyDissatisfied.notInterestedNewJob}," +
                "${jobSatisfactionExtremelySatisfied.notInterestedNewJob}," +
                "${jobSatisfactionNeitherSatisfied.notInterestedNewJob}")

        white.newLine()

        white.write("I am actively looking for a job,${jobSatisfactionModeratelySatisfied.lookingJob}," +
                "${jobSatisfactionExtremelyDissatisfied.lookingJob}," +
                "${jobSatisfactionSlightlySatisfied.lookingJob}," +
                "${jobSatisfactionModeratelyDissatisfied.lookingJob}," +
                "${jobSatisfactionSlightlyDissatisfied.lookingJob}," +
                "${jobSatisfactionExtremelySatisfied.lookingJob}," +
                "${jobSatisfactionNeitherSatisfied.lookingJob}")

        white.newLine()

        white.close()

    }

}