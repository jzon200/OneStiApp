package com.example.onestiapp.data

data class CourseSubject(
    val subjectName: String,
    val unitsRequired: Double,
    val unitsTaken: Double? = null,
    val grade: String?,
    val termTaken: Int? = null,
    val status: String,
    val preRequisite: String? = null
)