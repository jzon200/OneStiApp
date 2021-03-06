package com.example.onestiapp.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTimeFilled
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Launch
import androidx.compose.material.icons.outlined.Circle
import androidx.compose.material.icons.outlined.Info
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.onestiapp.Screens
import com.example.onestiapp.data.CourseSubject
import com.example.onestiapp.data.ProgramCurriculum
import com.example.onestiapp.data.getDate
import com.example.onestiapp.model.MainViewModel
import com.example.onestiapp.ui.components.OneStiDivider
import com.example.onestiapp.ui.theme.DrawerContentIconColor
import com.example.onestiapp.ui.theme.OneStiAppTheme
import com.example.onestiapp.ui.theme.courseSubjectColor


@ExperimentalMaterialApi
@ExperimentalAnimationApi
@Composable
fun ProgramCurriculumScreen(
    viewModel: MainViewModel
) {
    viewModel.setCurrentScreen(Screens.ProgramCurriculum)
    val programCurriculum = ProgramCurriculum.values().toList()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(14.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ProgramCurriculumCard(
            programTitle = "BSIT-19-01",
            totalUnits = 166.00,
            taken = 97
        )
        ProgramCurriculumIndicatorIcons()
        programCurriculum.forEach {
            ITCurriculumCard(
                programCurriculum = it
            )
        }
    }
}

@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
private fun ITCurriculumCard(programCurriculum: ProgramCurriculum) {
    var expandedState by remember { mutableStateOf(false) } // First Term
    var expandedState2 by remember { mutableStateOf(false) } // Second Term
    var expandedState3 by remember { mutableStateOf(false) } // Elective Course (Optional)
    val rotateIcon by animateFloatAsState(if (expandedState || expandedState2) 180f else 0f)
    Card(elevation = 2.dp) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = programCurriculum.title, // First Year ...
                    style = MaterialTheme.typography.subtitle1
                )
                Icon(
                    imageVector = Icons.Default.Launch,
                    contentDescription = Icons.Default.Launch.name,
                    tint = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .size(22.dp)
                        .rotate(rotateIcon)
                        .clickable {
                            if (!expandedState && !expandedState2 && !expandedState3) {
                                expandedState = true
                                expandedState2 = true
                                expandedState3 = true
                            } else if (expandedState || expandedState2 || expandedState3) {
                                expandedState = false
                                expandedState2 = false
                                expandedState3 = false
                            }
                        }
                )
            }
            OneStiDivider(modifier = Modifier.padding(vertical = 10.dp))
            val isElectiveCourse = programCurriculum == ProgramCurriculum.ElectiveCourses
            // First Term
            TermRow(
                title = if (isElectiveCourse) "Elective Courses" else "First Term",
                subjectItems = programCurriculum.firstTermSubjects,
                expanded = expandedState
            ) {
                expandedState = !expandedState
            }
            // Second Term
            Spacer(modifier = Modifier.height(10.dp))
            TermRow(
                title = if (isElectiveCourse) "Elective Courses" else "Second Term",
                subjectItems = programCurriculum.secondTermSubjects,
                expanded = expandedState2
            ) {
                expandedState2 = !expandedState2
            }
            if (isElectiveCourse) {
                // Elective Course (Optional)
                Spacer(modifier = Modifier.height(10.dp))
                TermRow(
                    title = "Elective Courses",
                    subjectItems = programCurriculum.electiveCourses,
                    expanded = expandedState3
                ) {
                    expandedState3 = !expandedState3
                }
            }
        }
    }
    // Card Spacing
    Spacer(modifier = Modifier.height(8.dp))
}

@ExperimentalMaterialApi
@ExperimentalAnimationApi
@Composable
fun TermRow(
    title: String,
    subjectItems: List<CourseSubject>,
    expanded: Boolean,
    onClick: () -> Unit
) {
    val rotateIcon by animateFloatAsState(if (expanded) 180f else 0f)
    Surface(
        modifier = Modifier.fillMaxWidth(),
        onClick = {
            onClick()
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .animateContentSize()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Launch,
                    contentDescription = Icons.Default.Launch.name,
                    tint = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .size(18.dp)
                        .rotate(rotateIcon)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = " $title",
                    style = MaterialTheme.typography.body1.copy(
                        color = MaterialTheme.colors.primary,
                        fontWeight = FontWeight.Medium,
                        textDecoration = TextDecoration.Underline
                    )
                )
            }
            if (expanded) {
                // Display Course Subjects
                subjectItems.forEach { courseSubject ->
                    SubjectColumn(courseSubject = courseSubject)
                    // last item has no Divider
                    if (courseSubject != subjectItems.last()) {
                        Divider(modifier = Modifier.padding(top = 8.dp))
                    }
                }
            }
        }
    }
}

