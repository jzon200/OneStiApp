package com.example.onestiapp.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.onestiapp.data.Grade
import com.example.onestiapp.data.getCourseGrade
import com.example.onestiapp.data.secondYearSecondTermGrades
import com.example.onestiapp.ui.theme.GradesSectionColor
import com.example.onestiapp.ui.theme.OneStiAppTheme

@Composable
fun GradesScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SchoolTermButton()
        Spacer(modifier = Modifier.height(16.dp))
        GradesListColumn(secondYearSecondTermGrades)
    }
}

@Composable
private fun SchoolTermButton() {
    Card(
        elevation = 1.5.dp,
        shape = RoundedCornerShape(12.dp),
        contentColor = MaterialTheme.colors.primary,
        modifier = Modifier
            .fillMaxWidth()
            .size(38.dp)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) {

            }
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                imageVector = Icons.Default.CalendarToday,
                contentDescription = Icons.Default.CalendarToday.name,
                modifier = Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = "2020-2021 Second Term",
                style = MaterialTheme.typography.subtitle2
            )
            Spacer(modifier = Modifier.width(4.dp))
            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = Icons.Default.ArrowDropDown.name,
                modifier = Modifier.size(32.dp)
            )
        }
    }
}

//@Composable
//fun SchoolTermDialogCard() {
//    var openDialog by remember { mutableStateOf(false) }
//
//    if (openDialog) {
//
//    }
//}
//
//@Composable
//fun SchoolTermDialog(
//    onDismiss: () -> Unit,
//    titleText: String = "School Year/Term",
//    buttonText: String = "CANCEL"
//) {
//    AlertDialog(
//        onDismissRequest = onDismiss,
//
//        title = {
//            Text(text = titleText)
//        },
//        text = {
//            Text(
//                buttonText
//            )
//        },
//        buttons = {
//            TextButton(onClick = onDismiss) {
//                Text(buttonText)
//            }
//        }
//    )
//}

@Composable
fun GradesListColumn(grades: List<Grade>) {
    LazyColumn {
        items(grades) { grade ->
            GradesCard(grade)
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}

@Composable
private fun GradesCard(grade: Grade) {
    Card(elevation = 2.dp) {
        Column(
            modifier = Modifier.padding(vertical = 10.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(Modifier.fillMaxWidth(0.74f)) {
                    Text(
                        text = grade.subjectName,
                        style = MaterialTheme.typography.subtitle1
                    )
                }
                Text(
                    text = getCourseGrade(grade.gradesEveryPeriodList),
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier.padding(end = 8.dp)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            CustomDivider()
            Spacer(modifier = Modifier.height(6.dp))

            // Iterates the Grades of every grading period
            var numberOfNulls = 0
            val gradingPeriodList = listOf("Prelim", "Midterm", "Pre Finals", "Finals")
            grade.gradesEveryPeriodList.forEachIndexed { index, grade ->
                if (grade != null) {
                    GradingPeriodItem(gradingPeriod = gradingPeriodList[index], grade = grade)
                } else {
                    numberOfNulls++
                }
            }

            // Displays the Text ("No grades available.") if the list of grades are all null
            if (numberOfNulls == 4) {
                Text(
                    text = "No grades available.",
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                )
                numberOfNulls = 0
            }

            Divider(modifier = Modifier.padding(vertical = 8.dp))
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = Icons.Default.Person.name,
                        tint = GradesSectionColor,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = grade.instructorName.uppercase(),
                        style = MaterialTheme.typography.overline,
                    )
                }
                Text(
                    text = grade.uploadDate,
                    style = MaterialTheme.typography.overline,
                    modifier = Modifier.padding(end = 8.dp),
                )
            }
        }
    }
}

@Composable
private fun GradingPeriodItem(gradingPeriod: String, grade: Double?) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 2.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = gradingPeriod,
            style = MaterialTheme.typography.body2
        )
        Text(
            text = String.format("%.2f", grade),
            style = MaterialTheme.typography.body2,
            color = MaterialTheme.colors.primary,
            fontWeight = FontWeight.Medium
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GradesScreenPreview() {
    OneStiAppTheme {
        Surface {
            GradesScreen()
        }
    }
}