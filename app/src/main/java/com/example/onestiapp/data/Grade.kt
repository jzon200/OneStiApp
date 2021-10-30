package com.example.onestiapp.data

import kotlin.math.roundToInt

/**
 * This class is classified as a data for Grades.
 * @param subjectName The name of subject.
 * @param instructorName The name of instructor/professor.
 * @param gradesEveryPeriodList The grades every period (Prelim, Midterms, Pre final, Finals).
 * @param uploadDate The Date of the Grade uploaded.
 * @param units The units per subject set to 3.00 as Default.
 * @param isNonCreditCourse This determines if the couse grade is credited in GWA (Most are P.E & NSTP).
 */
data class Grade(
    val subjectName: String,
    val instructorName: String,
    val gradesEveryPeriodList: List<Double?>,
    val uploadDate: String,
    val units: Double = 3.00,
    val isNonCreditCourse: Boolean = false
)

/**
 * Returns the Calculated GWA (General Weighted Average)
 * in STI Grading System as follows:
 * CPC = CG x Un,
 * TCP = CPC1 + CPC2 + CPC3 + ... + CPCn,
 * GWA = TCP / TUn
 * Note: If the Course Grades are not yet completed returns null
 */
fun getGWA(grades: List<Grade>): Double? {
    var totalCreditPoints = 0.00 // TCP
    var totalUnits = 0.00 // TUn
    val hasNoCourseGrade = mutableListOf<Boolean>()
    grades.forEach { grade ->
        if (!grade.isNonCreditCourse) {
            val courseGrade = getCourseGrade(grade.gradesEveryPeriodList)
            if (courseGrade != null) {
                val creditsPerCourse = courseGrade * grade.units
                totalCreditPoints += creditsPerCourse
                totalUnits += grade.units
                hasNoCourseGrade.add(false)
            } else {
                hasNoCourseGrade.add(true)
            }
        }
    }
    return if (!hasNoCourseGrade.contains(true)) totalCreditPoints / totalUnits else null
}


/**
 * returns the Calculated Course Grade of a Subject in STI Grading System.
 * (Prelims-PreFinals) = 20%,
 * (Finals) = 40%
 * else returns nulls if the grade is still not complete.
 */
fun getCourseGrade(gradesList: List<Double?>): Double? {
    var courseScore = 0.00
    if (!gradesList.contains(null)) {
        for (index in 0 until 3) {
            courseScore += (0.2 * gradesList[index]!!)
        }
        courseScore += (0.4 * gradesList.last()!!)

        val courseGrade = when (courseScore.roundToInt().toDouble()) {
            in 97.50..100.00 -> 1.00
            in 94.50..97.49 -> 1.25
            in 91.50..94.49 -> 1.50
            in 88.50..91.49 -> 1.75
            in 85.50..88.49 -> 2.00
            in 82.50..85.49 -> 2.25
            in 79.50..82.49 -> 2.50
            in 76.50..79.49 -> 2.75
            in 74.50..76.49 -> 3.00
            else -> 5.00
        }
        return courseGrade
    } else {
        return null
    }
}

