package data

class Data(value: String) {
    private val valueBase = -1.0
    private val respondent: String
    private val hobby: String
    private val openSource: String
    var country: String
    private val student: String
    private val employment: String
    val formalEducation: String
    private val undergradMajor: String
    private val companySize: String
    private val devType: String
    private val yearsCoding: String
    private val yearsCodingProf: String
    private val jobSatisfaction: String
    private val careerSatisfaction: String
    private val hopeFiveYears: String
    private val jobSearchStatus: String
    private val lastNewJob: String
    private val assessJob1: String
    private val assessJob2: String
    private val assessJob3: String
    private val assessJob4: String
    private val assessJob5: String
    private val assessJob6: String
    private val assessJob7: String
    private val assessJob8: String
    private val assessJob9: String
    private val assessJob10: String
    private val assessBenefits1: String
    private val assessBenefits2: String
    private val assessBenefits3: String
    private val assessBenefits4: String
    private val assessBenefits5: String
    private val assessBenefits6: String
    private val assessBenefits7: String
    private val assessBenefits8: String
    private val assessBenefits9: String
    private val assessBenefits10: String
    private val assessBenefits11: String
    private val jobContactPriorities1: String
    private val jobContactPriorities2: String
    private val jobContactPriorities3: String
    private val jobContactPriorities4: String
    private val jobContactPriorities5: String
    private val jobEmailPriorities1: String
    private val jobEmailPriorities2: String
    private val jobEmailPriorities3: String
    private val jobEmailPriorities4: String
    private val jobEmailPriorities5: String
    private val jobEmailPriorities6: String
    private val jobEmailPriorities7: String
    private val updateCV: String
    private val currency: String
    private val salary: String
    private val salaryType: String
    var convertedSalary: Double
    private val currencySymbol: String
    private val communicationTools: String
    private val timeFullyProductive: String
    private val educationTypes: String
    private val selfTaughtTypes: String
    private val timeAfterBootcamp: String
    private val hackathonReasons: String
    private val agreeDisagree1: String
    private val agreeDisagree2: String
    private val agreeDisagree3: String
    val languageWorkedWith: String //
    val languageDesireNextYear: String
    val databaseWorkedWith: String
    val databaseDesireNextYear: String
    val platformWorkedWith: String
    val platformDesireNextYear: String
    val frameworkWorkedWith: String
    val frameworkDesireNextYear: String //
    val iDE: String
    private val operatingSystem: String
    private val numberMonitors: String
    private val methodology: String
    private val versionControl: String
    private val checkInCode: String
    private val adBlocker: String
    private val adBlockerDisable: String
    private val adBlockerReasons: String
    private val adsAgreeDisagree1: String
    private val adsAgreeDisagree2: String
    private val adsAgreeDisagree3: String
    private val adsActions: String
    private val adsPriorities1: String
    private val adsPriorities2: String
    private val adsPriorities3: String
    private val adsPriorities4: String
    private val adsPriorities5: String
    private val adsPriorities6: String
    private val adsPriorities7: String
    private val aIDangerous: String
    private val aIInteresting: String
    private val aIResponsible: String
    private val aIFuture: String
    private val ethicsChoice: String
    private val ethicsReport: String
    private val ethicsResponsible: String
    private val ethicalImplications: String
    private val stackOverflowRecommend: String
    private val stackOverflowVisit: String
    private val stackOverflowHasAccount: String
    private val stackOverflowParticipate: String
    private val stackOverflowJobs: String
    private val stackOverflowDevStory: String
    private val stackOverflowJobsRecommend: String
    private val stackOverflowConsiderMember: String
    private val hypotheticalTools1: String
    private val hypotheticalTools2: String
    private val hypotheticalTools3: String
    private val hypotheticalTools4: String
    private val hypotheticalTools5: String
    private val wakeTime: String
    private val hoursComputer: String
    private val hoursOutside: String
    private val skipMeals: String
    private val ergonomicDevices: String
    private val exercise: String
    private val gender: String
    private val sexualOrientation: String
    private val educationParents: String
    private val raceEthnicity: String
    private val age: String
    private val dependents: String
    private val militaryUS: String
    private val surveyTooLong: String
    private val surveyEasy: String

    var monthlySalary: String
    var brazilMonthlySalary: String

