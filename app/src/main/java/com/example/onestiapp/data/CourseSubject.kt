package com.example.onestiapp.data

/**
 * This class is classified as a data for Course Subjects in Program Curriculum.
 * @param subjectName The name of subject.
 * @param unitsRequired The total units required.
 * @param grade The Average Course Grade pf the subject.
 * @param termTaken The year of the term taken.
 * @param status This determines if it is (Taken, In-progress, Not yet Taken).
 * @param preRequisite The pre-requisite of the subject, set to null as default.
 */
data class CourseSubject(
    val subjectName: String,
    val unitsRequired: Double,
    val unitsTaken: Double? = null,
    val grade: String?,
    val termTaken: Int? = null,
    val status: String,
    val preRequisite: String? = null
)