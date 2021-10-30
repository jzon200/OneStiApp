package com.example.onestiapp.data

/**
 * A class that holds the Data of Grades per Term
 * @param gradesList List of [Grade] per term.
 * @param cumulativeGWA The Cumulative GWA displayed per term.
 */
enum class GradesPerTerm(val gradesList: List<Grade>, val cumulativeGWA: Double? = null) {
    ThirdYearFirstTerm(
        gradesList = thirdYearFirstTermGrades,
        cumulativeGWA = null
    ),
    SecondYearSecondTerm(
        gradesList = secondYearSecondTermGrades,
        cumulativeGWA = 1.29
    ),
    SecondYearFirstTerm(
        gradesList = secondYearFirstTermGrades,
        cumulativeGWA = 1.31
    ),
    FirstYearSecondTerm(
        gradesList = firstYearSecondTermGrades,
        cumulativeGWA = 1.42
    ),
    FirstYearFirstTerm(
        gradesList = firstYearFirstTermGrades,
        cumulativeGWA = 1.46
    ),
}

private val thirdYearFirstTermGrades = listOf(
    Grade(
        subjectName = "Programming Languages",
        instructorName = "Felipe Ante",
        gradesEveryPeriodList = listOf(95.99, null, null, null),
        uploadDate = "27 OCT, 2021 07:59 AM"
    ),
    Grade(
        subjectName = "Professional Issues in Information Systems and Technology",
        instructorName = "Sheila Marie Llesol",
        gradesEveryPeriodList = listOf(93.24, null, null, null),
        uploadDate = "25 OCT, 2021 11:20 PM"
    ),
    Grade(
        subjectName = "Physical Education 4 (Team Sports)",
        instructorName = "Venjamin Paul Lagrimas",
        gradesEveryPeriodList = listOf(96.23, null, null, null),
        uploadDate = "24 OCT, 2021 8:03 PM",
        units = 2.00,
        isNonCreditCourse = true
    ),
    Grade(
        subjectName = "Information Assurance & Security (Cybersecurity Fundamentals)",
        instructorName = "Pedion, III Octavio",
        gradesEveryPeriodList = listOf(94.00, null, null, null),
        uploadDate = "24 OCT, 2021 01:18 PM"
    ),
    Grade(
        subjectName = "Data and Digital Communications (Data Communications)",
        instructorName = "Rommel Ramos",
        gradesEveryPeriodList = listOf(96.58, null, null, null),
        uploadDate = "24 OCT, 2021 10:32 AM"
    ),
    Grade(
        subjectName = "Integrative Programming",
        instructorName = "Jerico Bello",
        gradesEveryPeriodList = listOf(100.00, 96.00, null, null),
        uploadDate = "24 OCT, 2021 02:51 AM"
    ),
    Grade(
        subjectName = "Advanced Database Systems",
        instructorName = "Jerico Bello",
        gradesEveryPeriodList = listOf(100.00, null, null, null),
        uploadDate = "24 OCT, 2021 02:39 AM"
    ),
    Grade(
        subjectName = "Application Development and Emerging Technologies",
        instructorName = "Abram Vicencio",
        gradesEveryPeriodList = listOf(98.61, null, null, null),
        uploadDate = "24 OCT, 2021 09:39 AM"
    ),
    Grade(
        subjectName = "Event-Driven Programming",
        instructorName = "JERICO BELLO",
        gradesEveryPeriodList = listOf(null, null, null, null),
        uploadDate = "10 AUG, 2021"
    ),
)

