package com.example.onestiapp.data

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.onestiapp.ui.TermRowSpacer

data class CourseSubject(
    val subjectName: String,
    val unitsRequired: Double,
    val unitsTaken: Double,
    val grade: Double,
    val termTaken: Int = 1901,
    val status: String
)

val firstYearFirstTermSubjects = listOf(
    CourseSubject(
        subjectName = "Introduction to Computing",
        unitsRequired = 3.00,
        unitsTaken = 3.00,
        grade = 1.25,
        termTaken = 1901,
        status = "Taken"
    ),
    CourseSubject(
        subjectName = "Computer Programming 1",
        unitsRequired = 3.00,
        unitsTaken = 3.00,
        grade = 1.50,
        termTaken = 1901,
        status = "Taken"
    ),
    CourseSubject(
        subjectName = "Contemporary World",
        unitsRequired = 3.00,
        unitsTaken = 3.00,
        grade = 1.75,
        termTaken = 1901,
        status = "Taken"
    ),
    CourseSubject(
        subjectName = "Euthenics 1",
        unitsRequired = 3.00,
        unitsTaken = 3.00,
        grade = 1.25,
        termTaken = 1901,
        status = "Taken"
    ),
    CourseSubject(
        subjectName = "The Entrepreneurial Mind",
        unitsRequired = 3.00,
        unitsTaken = 3.00,
        grade = 1.50,
        termTaken = 1901,
        status = "Taken"
    ),
    CourseSubject(
        subjectName = "Mathematics in the Modern World",
        unitsRequired = 3.00,
        unitsTaken = 3.00,
        grade = 1.50,
        termTaken = 1901,
        status = "Taken"
    ),
    CourseSubject(
        subjectName = "National Service Training Program 1",
        unitsRequired = 3.00,
        unitsTaken = 3.00,
        grade = 1.25,
        termTaken = 1901,
        status = "Taken"
    ),
    CourseSubject(
        subjectName = "Physical Education 1 (Physical Fitness & Conditioning)",
        unitsRequired = 2.00,
        unitsTaken = 2.00,
        grade = 1.00,
        termTaken = 1901,
        status = "Taken"
    ),
    CourseSubject(
        subjectName = "Introduction to Computing",
        unitsRequired = 3.00,
        unitsTaken = 3.00,
        grade = 1.50,
        termTaken = 1901,
        status = "Taken"
    ),

)
val firstYearSecondTermSubjects = listOf(
    CourseSubject(
        subjectName = "Computer Programming 2",
        unitsRequired = 3.00,
        unitsTaken = 3.00,
        grade = 1.00,
        termTaken = 1901,
        status = "Taken"
    ),
    CourseSubject(
        subjectName = "Discrete Structures 1 (Discrete Mathematics)",
        unitsRequired = 3.00,
        unitsTaken = 3.00,
        grade = 2.00,
        termTaken = 1901,
        status = "Taken"
    ),
    CourseSubject(
        subjectName = "Art Appreciation",
        unitsRequired = 3.00,
        unitsTaken = 3.00,
        grade = 1.25,
        termTaken = 1901,
        status = "Taken"
    ),
    CourseSubject(
        subjectName = "Ethics",
        unitsRequired = 3.00,
        unitsTaken = 3.00,
        grade = 1.50,
        termTaken = 1901,
        status = "Taken"
    ),
    CourseSubject(
        subjectName = "National Service Training Program 2",
        unitsRequired = 3.00,
        unitsTaken = 3.00,
        grade = 1.25,
        termTaken = 1901,
        status = "Taken"
    ),
    CourseSubject(
        subjectName = "Physical Education 2",
        unitsRequired = 3.00,
        unitsTaken = 2.00,
        grade = 1.25,
        termTaken = 1901,
        status = "Taken"
    ),
    CourseSubject(
        subjectName = "Purposive Communication 1",
        unitsRequired = 3.00,
        unitsTaken = 3.00,
        grade = 1.50,
        termTaken = 1901,
        status = "Taken"
    ),
    CourseSubject(
        subjectName = "Science, Technology, and Society",
        unitsRequired = 2.00,
        unitsTaken = 2.00,
        grade = 1.50,
        termTaken = 1901,
        status = "Taken"
    ),
    CourseSubject(
        subjectName = "Systems Administration and Maintenance 1",
        unitsRequired = 3.00,
        unitsTaken = 3.00,
        grade = 1.50,
        termTaken = 1901,
        status = "Taken"
    ),

)
