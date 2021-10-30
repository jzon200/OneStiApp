package com.example.onestiapp.data

/**
 * Class of Student Balance Data
 */
enum class StudentBalance(
    val paymentScheduleList: List<PaymentSchedule>,
    val grossAssessmentList: List<GrossAssessment> = listOf(
        GrossAssessment("Tuition Fee"),
        GrossAssessment("Other School Fees"),
        GrossAssessment("Miscellaneous Fees"),
    ),
) {
    ThirdYearFirstTerm(
        paymentScheduleList = listOf(
            PaymentSchedule(
                scheduleDate = "08 Oct, 2021",
                amountBalance = null
            ),
            PaymentSchedule(
                scheduleDate = "08 Nov, 2021",
                amountBalance = 1365.30
            ),
            PaymentSchedule(
                scheduleDate = "08 Dec, 2021",
                amountBalance = 3168.31
            ),
            PaymentSchedule(
                scheduleDate = "08 Jan, 2021",
                amountBalance = 6210.95
            ),
        ),
        grossAssessmentList = listOf(
            GrossAssessment(
                feeLabel = "Tuition Fee",
                amountBalance = 28950.00
            ),
            GrossAssessment(
                feeLabel = "Other School Fees",
                amountBalance = 7585.00
            ),
            GrossAssessment(
                feeLabel = "Miscellaneous Fees",
                amountBalance = 975.00
            ),
        )
    ),
    SecondYearSecondTerm(
        paymentScheduleList = emptyList()
    ),
    SecondYearFirstTerm(
        paymentScheduleList = emptyList()
    ),
    FirstYearSecondTerm(
        paymentScheduleList = emptyList()
    ),
    FirstYearFirstTerm(
        paymentScheduleList = emptyList()
    ),

}

fun getTotalBalance(studentBalance: StudentBalance): Double {
    var totalBalance = 0.00
    studentBalance.paymentScheduleList.forEach { paymentSchedule ->
        paymentSchedule.amountBalance?.let {
            totalBalance += it
        }
    }
    return totalBalance
}

fun getGrossAssessment(studentBalance: StudentBalance): Double {
    var grossAssessment = 0.00
    studentBalance.grossAssessmentList.forEach {
        grossAssessment += it.amountBalance
    }
    return grossAssessment
}
