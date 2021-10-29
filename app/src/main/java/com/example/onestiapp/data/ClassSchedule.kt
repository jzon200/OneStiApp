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
    val dayIndicator: String? = null
)

/**
 * Returns the list of [ClassSchedule] in the Current Day.
 */
fun getCurrentClassSchedule(): List<ClassSchedule> {
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
        classProfessor = "PEDION, III OCTAVIO",
        dayIndicator = "Monday"
    ),
    ClassSchedule(
        courseSubject = "Data and Digital Communications (Data Communications)",
        classStart = "09:30 AM",
        classEnd = "11:00 AM",
        classRoom = "310",
        classProfessor = "Rommel Ramos",
        dayIndicator = "Monday"
    ),
    ClassSchedule(
        courseSubject = "Professional Issues in Information Systems and Technology",
        classStart = "12:30 PM",
        classEnd = "02:00 PM",
        classRoom = "311",
        classProfessor = "SHEILA MARIE LLESOL",
        dayIndicator = "Monday"
    ),
)

val tuesdayScheduleList = listOf(
    ClassSchedule(
        courseSubject = "Integrative Programming",
        classStart = "08:30 AM",
        classEnd = "11:30 AM",
        classRoom = "Comlab 3",
        classProfessor = "Jerico Bello",
        dayIndicator = "Tuesday"
    ),
    ClassSchedule(
        courseSubject = "Event-Driven Programming",
        classStart = "08:30 AM",
        classEnd = "11:30 AM",
        classRoom = "Comlab 3",
        classProfessor = "Jerico Bello",
        dayIndicator = "Tuesday"
    ),
    ClassSchedule(
        courseSubject = "Event-Driven Programming",
        classStart = "01:00 PM",
        classEnd = "03:00 PM",
        classRoom = "312",
        classProfessor = "Jerico Bello",
        dayIndicator = "Tuesday"
    ),
    ClassSchedule(
        courseSubject = "Integrative Programming",
        classStart = "01:00 PM",
        classEnd = "03:00 PM",
        classRoom = "312",
        classProfessor = "Jerico Bello",
        dayIndicator = "Tuesday"
    ),
    ClassSchedule(
        courseSubject = "Application Development and Emerging Technologies",
        classStart = "03:00 PM",
        classEnd = "04:00 PM",
        classRoom = "312",
        classProfessor = "Abram Vicencio",
        dayIndicator = "Tuesday"
    ),
)

val wednesdayScheduleList = listOf(
    ClassSchedule(
        courseSubject = "Information Assurance & Security (Cybersecurity Fundamentals)",
        classStart = "07:30 AM",
        classEnd = "10:30 AM",
        classRoom = "TBA",
        classProfessor = "PEDION, III OCTAVIO",
        dayIndicator = "Wednesday"
    ),
    ClassSchedule(
        courseSubject = "Programming Languages",
        classStart = "10:30 AM",
        classEnd = "12:30 PM",
        classRoom = "TBA",
        classProfessor = "Felipe Ante",
        dayIndicator = "Wednesday"
    ),
    ClassSchedule(
        courseSubject = "Application Development and Emerging Technologies",
        classStart = "01:00 PM",
        classEnd = "04:00 PM",
        classRoom = "Comlab 2",
        classProfessor = "Abram Vicencio",
        dayIndicator = "Wednesday"
    ),
    ClassSchedule(
        courseSubject = "Programming Languages",
        classStart = "04:00 PM",
        classEnd = "05:30 AM",
        classRoom = "TBA",
        classProfessor = "Felipe Ante",
        dayIndicator = "Wednesday"
    ),
)

val thursdayScheduleList = listOf(
    ClassSchedule(
        courseSubject = "Data and Digital Communications (Data Communications)",
        classStart = "09:30 AM",
        classEnd = "11:00 AM",
        classRoom = "310",
        classProfessor = "Rommel Ramos",
        dayIndicator = "Thursday"
    ),
    ClassSchedule(
        courseSubject = "Professional Issues In Information Systems And Technology",
        classStart = "12:30 PM",
        classEnd = "02:00 PM",
        classRoom = "311",
        classProfessor = "SHEILA MARIE LLESOL",
        dayIndicator = "Thursday"
    ),
    ClassSchedule(
        courseSubject = "Physical Education 4 (Team Sports)",
        classStart = "02:30 PM",
        classEnd = "04:30 PM",
        classRoom = "PE Court C",
        classProfessor = "VENJAMIN PAUL LAGRIMAS",
        dayIndicator = "Thursday"
    ),
)

val fridayScheduleList = listOf(
    ClassSchedule(
        courseSubject = "Integrative Programming",
        classStart = "08:30 AM",
        classEnd = "11:30 AM",
        classRoom = "Comlab 3",
        classProfessor = "Jerico Bello",
        dayIndicator = "Friday"
    ),
    ClassSchedule(
        courseSubject = "Event-Driven Programming",
        classStart = "08:30 AM",
        classEnd = "11:30 AM",
        classRoom = "Comlab 3",
        classProfessor = "Jerico Bello",
        dayIndicator = "Friday"
    ),
    ClassSchedule(
        courseSubject = "Event-Driven Programming",
        classStart = "01:00 PM",
        classEnd = "03:00 PM",
        classRoom = "312",
        classProfessor = "Jerico Bello",
        dayIndicator = "Friday"
    ),
    ClassSchedule(
        courseSubject = "Integrative Programming",
        classStart = "01:00 PM",
        classEnd = "03:00 PM",
        classRoom = "312",
        classProfessor = "Jerico Bello",
        dayIndicator = "Friday"
    ),
    ClassSchedule(
        courseSubject = "Application Development and Emerging Technologies",
        classStart = "03:00 PM",
        classEnd = "04:00 PM",
        classRoom = "312",
        classProfessor = "Abram Vicencio",
        dayIndicator = "Friday"
    ),
)

val saturdayScheduleList = listOf(
    ClassSchedule(
        courseSubject = "Advanced Database Systems",
        classStart = "07:30 AM",
        classEnd = "10:30 AM",
        classRoom = "TBA",
        classProfessor = "Jerico Bello",
        dayIndicator = "Saturday"
    ),
    ClassSchedule(
        courseSubject = "Advanced Database Systems",
        classStart = "11:00 AM",
        classEnd = "01:00 PM",
        classRoom = "311",
        classProfessor = "Jerico Bello",
        dayIndicator = "Saturday"
    ),
    ClassSchedule(
        courseSubject = "Programming Languages",
        classStart = "04:00 PM",
        classEnd = "05:30 PM",
        classRoom = "TBA",
        classProfessor = "Felipe Ante",
        dayIndicator = "Saturday"
    ),
)

val entireWeekScheduleList =
    mondayScheduleList + tuesdayScheduleList + wednesdayScheduleList +
            thursdayScheduleList + fridayScheduleList + saturdayScheduleList