@Composable
private fun SubjectColumn(
    courseSubject: CourseSubject
) {
    Spacer(modifier = Modifier.height(8.dp))
    val statusIcon = when (courseSubject.status) {
        "Taken" -> Icons.Default.CheckCircle
        "In-progress" -> Icons.Default.AccessTimeFilled
        else -> Icons.Outlined.Circle
    }
    val statusIconTint = when (courseSubject.status) {
        "Taken" -> courseSubjectColor.last()
        "In-progress" -> courseSubjectColor[1]
        else -> DrawerContentIconColor
    }
    Column(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = statusIcon,
                contentDescription = statusIcon.name,
                tint = statusIconTint,
                modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = courseSubject.subjectName,
                style = MaterialTheme.typography.body2.copy(fontWeight = FontWeight.Medium)
            )
        }
        Column(
            Modifier
                .fillMaxWidth()
                .padding(start = 24.dp)
        ) {
            Spacer(modifier = Modifier.height(4.dp))
            // Units
            Text(
                text = buildAnnotatedString {
                    append(text = "Units: ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Medium)) {
                        append(String.format("%.2f", courseSubject.unitsRequired))
                    }
                    append(text = " required")
                    if (courseSubject.unitsTaken != null) {
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Medium)) {
                            append(", ${String.format("%.2f", courseSubject.unitsTaken)}")
                        }
                        append(text = " taken")
                    }
                },
                style = MaterialTheme.typography.body2
            )
            // Grade
            if (courseSubject.grade != null) {
                Text(
                    text = buildAnnotatedString {
                        append(text = "Grade: ")
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Medium)) {
                            append(text = courseSubject.grade)
                        }
                    },
                    style = MaterialTheme.typography.body2
                )
            }
            // Term Taken
            if (courseSubject.termTaken != null) {
                Text(
                    text = buildAnnotatedString {
                        append(text = "Term Taken: ")
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Medium)) {
                            append(text = courseSubject.termTaken.toString())
                        }
                    },
                    style = MaterialTheme.typography.body2
                )
            }
            // Pre-requisite
            if (courseSubject.preRequisite != null) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = buildAnnotatedString {
                        append(text = "Pre - Requisite / Co - Requisite: ")
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Medium)) {
                            append(text = courseSubject.preRequisite)
                        }
                    },
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}

@Composable
private fun ProgramCurriculumIndicatorIcons() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.CheckCircle,
            contentDescription = Icons.Default.CheckCircle.name,
            tint = courseSubjectColor.last(),
            modifier = Modifier.size(16.dp)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = "Taken",
            style = MaterialTheme.typography.subtitle2,
        )

        Spacer(modifier = Modifier.width(4.dp))
        Icon(
            imageVector = Icons.Filled.AccessTimeFilled,
            contentDescription = Icons.Filled.AccessTimeFilled.name,
            tint = courseSubjectColor[1],
            modifier = Modifier.size(16.dp)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = "In-progress",
            style = MaterialTheme.typography.subtitle2
        )

        Spacer(modifier = Modifier.width(4.dp))
        Icon(
            imageVector = Icons.Outlined.Circle,
            contentDescription = Icons.Outlined.Circle.name,
            tint = DrawerContentIconColor,
            modifier = Modifier.size(16.dp)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = "Not Yet Taken",
            style = MaterialTheme.typography.subtitle2
        )
    }
}

@Composable
private fun ProgramCurriculumCard(
    programTitle: String,
    totalUnits: Double,
    taken: Int
) {
    Card(elevation = 2.dp) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "AS OF ${getDate()}",
                style = MaterialTheme.typography.overline
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "$programTitle Curriculum",
                    style = MaterialTheme.typography.subtitle1
                )
                Icon(
                    imageVector = Icons.Outlined.Info,
                    contentDescription = Icons.Outlined.Info.name,
                    tint = MaterialTheme.colors.primary,
                    modifier = Modifier.size(20.dp)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            OneStiDivider()
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                buildAnnotatedString {
                    append("Total Units:")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Medium)) {
                        append(String.format("%.2f", totalUnits))
                    }
                    append(" required, ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Medium)) {
                        append(taken.toString())
                    }
                    append(" taken, ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Medium)) {
                        append(String.format("%.2f", totalUnits - taken))
                    }
                    append("\nneeded")

                }, style = MaterialTheme.typography.body2
            )
        }
    }
}

@ExperimentalMaterialApi
@ExperimentalAnimationApi
@Preview(showBackground = true, backgroundColor = 0xFFEDF1F4)
@Composable
fun ProgramCurriculumPreview() {
    OneStiAppTheme {
        ProgramCurriculumScreen(viewModel = MainViewModel())
    }
}
