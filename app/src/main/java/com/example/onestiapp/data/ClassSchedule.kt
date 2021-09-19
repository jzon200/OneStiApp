package com.example.onestiapp.data

import java.text.SimpleDateFormat
import java.util.*

/**
 * Data class for Class Schedule
 */
data class ClassSchedule(
    val courseSubject: String,
    val classStart: String,
    val classEnd: String,
    val classRoom: String,
    val classProfessor: String,
)

/**
 * Returns the list of Class Schedules [ClassSchedule].
 */
fun getClassSchedule(): List<ClassSchedule> {
    val scheduleList = when (getDay()) {
        "Monday" -> mondayScheduleList
        "Tuesday" -> tuesdayScheduleList
        "Wednesday" -> wednesdayScheduleList
        "Thursday" -> thursdayScheduleList
        "Friday" -> fridayScheduleList
        "Saturday" -> saturdayScheduleList
        else -> emptyList()
    }
    return scheduleList
}

/**
 * Returns the current day on this format.
 * (e.g Monday)
 */
fun getDay(): String {
    return SimpleDateFormat("EEEE").format(Calendar.getInstance().time)
}

/**
 * Returns the current date on this format.
 * (e.g 10 AUG, 2021)
 */
fun getDate(): String {
    return SimpleDateFormat("d MMM, y").format(Calendar.getInstance().time).uppercase()
}

val mondayScheduleList = listOf(
    ClassSchedule(
        courseSubject = "Information Assurance & Security (Cybersecurity Fundamentals)",
        classStart = "07:30 AM",
        classEnd = "09:30 AM",
        classRoom = "310",
        classProfessor = "PEDION, III OCTAVIO"
    ),
    ClassSchedule(
        courseSubject = "Data And Digital Communications (Data Communications)",
        classStart = "09:30 AM",
        classEnd = "11:00 AM",
        classRoom = "310",
        classProfessor = "TBA"
    ),
    ClassSchedule(
        courseSubject = "Professional Issues In Information Systems And Technology",
        classStart = "12:30 PM",
        classEnd = "02:00 PM",
        classRoom = "311",
        classProfessor = "SHEILA MARIE LLESOL"
    ),
)

val tuesdayScheduleList = listOf(
    ClassSchedule(
        courseSubject = "Integrative Programming",
        classStart = "08:30 AM",
        classEnd = "11:30 AM",
        classRoom = "Comlab 3",
        classProfessor = "JOHN CARLO MAMUYAC"
    ),
    ClassSchedule(
        courseSubject = "Event-Driven Programming",
        classStart = "08:30 AM",
        classEnd = "11:30 AM",
        classRoom = "Comlab 3",
        classProfessor = "JOHN CARLO MAMUYAC"
    ),
    ClassSchedule(
        courseSubject = "Event-Driven Programming",
        classStart = "01:00 PM",
        classEnd = "03:00 PM",
        classRoom = "312",
        classProfessor = "JOHN CARLO MAMUYAC"
    ),
    ClassSchedule(
        courseSubject = "Integrative Programming",
        classStart = "01:00 PM",
        classEnd = "03:00 PM",
        classRoom = "312",
        classProfessor = "JOHN CARLO MAMUYAC"
    ),
    ClassSchedule(
        courseSubject = "Application Development and Emerging Technologies",
        classStart = "03:00 PM",
        classEnd = "04:00 PM",
        classRoom = "312",
        classProfessor = "TBA"
    ),
)

val wednesdayScheduleList = listOf(
    ClassSchedule(
        courseSubject = "Information Assurance & Security (Cybersecurity Fundamentals)",
        classStart = "07:30 AM",
        classEnd = "10:30 AM",
        classRoom = "TBA",
        classProfessor = "PEDION, III OCTAVIO"
    ),
    ClassSchedule(
        courseSubject = "Application Development and Emerging Technologies",
        classStart = "01:00 PM",
        classEnd = "04:00 PM",
        classRoom = "Comlab 2",
        classProfessor = "TBA"
    ),
    ClassSchedule(
        courseSubject = "Programming Languages",
        classStart = "04:00 PM",
        classEnd = "05:30 AM",
        classRoom = "TBA",
        classProfessor = "TBA"
    ),
)

val thursdayScheduleList = listOf(
    ClassSchedule(
        courseSubject = "Programming Languages",
        classStart = "07:30 AM",
        classEnd = "09:30 AM",
        classRoom = "310",
        classProfessor = "TBA"
    ),
    ClassSchedule(
        courseSubject = "Data And Digital Communications (Data Communications)",
        classStart = "09:30 AM",
        classEnd = "11:00 AM",
        classRoom = "310",
        classProfessor = "TBA"
    ),
    ClassSchedule(
        courseSubject = "Professional Issues In Information Systems And Technology",
        classStart = "12:30 PM",
        classEnd = "02:00 PM",
        classRoom = "311",
        classProfessor = "SHEILA MARIE LLESOL"
    ),
    ClassSchedule(
        courseSubject = "Physical Education 4 (Team Sports)",
        classStart = "02:30 PM",
        classEnd = "04:30 PM",
        classRoom = "311",
        classProfessor = "VENJAMIN PAUL LAGRIMAS"
    ),
)

val fridayScheduleList = listOf(
    ClassSchedule(
        courseSubject = "Integrative Programming",
        classStart = "08:30 AM",
        classEnd = "11:30 AM",
        classRoom = "Comlab 3",
        classProfessor = "JOHN CARLO MAMUYAC"
    ),
    ClassSchedule(
        courseSubject = "Event-Driven Programming",
        classStart = "08:30 AM",
        classEnd = "11:30 AM",
        classRoom = "Comlab 3",
        classProfessor = "JOHN CARLO MAMUYAC"
    ),
    ClassSchedule(
        courseSubject = "Event-Driven Programming",
        classStart = "01:00 PM",
        classEnd = "03:00 PM",
        classRoom = "312",
        classProfessor = "JOHN CARLO MAMUYAC"
    ),
    ClassSchedule(
        courseSubject = "Integrative Programming",
        classStart = "01:00 PM",
        classEnd = "03:00 PM",
        classRoom = "312",
        classProfessor = "JOHN CARLO MAMUYAC"
    ),
    ClassSchedule(
        courseSubject = "Application Development and Emerging Technologies",
        classStart = "03:00 PM",
        classEnd = "04:00 PM",
        classRoom = "312",
        classProfessor = "TBA"
    ),
)

val saturdayScheduleList = listOf(
    ClassSchedule(
        courseSubject = "Information Assurance & Security (Cybersecurity Fundamentals)",
        classStart = "07:30 AM",
        classEnd = "10:30 AM",
        classRoom = "TBA",
        classProfessor = "JOHN CARLO MAMUYAC"
    ),
    ClassSchedule(
        courseSubject = "Data And Digital Communications (Data Communications)",
        classStart = "11:00 AM",
        classEnd = "01:00 PM",
        classRoom = "311",
        classProfessor = "JOHN CARLO MAMUYAC"
    ),
    ClassSchedule(
        courseSubject = "Professional Issues In Information Systems And Technology",
        classStart = "03:00 PM",
        classEnd = "04:30 PM",
        classRoom = "TBA",
        classProfessor = "TBA"
    ),
)

