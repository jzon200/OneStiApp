package com.example.onestiapp.data

enum class StudentBalance(val paymentScheduleList: List<PaymentSchedule>) {
    ThirdYearFirstTerm(
        paymentScheduleList = listOf(
            PaymentSchedule(
                scheduleDate = "08 Oct, 2021",
                amountBalance = 6575.80
            ),
            PaymentSchedule(
                scheduleDate = "08 Nov, 2021",
                amountBalance = 6576.30
            ),
            PaymentSchedule(
                scheduleDate = "08 Dec, 2021",
                amountBalance = 6210.95
            ),
            PaymentSchedule(
                scheduleDate = "08 Jan, 2021",
                amountBalance = 6210.95
            ),
        )
    ),
    SecondYearSecondTerm(
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