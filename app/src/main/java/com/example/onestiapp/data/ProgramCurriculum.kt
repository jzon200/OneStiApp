package com.example.onestiapp.data

/**
 * This class holds the data of [CourseSubject] in Program Curriculum.
 * @param title The title of Card (First Year, Second Year, ...)
 * @param firstTermSubjects The list of [CourseSubject] in first term.
 * @param secondTermSubjects The list of [CourseSubject] in second term.
 * @param electiveCourses This is optionally used as third items for the list of [CourseSubject].
 */
enum class ProgramCurriculum(
    val title: String,
    val firstTermSubjects: List<CourseSubject>,
    val secondTermSubjects: List<CourseSubject>,
    val electiveCourses: List<CourseSubject> = emptyList(),
) {
    FirstYear(
        title = "First Year",
        firstTermSubjects = listOf(
            CourseSubject(
                subjectName = "Introduction to Computing",
                unitsRequired = 3.00,
                unitsTaken = 3.00,
                grade = "1.25",
                termTaken = 1901,
                status = "Taken"
            ),
            CourseSubject(
                subjectName = "Computer Programming 1",
                unitsRequired = 3.00,
                unitsTaken = 3.00,
                grade = "1.50",
                termTaken = 1901,
                status = "Taken"
            ),
            CourseSubject(
                subjectName = "Contemporary World",
                unitsRequired = 3.00,
                unitsTaken = 3.00,
                grade = "1.75",
                termTaken = 1901,
                status = "Taken"
            ),
            CourseSubject(
                subjectName = "Euthenics 1",
                unitsRequired = 1.00,
                unitsTaken = 1.00,
                grade = "P",
                termTaken = 1901,
                status = "Taken"
            ),
            CourseSubject(
                subjectName = "The Entrepreneurial Mind",
                unitsRequired = 3.00,
                unitsTaken = 3.00,
                grade = "1.50",
                termTaken = 1901,
                status = "Taken"
            ),
            CourseSubject(
                subjectName = "Mathematics in the Modern World",
                unitsRequired = 3.00,
                unitsTaken = 3.00,
                grade = "1.50",
                termTaken = 1901,
                status = "Taken"
            ),
            CourseSubject(
                subjectName = "National Service Training Program 1",
                unitsRequired = 3.00,
                unitsTaken = 3.00,
                grade = "1.25",
                termTaken = 1901,
                status = "Taken"
            ),
            CourseSubject(
                subjectName = "Physical Education 1 (Physical Fitness & Conditioning)",
                unitsRequired = 2.00,
                unitsTaken = 2.00,
                grade = "1.00",
                termTaken = 1901,
                status = "Taken"
            ),
            CourseSubject(
                subjectName = "Introduction to Computing",
                unitsRequired = 3.00,
                unitsTaken = 3.00,
                grade = "1.50",
                termTaken = 1901,
                status = "Taken"
            ),
        ),
        secondTermSubjects = listOf(
            CourseSubject(
                subjectName = "Computer Programming 2",
                unitsRequired = 3.00,
                unitsTaken = 3.00,
                grade = "1.00",
                termTaken = 1902,
                status = "Taken",
                preRequisite = "Computer Programming 1"
            ),
            CourseSubject(
                subjectName = "Discrete Structures 1 (Discrete Mathematics)",
                unitsRequired = 3.00,
                unitsTaken = 3.00,
                grade = "2.00",
                termTaken = 1902,
                status = "Taken"
            ),
            CourseSubject(
                subjectName = "Art Appreciation",
                unitsRequired = 3.00,
                unitsTaken = 3.00,
                grade = "1.25",
                termTaken = 1902,
                status = "Taken"
            ),
            CourseSubject(
                subjectName = "Ethics",
                unitsRequired = 3.00,
                unitsTaken = 3.00,
                grade = "1.25",
                termTaken = 1902,
                status = "Taken"
            ),
            CourseSubject(
                subjectName = "National Service Training Program 2",
                unitsRequired = 3.00,
                unitsTaken = 3.00,
                grade = "1.50",
                termTaken = 1902,
                status = "Taken"
            ),
            CourseSubject(
                subjectName = "Physical Education 2 (Rhythmic Dancing)",
                unitsRequired = 3.00,
                unitsTaken = 2.00,
                grade = "1.25",
                termTaken = 1902,
                status = "Taken",
                preRequisite = "Physical Education 1 (PF & C)"
            ),
            CourseSubject(
                subjectName = "Purposive Communication 1",
                unitsRequired = 3.00,
                unitsTaken = 3.00,
                grade = "1.50",
                termTaken = 1902,
                status = "Taken"
            ),
            CourseSubject(
                subjectName = "Science, Technology, and Society",
                unitsRequired = 2.00,
                unitsTaken = 2.00,
                grade = "1.50",
                termTaken = 1902,
                status = "Taken"
            ),
            CourseSubject(
                subjectName = "Systems Administration and Maintenance",
                unitsRequired = 3.00,
                unitsTaken = 3.00,
                grade = "1.25",
                termTaken = 1902,
                status = "Taken"
            ),
        )
    ),
    SecondYear(
        title = "Second Year",
        firstTermSubjects = listOf(
            CourseSubject(
                subjectName = "Data Structures and Algorithms",
                unitsRequired = 3.00,
                unitsTaken = 3.00,
                grade = "1.00",
                termTaken = 2001,
                status = "Taken",
                preRequisite = "Computer Programming 2"
            ),
            CourseSubject(
                subjectName = "Readings in Philippine History",
                unitsRequired = 3.00,
                unitsTaken = 3.00,
                grade = "1.25",
                termTaken = 2001,
                status = "Taken"
            ),
            CourseSubject(
                subjectName = "Physical Education 3 (Individual & Dual Sports)",
                unitsRequired = 2.00,
                unitsTaken = 2.00,
                grade = "1.25",
                termTaken = 2002,
                status = "Taken",
                preRequisite = "Physical Education 1 (PF & C)"
            ),
            CourseSubject(
                subjectName = "Rizal's Life and Works",
                unitsRequired = 3.00,
                unitsTaken = 3.00,
                grade = "1.25",
                termTaken = 2001,
                status = "Taken"
            ),
            CourseSubject(
                subjectName = "Human-Computer Interaction",
                unitsRequired = 3.00,
                unitsTaken = 3.00,
                grade = "1.25",
                termTaken = 2001,
                status = "Taken",
                preRequisite = "Introduction to Computing"
            ),
            CourseSubject(
                subjectName = "IT Elective 1",
                unitsRequired = 3.00,
                unitsTaken = null,
                grade = null,
                termTaken = null,
                status = "Not Taken"
            ),
            CourseSubject(
                subjectName = "Principles of Communication",
                unitsRequired = 3.00,
                unitsTaken = 3.00,
                grade = "1.25",
                termTaken = 2001,
                status = "Taken"
            ),
            CourseSubject(
                subjectName = "Platform Technology (Operating Systems)",
                unitsRequired = 3.00,
                unitsTaken = 3.00,
                grade = "1.00",
                termTaken = 2001,
                status = "Taken"
            ),
        ),
        secondTermSubjects = listOf(
            CourseSubject(
                subjectName = "Information Management",
                unitsRequired = 3.00,
                unitsTaken = 3.00,
                grade = "1.00",
                termTaken = 2002,
                status = "Taken",
                preRequisite = "Data Structures and Algorithms"
            ),
            CourseSubject(
                subjectName = "Purposive Communication 2",
                unitsRequired = 3.00,
                unitsTaken = 3.00,
                grade = "1.25",
                termTaken = 2002,
                status = "Taken",
                preRequisite = "Purposive Communication 1"
            ),
            CourseSubject(
                subjectName = "Physical Education 4 (Team Sports)",
                unitsRequired = 2.00,
                unitsTaken = 2.00,
                grade = null,
                termTaken = 2101,
                status = "In-progress",
                preRequisite = "Physical Education 1 (PF & C)"
            ),
            CourseSubject(
                subjectName = "IT Elective 2",
                unitsRequired = 3.00,
                unitsTaken = null,
                grade = null,
                termTaken = null,
                status = "Not Taken"
            ),
            CourseSubject(
                subjectName = "Network Technology 1",
                unitsRequired = 3.00,
                unitsTaken = 3.00,
                grade = "1.00",
                termTaken = 2002,
                status = "Taken",
                preRequisite = "Introduction to Computing"
            ),
            CourseSubject(
                subjectName = "Quantitative Methods",
                unitsRequired = 3.00,
                unitsTaken = 3.00,
                grade = "1.50",
                termTaken = 2002,
                status = "Taken",
                preRequisite = "Discrete Structures 1 (DM)"
            ),
            CourseSubject(
                subjectName = "Technopreneurship",
                unitsRequired = 3.00,
                unitsTaken = 3.00,
                grade = "1.50",
                termTaken = 2002,
                status = "Taken"
            ),
            CourseSubject(
                subjectName = "Systems Integration and Architecture",
                unitsRequired = 3.00,
                unitsTaken = 3.00,
                grade = "1.25",
                termTaken = 2002,
                status = "Taken"
            ),
            CourseSubject(
                subjectName = "Integrative Programming",
                unitsRequired = 3.00,
                unitsTaken = 3.00,
                grade = null,
                termTaken = 2101,
                status = "In-progress",
                preRequisite = "Computer Programming 2"
            ),
        )
    ),
    ThirdYear(
        title = "Third Year",
        firstTermSubjects = listOf(
            CourseSubject(
                subjectName = "Application Development and Emerging Technologies",
                unitsRequired = 3.00,
                unitsTaken = 3.00,
                grade = null,
                termTaken = 2101,
                status = "In-progress",
                preRequisite = "Computer Programming 2"
            ),
            CourseSubject(
                subjectName = "Great Books",
                unitsRequired = 3.00,
                unitsTaken = 3.00,
                grade = "1.25",
                termTaken = 1901,
                status = "Taken"
            ),
            CourseSubject(
                subjectName = "Information Assurance & Security (Cybersecurity Fundamentals)",
                unitsRequired = 3.00,
                unitsTaken = 3.00,
                grade = null,
                termTaken = 2101,
                status = "In-progress",
                preRequisite = "Information Management"
            ),
            CourseSubject(
                subjectName = "Advanced Database Systems",
                unitsRequired = 3.00,
                unitsTaken = 3.00,
                grade = null,
                termTaken = 2101,
                status = "In-progress",
                preRequisite = "Information Management"
            ),
            CourseSubject(
                subjectName = "Event-Driven Programming",
                unitsRequired = 3.00,
                unitsTaken = 3.00,
                grade = null,
                termTaken = 2101,
                status = "In-progress",
                preRequisite = "Integrative Programming"
            ),
            CourseSubject(
                subjectName = "IT Elective 3",
                unitsRequired = 3.00,
                unitsTaken = 3.00,
                grade = null,
                termTaken = null,
                status = "Not Taken"
            ),
            CourseSubject(
                subjectName = "Data and Digital Communications (Data Communications)",
                unitsRequired = 3.00,
                unitsTaken = 3.00,
                grade = null,
                termTaken = 2101,
                status = "In-progress",
                preRequisite = "Principles of Communication"
            ),
            CourseSubject(
                subjectName = "Professional Issues in Information Systems and Technology",
                unitsRequired = 3.00,
                unitsTaken = 3.00,
                grade = null,
                termTaken = 2101,
                status = "In-progress",
                preRequisite = "Introduction to Computing"
            ),
        ),
        secondTermSubjects = listOf(
            CourseSubject(
                subjectName = "Information Assurance and Security (Data Privacy)",
                unitsRequired = 3.00,
                unitsTaken = null,
                grade = null,
                termTaken = null,
                status = "Not Taken",
                preRequisite = "Info Assurance & Sec (CF)"
            ),
            CourseSubject(
                subjectName = "Web Systems and Technologies",
                unitsRequired = 3.00,
                unitsTaken = null,
                grade = null,
                termTaken = null,
                status = "Not Taken",
                preRequisite = "App Dev & Emerging Tech\n"
            ),
            CourseSubject(
                subjectName = "Management Information Systems",
                unitsRequired = 3.00,
                unitsTaken = null,
                grade = null,
                termTaken = null,
                status = "Not Taken",
            ),
            CourseSubject(
                subjectName = " IT Capstone Project 1",
                unitsRequired = 3.00,
                unitsTaken = null,
                grade = null,
                termTaken = null,
                status = "Not Taken",
                preRequisite = "Advanced Database Systems"
            ),
            CourseSubject(
                subjectName = "Network Technology 2",
                unitsRequired = 3.00,
                unitsTaken = null,
                grade = null,
                termTaken = null,
                status = "Not Taken",
                preRequisite = "Network Technology 1"
            ),
            CourseSubject(
                subjectName = "Advanced Systems Integration and Architecture",
                unitsRequired = 3.00,
                unitsTaken = null,
                grade = null,
                termTaken = null,
                status = "Not Taken",
                preRequisite = "Systems Integration & Arch"
            ),
        )
    ),
    FourthYear(
        title = "Fourth Year",
        firstTermSubjects = listOf(
            CourseSubject(
                subjectName = "Euthenics 2",
                unitsRequired = 1.00,
                unitsTaken = null,
                grade = null,
                termTaken = null,
                status = "Not Taken",
                preRequisite = "Euthenics 1"
            ),
            CourseSubject(
                subjectName = "Mobile Systems and Technologies",
                unitsRequired = 3.00,
                unitsTaken = null,
                grade = null,
                termTaken = null,
                status = "Not Taken",
                preRequisite = "App Dev & Emerging Tech"
            ),
            CourseSubject(
                subjectName = "IT Capstone Project 2",
                unitsRequired = 3.00,
                unitsTaken = null,
                grade = null,
                termTaken = null,
                status = "Not Taken",
                preRequisite = "IT Capstone Project 2"
            ),
            CourseSubject(
                subjectName = "IT Elective 4",
                unitsRequired = 3.00,
                unitsTaken = null,
                grade = null,
                termTaken = null,
                status = "Not Taken",
            ),
            CourseSubject(
                subjectName = "Computer Graphics Programming",
                unitsRequired = 3.00,
                unitsTaken = null,
                grade = null,
                termTaken = null,
                status = "Not Taken",
                preRequisite = "Computer Programming 2"
            ),
            CourseSubject(
                subjectName = "IT Service Management",
                unitsRequired = 3.00,
                unitsTaken = null,
                grade = null,
                termTaken = null,
                status = "Not Taken",
            ),
        ),
        secondTermSubjects = listOf(
            CourseSubject(
                subjectName = "IT Practicum (486 hours)",
                unitsRequired = 9.00,
                unitsTaken = null,
                grade = null,
                termTaken = null,
                status = "Not Taken",
            ),
        )
    ),
    ElectiveCourses(
        title = "Elective Courses",
        firstTermSubjects = listOf(
            CourseSubject(
                subjectName = "Object-Oriented Programming",
                unitsRequired = 3.00,
                unitsTaken = 3.00,
                grade = "1.00",
                termTaken = 2001,
                status = "Taken",
                preRequisite = "Computer Programming 2"
            ),
            CourseSubject(
                subjectName = "Enterprise Architecture",
                unitsRequired = 3.00,
                unitsTaken = 3.00,
                grade = "1.25",
                termTaken = 2002,
                status = "Taken",
                preRequisite = "Object-Oriented Programming"
            ),
            CourseSubject(
                subjectName = "Programming Languages",
                unitsRequired = 3.00,
                unitsTaken = 3.00,
                grade = null,
                termTaken = 2101,
                status = "In-progress",
                preRequisite = "Enterprise Architecture"
            ),
            CourseSubject(
                subjectName = "Game Development",
                unitsRequired = 3.00,
                unitsTaken = null,
                grade = null,
                termTaken = null,
                status = "Not Taken",
                preRequisite = "Enterprise Architecture"
            ),
        ),
        secondTermSubjects = listOf(
            CourseSubject(
                subjectName = "Introduction to Digital Graphics Design",
                unitsRequired = 3.00,
                unitsTaken = null,
                grade = null,
                termTaken = null,
                status = "Not Taken",
                preRequisite = "Computer Programming 2"
            ),
            CourseSubject(
                subjectName = "Introduction to Computer Animation",
                unitsRequired = 3.00,
                unitsTaken = null,
                grade = null,
                termTaken = null,
                status = "Not Taken",
                preRequisite = "Intro to Digital Graphics Des"
            ),
            CourseSubject(
                subjectName = "Advanced Digital Graphics Design",
                unitsRequired = 3.00,
                unitsTaken = null,
                grade = null,
                termTaken = null,
                status = "Not Taken",
                preRequisite = "Intro to Computer Animation"
            ),
            CourseSubject(
                subjectName = "Advanced Computer Animation",
                unitsRequired = 3.00,
                unitsTaken = null,
                grade = null,
                termTaken = null,
                status = "Not Taken",
                preRequisite = "Advanced Dig Graphics Design"
            ),
        ),
        electiveCourses = listOf(
            CourseSubject(
                subjectName = "Computer Systems Architecture",
                unitsRequired = 3.00,
                unitsTaken = null,
                grade = null,
                termTaken = null,
                status = "Not Taken",
                preRequisite = "Computer Programming 2"
            ),
            CourseSubject(
                subjectName = "Robot Dynamics Fundamentals",
                unitsRequired = 3.00,
                unitsTaken = null,
                grade = null,
                termTaken = null,
                status = "Not Taken",
                preRequisite = "Computer Systems Architecture"
            ),
            CourseSubject(
                subjectName = "Intermediate Human-Computer Interaction",
                unitsRequired = 3.00,
                unitsTaken = null,
                grade = null,
                termTaken = null,
                status = "Not Taken",
                preRequisite = "Robot Dynamics Fundamentals"
            ),
            CourseSubject(
                subjectName = "Robot Assembly and Programming",
                unitsRequired = 3.00,
                unitsTaken = null,
                grade = null,
                termTaken = null,
                status = "Not Taken",
                preRequisite = "Inter Human-Comp Interaction"
            ),
        )
    ),
}