    init {
        val values: List<String> = customSplit(value)

        if (values.size != 129) {
            println(values.size)
        }

        this.respondent = values[0]

        this.hobby = translate(values[1])
        this.openSource = translate(values[2])

        this.country = values[3]

        this.student = values[4]
        this.employment = values[5]

        this.formalEducation = values[6]

        this.undergradMajor = values[7]
        this.companySize = values[8]
        this.devType = values[9]
        this.yearsCoding = values[10]
        this.yearsCodingProf = values[11]

        this.jobSatisfaction = values[12] //Tabela de sastifcaa

        this.careerSatisfaction = values[13]
        this.hopeFiveYears = values[14]

        this.jobSearchStatus = values[15]//Tabela de sastifcaa

        this.lastNewJob = values[16]
        this.assessJob1 = values[17]
        this.assessJob2 = values[18]
        this.assessJob3 = values[19]
        this.assessJob4 = values[20]
        this.assessJob5 = values[21]
        this.assessJob6 = values[22]
        this.assessJob7 = values[23]
        this.assessJob8 = values[24]
        this.assessJob9 = values[25]
        this.assessJob10 = values[26]
        this.assessBenefits1 = values[27]
        this.assessBenefits2 = values[28]
        this.assessBenefits3 = values[29]
        this.assessBenefits4 = values[30]
        this.assessBenefits5 = values[31]
        this.assessBenefits6 = values[32]
        this.assessBenefits7 = values[33]
        this.assessBenefits8 = values[34]
        this.assessBenefits9 = values[35]
        this.assessBenefits10 = values[36]
        this.assessBenefits11 = values[37]
        this.jobContactPriorities1 = values[38]
        this.jobContactPriorities2 = values[39]
        this.jobContactPriorities3 = values[40]
        this.jobContactPriorities4 = values[41]
        this.jobContactPriorities5 = values[42]
        this.jobEmailPriorities1 = values[43]
        this.jobEmailPriorities2 = values[44]
        this.jobEmailPriorities3 = values[45]
        this.jobEmailPriorities4 = values[46]
        this.jobEmailPriorities5 = values[47]
        this.jobEmailPriorities6 = values[48]
        this.jobEmailPriorities7 = values[49]
        this.updateCV = values[50]
        this.currency = values[51]
        this.salary = values[52]
        this.salaryType = values[53]

        this.convertedSalary = convertedSalary(values[54])

        this.currencySymbol = values[55]
        this.communicationTools = values[56]
        this.timeFullyProductive = values[57]
        this.educationTypes = values[58]
        this.selfTaughtTypes = values[59]
        this.timeAfterBootcamp = values[60]
        this.hackathonReasons = values[61]
        this.agreeDisagree1 = values[62]
        this.agreeDisagree2 = values[63]
        this.agreeDisagree3 = values[64]

        this.languageWorkedWith = values[65]

        this.languageDesireNextYear = values[66]
        this.databaseWorkedWith = values[67]
        this.databaseDesireNextYear = values[68]

        this.platformWorkedWith = values[69] // getData

        this.platformDesireNextYear = values[70]
        this.frameworkWorkedWith = values[71]
        this.frameworkDesireNextYear = values[72]

        this.iDE = values[73]

        this.operatingSystem = values[74]
        this.numberMonitors = values[75]
        this.methodology = values[76]
        this.versionControl = values[77]
        this.checkInCode = values[78]
        this.adBlocker = values[79]
        this.adBlockerDisable = values[80]
        this.adBlockerReasons = values[81]
        this.adsAgreeDisagree1 = values[82]
        this.adsAgreeDisagree2 = values[83]
        this.adsAgreeDisagree3 = values[84]
        this.adsActions = values[85]
        this.adsPriorities1 = values[86]
        this.adsPriorities2 = values[87]
        this.adsPriorities3 = values[88]
        this.adsPriorities4 = values[89]
        this.adsPriorities5 = values[90]
        this.adsPriorities6 = values[91]
        this.adsPriorities7 = values[92]
        this.aIDangerous = values[93]
        this.aIInteresting = values[94]
        this.aIResponsible = values[95]
        this.aIFuture = values[96]
        this.ethicsChoice = values[97]
        this.ethicsReport = values[98]
        this.ethicsResponsible = values[99]
        this.ethicalImplications = values[100]
        this.stackOverflowRecommend = values[101]
        this.stackOverflowVisit = values[102]
        this.stackOverflowHasAccount = values[103]
        this.stackOverflowParticipate = values[104]
        this.stackOverflowJobs = values[105]
        this.stackOverflowDevStory = values[106]
        this.stackOverflowJobsRecommend = values[107]
        this.stackOverflowConsiderMember = values[108]
        this.hypotheticalTools1 = values[109]
        this.hypotheticalTools2 = values[110]
        this.hypotheticalTools3 = values[111]
        this.hypotheticalTools4 = values[112]
        this.hypotheticalTools5 = values[113]
        this.wakeTime = values[114]
        this.hoursComputer = values[115]
        this.hoursOutside = values[116]
        this.skipMeals = values[117]
        this.ergonomicDevices = values[118]
        this.exercise = values[119]
        this.gender = values[120]
        this.sexualOrientation = values[121]
        this.educationParents = values[122]
        this.raceEthnicity = values[123]
        this.age = values[124]
        this.dependents = values[125]
        this.militaryUS = values[126]
        this.surveyTooLong = values[127]
        this.surveyEasy = values[128]

        monthlySalary = if (convertedSalary != -1.0) {
            (convertedSalary / 12).toString()
        } else {
            valueBase.toString()
        }

        brazilMonthlySalary = if (monthlySalary.toDouble() != -1.0) {
            (monthlySalary.toDouble() * 3.81).toString()
        } else {
            valueBase.toString()
        }

    }

