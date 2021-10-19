package com.example.onestiapp.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateValueAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Circle
import androidx.compose.material.icons.outlined.Info
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.onestiapp.data.CourseSubject
import com.example.onestiapp.data.firstYearFirstTermSubjects
import com.example.onestiapp.data.firstYearSecondTermSubjects
import com.example.onestiapp.data.getDate
import com.example.onestiapp.ui.theme.DrawerContentIconColor
import com.example.onestiapp.ui.theme.OneStiAppTheme
import com.example.onestiapp.ui.theme.courseSubjectColor


@ExperimentalMaterialApi
@ExperimentalAnimationApi
@Composable
fun ProgramCurriculumScreen() {
    // Holds the topic that is currently expanded to show its body.
    var expandedTopic by remember { mutableStateOf<String?>(null) }
    val rotateIcon by animateFloatAsState(if (expandedTopic != null) 180f else 0f)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ProgramCurriculumCard(
            programTitle = "BSIT-19-01",
            totalUnits = 166.00,
            taken = 97
        )
        ProgramCurriculumIndicatorIcons()
        Card(elevation = 4.dp) {
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
                        text = "First Year",
                        style = MaterialTheme.typography.subtitle1
                    )
                    Icon(
                        imageVector = Icons.Default.Launch,
                        contentDescription = Icons.Default.Launch.name,
                        tint = MaterialTheme.colors.primary,
                        modifier = Modifier
                            .size(18.dp)
                            .rotate(rotateIcon)
                            .clickable {
                                expandedTopic =
                                    if (expandedTopic == "First Term" || expandedTopic == "Second Term") null else "First Term"
                            }
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                CustomDivider()
                Spacer(modifier = Modifier.height(10.dp))
                TermRow(
                    term = "First Term",
                    subjectItems = firstYearFirstTermSubjects,
                    expanded = expandedTopic == "First Term"
                ) {
                    expandedTopic = if (expandedTopic == "First Term") null else "First Term"
                }
                Spacer(modifier = Modifier.height(10.dp))
                TermRow(
                    term = "Second Term",
                    subjectItems = firstYearSecondTermSubjects,
                    expanded = expandedTopic == "Second Term"
                ) {
                    expandedTopic = if (expandedTopic == "Second Term") null else "Second Term"
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
private fun FirstYearSubjectRow(
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

    Row(Modifier.fillMaxWidth()) {
        Icon(
            imageVector = statusIcon,
            contentDescription = statusIcon.name,
            tint = statusIconTint,
            modifier = Modifier
                .size(18.dp)
                .offset(y = 1.dp)
        )
        Column(
            Modifier
                .fillMaxWidth()
                .padding(start = 8.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = courseSubject.subjectName,
                style = MaterialTheme.typography.body2.copy(fontWeight = FontWeight.Medium)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = buildAnnotatedString {
                    append(text = "Units: ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Medium)) {
                        append(String.format("%.2f", courseSubject.unitsRequired))
                    }
                    append(text = " required, ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Medium)) {
                        append(String.format("%.2f", courseSubject.unitsRequired))
                    }
                    append(text = " taken")
                },
                style = MaterialTheme.typography.body2
            )
            Text(
                text = buildAnnotatedString {
                    append(text = "Grade: ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Medium)) {
                        append(text = String.format("%.2f", courseSubject.grade))
                    }
                },
                style = MaterialTheme.typography.body2
            )
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
    }
}

@ExperimentalMaterialApi
@ExperimentalAnimationApi
@Composable
fun TermRow(
    term: String,
    subjectItems: List<CourseSubject>,
    expanded: Boolean,
    onClick: () -> Unit
) {
    val rotateIcon by animateFloatAsState(if (expanded) 180f else 0f)
    TermRowSpacer(visible = expanded)
    Surface(
        modifier = Modifier.fillMaxWidth(),
        onClick = onClick
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
                    text = " $term",
                    style = MaterialTheme.typography.body1.copy(
                        color = MaterialTheme.colors.primary,
                        fontWeight = FontWeight.Medium,
                        textDecoration = TextDecoration.Underline
                    )
                )
            }
            if (expanded) {
                subjectItems.forEach { courseSubject ->
                    FirstYearSubjectRow(courseSubject)
                    if (courseSubject != subjectItems.last()){
                        Divider(modifier = Modifier.padding(top = 8.dp))
                    }
                }
            }
        }
    }
    TermRowSpacer(visible = expanded)
}

@ExperimentalAnimationApi
@Composable
fun TermRowSpacer(visible: Boolean) {
    AnimatedVisibility(visible = visible) {
        Spacer(modifier = Modifier.height(8.dp))
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
            CustomDivider()
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
        ProgramCurriculumScreen()
    }
}