private val secondYearSecondTermGrades = listOf(
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
        uploadDate = "01 JUL, 2021",
        units = 2.00,
        isNonCreditCourse = true
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
        instructorName = "GENALYN GUIANG",
        gradesEveryPeriodList = listOf(93.00, 90.16, 89.54, 94.70),
        uploadDate = "30 JUN, 2021"
    ),
)
val secondYearFirstTermGrades = listOf(
    Grade(
        subjectName = "Data Structures and Algorithms",
        instructorName = "JEFFERSON PRADO",
        gradesEveryPeriodList = listOf(100.00, 99.75, 100.00, 100.00),
        uploadDate = "09 FEB, 2021"
    ),
    Grade(
        subjectName = "Human-Computer Interaction",
        instructorName = "MERVIN PABIRAN",
        gradesEveryPeriodList = listOf(94.48, 97.85, 96.17, 94.38),
        uploadDate = "02 FEB, 2021"
    ),
    Grade(
        subjectName = "Object-Oriented Programming",
        instructorName = "JEFFERSON PRADO",
        gradesEveryPeriodList = listOf(100.00, 100.00, 99.64, 100.00),
        uploadDate = "09 FEB, 2021"
    ),
    Grade(
        subjectName = "Platform Technology (Operating Systems)",
        instructorName = "JEFFERSON PRADO",
        gradesEveryPeriodList = listOf(100.00, 98.55, 99.46, 99.93),
        uploadDate = "09 FEB, 2021"
    ),
    Grade(
        subjectName = "Principles of Communication",
        instructorName = "MERVIN PABIRAN",
        gradesEveryPeriodList = listOf(99.88, 100.00, 100.00, 94.00),
        uploadDate = "02 FEB, 2021",
        units = 2.00,
    ),
    Grade(
        subjectName = "Readings in Philippine History",
        instructorName = "ERICK ENERIO",
        gradesEveryPeriodList = listOf(95.10, 94.85, 94.70, 96.70),
        uploadDate = "08 FEB, 2021"
    ),
    Grade(
        subjectName = "Rizal's Life and Works",
        instructorName = "MARCOSA MARICRIS HERNANDEZ",
        gradesEveryPeriodList = listOf(97.48, 98.20, 97.55, 96.85),
        uploadDate = "08 FEB, 2021"
    ),
)
private val firstYearSecondTermGrades = listOf(
    Grade(
        subjectName = "Art Appreciation",
        instructorName = "GLENDA POLICARPIO",
        gradesEveryPeriodList = listOf(95.07, 94.60, 96.63, 96.90),
        uploadDate = "10 AUG, 2020"
    ),
    Grade(
        subjectName = "Computer Programming 2",
        instructorName = "JOHN GABRIEL SAMBAJON",
        gradesEveryPeriodList = listOf(97.90, 94.39, 100.00, 100.00),
        uploadDate = "07 AUG, 2020"
    ),
    Grade(
        subjectName = "Discrete Structures 1 (Discrete Mathematics)",
        instructorName = "JOHN ERIC MAMUYAC",
        gradesEveryPeriodList = listOf(88.27, 86.28, 88.07, 88.07),
        uploadDate = "10 AUG, 2020"
    ),
    Grade(
        subjectName = "Ethics",
        instructorName = "ORLANDO UMALI",
        gradesEveryPeriodList = listOf(95.92, 89.67, 96.33, 100.00),
        uploadDate = "10 AUG, 2020",
    ),
    Grade(
        subjectName = "National Service Training Program 2",
        instructorName = "RODEL SOLAS",
        gradesEveryPeriodList = listOf(89.25, 97.05, 96.94, 100.00),
        uploadDate = "22 JUN, 2020",
        isNonCreditCourse = true
    ),
    Grade(
        subjectName = "Physical Education 2 (Rhythmic Dancing)",
        instructorName = "JAN JOSHUA BACONAWA",
        gradesEveryPeriodList = listOf(96.85, 92.58, 94.63, 100.00),
        uploadDate = "22 JUN, 2020",
        units = 2.00,
        isNonCreditCourse = true
    ),
    Grade(
        subjectName = "Purposive Communication 1",
        instructorName = "JESSICA DE LA TORRE",
        gradesEveryPeriodList = listOf(92.13, 90.43, 92.28, 91.65),
        uploadDate = "10 AUG, 2020"
    ),
    Grade(
        subjectName = "Science, Technology, and Society",
        instructorName = "MARI FE OLAYBAL",
        gradesEveryPeriodList = listOf(90.80, 89.07, 96.87, 97.37),
        uploadDate = "12 AUG, 2020"
    ),
    Grade(
        subjectName = "Systems Administration and Maintenance",
        instructorName = "HERBERT GARDNER",
        gradesEveryPeriodList = listOf(97.23, 86.13, 98.37, 97.94),
        uploadDate = "12 AUG, 2020"
    ),
)
private val firstYearFirstTermGrades = listOf(
    Grade(
        subjectName = "Computer Programming 1",
        instructorName = "SHEILA MARIE LLESOL",
        gradesEveryPeriodList = listOf(92.23, 94.18, 96.01, 93.15),
        uploadDate = "29 NOV, 2019"
    ),
    Grade(
        subjectName = "Euthenics 1",
        instructorName = "RAYMOND ARCALA",
        gradesEveryPeriodList = listOf(89.60, 96.61, 96.44, 97.25),
        uploadDate = "29 NOV, 2019",
        isNonCreditCourse = true
    ),
    Grade(
        subjectName = "Introduction to Computing",
        instructorName = "JEFFERSON FLORES",
        gradesEveryPeriodList = listOf(96.47, 96.34, 90.30, 96.49),
        uploadDate = "28 NOV, 2019"
    ),
    Grade(
        subjectName = "Mathematics in the Modern World",
        instructorName = "RENEJAN GARCIA",
        gradesEveryPeriodList = listOf(94.02, 96.40, 97.20, 95.25),
        uploadDate = "29 NOV, 2019",
    ),
    Grade(
        subjectName = "National Service Training Program 1",
        instructorName = "CATHERINE CATALAN",
        gradesEveryPeriodList = listOf(87.00, 97.00, 95.00, 99.00),
        uploadDate = "22 JUN, 2020",
        isNonCreditCourse = true
    ),
    Grade(
        subjectName = "Physical Education 1 (Physical Fitness & Conditioning)",
        instructorName = "JAHZIEL SANOY",
        gradesEveryPeriodList = listOf(96.60, 97.85, 96.90, 98.50),
        uploadDate = "29 NOV, 2019",
        units = 2.00,
        isNonCreditCourse = true
    ),
    Grade(
        subjectName = "The Contemporary World",
        instructorName = "ERICK ENERIO",
        gradesEveryPeriodList = listOf(78.05, 89.80, 89.95, 92.78),
        uploadDate = "29 NOV, 2019"
    ),
    Grade(
        subjectName = "The Entrepreneurial Mind",
        instructorName = "RONALD DURON",
        gradesEveryPeriodList = listOf(90.30, 95.55, 91.80, 95.00),
        uploadDate = "29 NOV, 2019"
    ),
    Grade(
        subjectName = "Understanding the Self",
        instructorName = "ORLANDO UMALI",
        gradesEveryPeriodList = listOf(87.72, 93.73, 95.46, 97.00),
        uploadDate = "29 NOV, 2019"
    ),
)
