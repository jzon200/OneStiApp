package com.example.onestiapp.data

import kotlin.math.roundToInt

data class Grade(
    val subjectName: String,
    val instructorName: String,
    val gradesEveryPeriodList: List<Double?>,
    val uploadDate: String
)

/**
 * returns the Calculated Course Grade of a Subject in STI Grading System.
 * (Prelims-PreFinals) = 20%,
 * (Finals) = 40%
 * else returns "" if the grade is still not complete.
 */
fun getCourseGrade(gradesList: List<Double?>): String {
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
        return String.format("%.2f", courseGrade)
    } else {
        return ""
    }
}


val secondYearSecondTermGrades = listOf(
    Grade(
        subjectName = "Enterprise Architecture",
        instructorName = "MARK JAYSON SANTOS",
        gradesEveryPeriodList = listOf(97.54, 98.87, 96.38, 96.11),
        uploadDate = "06 JUL, 2021"
    ),
    Grade(
        subjectName = "Network Technology 1",
        instructorName = "JEFFERSON PRADO",
        gradesEveryPeriodList = listOf(99.73, 95.59, 99.13, 98.46),
        uploadDate = "06 JUL, 2021"
    ),
    Grade(
        subjectName = "Systems Integration and Architecture",
        instructorName = "JEFFERSON PRADO",
        gradesEveryPeriodList = listOf(94.96, 98.04, 97.12, 95.60),
        uploadDate = "06 JUL, 2021"
    ),
    Grade(
        subjectName = "Information Management",
        instructorName = "HERBERT GARDNER",
        gradesEveryPeriodList = listOf(95.42, 98.50, 97.13, 98.35),
        uploadDate = "01 JUL, 2021"
    ),
    Grade(
        subjectName = "Physical Education 3 (Individual & Dual Sports)",
        instructorName = "VENJAMIN PAUL LAGRIMAS",
        gradesEveryPeriodList = listOf(94.17, 92.77, 93.94, 98.95),
        uploadDate = "01 JUL, 2021"
    ),
    Grade(
        subjectName = "Technopreneurship",
        instructorName = "RONALD DURON",
        gradesEveryPeriodList = listOf(95.36, 97.70, 89.98, 93.10),
        uploadDate = "01 JUL, 2021"
    ),
    Grade(
        subjectName = "Great Books",
        instructorName = "JESSICA DE LA TORRE",
        gradesEveryPeriodList = listOf(97.15, 96.89, 95.75, 95.71),
        uploadDate = "30 JUN, 2021"
    ),
    Grade(
        subjectName = "Purposive Communication 2",
        instructorName = "HANIEL LOU MORALES",
        gradesEveryPeriodList = listOf(84.77, 98.14, 97.87, 100.00),
        uploadDate = "30 JUN, 2021"
    ),
    Grade(
        subjectName = "Quantitative Methods",
        instructorName = "GENALYN GUIANG ",
        gradesEveryPeriodList = listOf(93.00, 90.16, 89.54, 94.70),
        uploadDate = "30 JUN, 2021"
    ),

)