    private fun customSplit(value: String): MutableList<String> {
        var contInit = 0
        var contFinal: Int
        var cont = 0
        val listFinal = mutableListOf<String>()
        var word = ""
        var notText = true

        val valueFinal = "$value,"

        for (letter in valueFinal) {

            if (letter == '"') {
                notText = notText != true
            }

            if ((letter == ',') && notText) {
                contFinal = cont

                for (i in contInit..contFinal) {

                    if (valueFinal[i] != ',') {
                        word += valueFinal[i]
                    }
                }

                contInit = cont
                if (word != "") {
                    listFinal.add(word)
                } else {
                    listFinal.add("Unknown")
                }

                word = ""
            }

            cont += 1
        }
        return listFinal
    }

    private fun convertedSalary(str: String): Double {
        return try {
            str.toDouble()
        } catch (ex: NumberFormatException) {
            valueBase
        }
    }

    private fun translate(str: String): String {
        if (str.equals("No", true)) {
            return "Nao"
        }
        return "Sim"
    }

    override fun toString(): String {
        return "$respondent,$hobby,$openSource,$country,$student,$employment,$formalEducation,$undergradMajor,$companySize,$devType,$yearsCoding,$yearsCodingProf,$jobSatisfaction,$careerSatisfaction,$hopeFiveYears,$jobSearchStatus,$lastNewJob,$assessJob1,$assessJob2,$assessJob3,$assessJob4,$assessJob5,$assessJob6,$assessJob7,$assessJob8,$assessJob9,$assessJob10," +
                "$assessBenefits1,$assessBenefits2,$assessBenefits3,$assessBenefits4,$assessBenefits5,$assessBenefits6,$assessBenefits7,$assessBenefits8,$assessBenefits9,$assessBenefits10,$assessBenefits11,$jobContactPriorities1,$jobContactPriorities2,$jobContactPriorities3,$jobContactPriorities4,$jobContactPriorities5," +
                "$jobEmailPriorities1,$jobEmailPriorities2,$jobEmailPriorities3,$jobEmailPriorities4,$jobEmailPriorities5,$jobEmailPriorities6,$jobEmailPriorities7," +
                "$updateCV,$currency,$salary,$salaryType,$convertedSalary,$currencySymbol,$communicationTools,$timeFullyProductive,$educationTypes,$selfTaughtTypes,$timeAfterBootcamp,$hackathonReasons,$agreeDisagree1,$agreeDisagree2,$agreeDisagree3,$languageWorkedWith,$languageDesireNextYear,$databaseWorkedWith,$databaseDesireNextYear,$platformWorkedWith,$platformDesireNextYear," +
                "$frameworkWorkedWith,$frameworkDesireNextYear,$iDE,$operatingSystem,$numberMonitors,$methodology,$versionControl,$checkInCode,$adBlocker,$adBlockerDisable,$adBlockerReasons,$adsAgreeDisagree1,$adsAgreeDisagree2,$adsAgreeDisagree3,$adsActions,$adsPriorities1,$adsPriorities2,$adsPriorities3,$adsPriorities4,$adsPriorities5,$adsPriorities6,$adsPriorities7," +
                "$aIDangerous,$aIInteresting,$aIResponsible,$aIFuture,$ethicsChoice,$ethicsReport,$ethicsResponsible,$ethicalImplications,$stackOverflowRecommend,$stackOverflowVisit,$stackOverflowHasAccount,$stackOverflowParticipate,$stackOverflowJobs,$stackOverflowDevStory,$stackOverflowJobsRecommend,$stackOverflowConsiderMember,$hypotheticalTools1,$hypotheticalTools2," +
                "$hypotheticalTools3,$hypotheticalTools4,$hypotheticalTools5,$wakeTime,$hoursComputer,$hoursOutside,$skipMeals,$ergonomicDevices,$exercise,$gender,$sexualOrientation,$educationParents,$raceEthnicity,$age,$dependents,$militaryUS,$surveyTooLong,$surveyEasy," +
                "${monthlySalary.replace(",", ".")},${brazilMonthlySalary.replace(",", ".")}"

    }

}