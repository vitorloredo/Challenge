package data

import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter

class WritData(private val arrayData: ArrayList<Data>) {
    fun white() {
        val baseName = File(".").canonicalPath
        val localFileName = FileWriter("$baseName\\src\\info\\base_de_respostas_final.csv")
        val white = BufferedWriter(localFileName)

        val line = listOf("Respondent", "Hobby", "OpenSource", "Country", "Student", "Employment", "FormalEducation", "UndergradMajor", "CompanySize", "DevType", "YearsCoding", "YearsCodingProf", "JobSatisfaction", "CareerSatisfaction", "HopeFiveYears", "JobSearchStatus", "LastNewJob", "AssessJob1", "AssessJob2", "AssessJob3", "AssessJob4", "AssessJob5", "AssessJob6", "AssessJob7", "AssessJob8", "AssessJob9", "AssessJob10", "AssessBenefits1", "AssessBenefits2", "AssessBenefits3", "AssessBenefits4", "AssessBenefits5", "AssessBenefits6", "AssessBenefits7", "AssessBenefits8", "AssessBenefits9", "AssessBenefits10", "AssessBenefits11", "JobContactPriorities1", "JobContactPriorities2", "JobContactPriorities3", "JobContactPriorities4", "JobContactPriorities5", "JobEmailPriorities1", "JobEmailPriorities2", "JobEmailPriorities3", "JobEmailPriorities4", "JobEmailPriorities5", "JobEmailPriorities6", "JobEmailPriorities7", "UpdateCV", "Currency", "Salary", "SalaryType", "ConvertedSalary", "CurrencySymbol", "CommunicationTools", "TimeFullyProductive", "EducationTypes", "SelfTaughtTypes", "TimeAfterBootcamp", "HackathonReasons", "AgreeDisagree1", "AgreeDisagree2", "AgreeDisagree3", "LanguageWorkedWith", "LanguageDesireNextYear", "DatabaseWorkedWith", "DatabaseDesireNextYear", "PlatformWorkedWith", "PlatformDesireNextYear", "FrameworkWorkedWith", "FrameworkDesireNextYear", "IDE", "OperatingSystem", "NumberMonitors", "Methodology", "VersionControl", "CheckInCode", "AdBlocker", "AdBlockerDisable", "AdBlockerReasons", "AdsAgreeDisagree1", "AdsAgreeDisagree2", "AdsAgreeDisagree3", "AdsActions", "AdsPriorities1", "AdsPriorities2", "AdsPriorities3", "AdsPriorities4", "AdsPriorities5", "AdsPriorities6", "AdsPriorities7", "AIDangerous", "AIInteresting", "AIResponsible", "AIFuture", "EthicsChoice", "EthicsReport", "EthicsResponsible", "EthicalImplications", "StackOverflowRecommend", "StackOverflowVisit", "StackOverflowHasAccount", "StackOverflowParticipate", "StackOverflowJobs", "StackOverflowDevStory", "StackOverflowJobsRecommend", "StackOverflowConsiderMember", "HypotheticalTools1", "HypotheticalTools2", "HypotheticalTools3", "HypotheticalTools4", "HypotheticalTools5", "WakeTime", "HoursComputer", "HoursOutside", "SkipMeals", "ErgonomicDevices", "Exercise", "Gender", "SexualOrientation", "EducationParents", "RaceEthnicity", "Age", "Dependents", "MilitaryUS", "SurveyTooLong", "SurveyEasy",
                "MonthlySalary", "BrazilMonthlySalary")

        white.write(line.toString()
                .replace("[", "")
                .replace("]", ""))

        white.newLine()

        for (it in arrayData) {
            white.write(it.toString())
            white.newLine()
        }
        white.close()
    }
}