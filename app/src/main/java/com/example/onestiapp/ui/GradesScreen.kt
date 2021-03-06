package com.example.onestiapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onestiapp.R
import com.example.onestiapp.Screens
import com.example.onestiapp.data.Grade
import com.example.onestiapp.data.GradesPerTerm
import com.example.onestiapp.data.getCourseGrade
import com.example.onestiapp.data.getGWA
import com.example.onestiapp.model.MainViewModel
import com.example.onestiapp.ui.components.OneStiDivider
import com.example.onestiapp.ui.components.OneStiSelectionButton
import com.example.onestiapp.ui.theme.GradesSectionColor
import com.example.onestiapp.ui.theme.OneStiAppTheme

@Composable
fun GradesScreen(
    viewModel: MainViewModel
) {
    viewModel.setCurrentScreen(Screens.Grades)
    val text by viewModel.gradesTextButton.observeAsState("2021-2022 First Term")
    val gradesPerTerm by viewModel.gradesPerTerm.observeAsState(GradesPerTerm.SecondYearSecondTerm)
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OneStiSelectionButton(text = text,
            alertDialogTitle = "School Year/Term",
            items = listOf(
                "2021-2022 First Term",
                "2020-2021 Second Term",
                "2020-2021 First Term",
                "2019-2020 Second Term",
                "2019-2020 First Term",
            ),
            onItemClicked = {
                viewModel.onGradesTermSelected(it)
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        GradesListColumn(gradesPerTerm.gradesList, gradesPerTerm.cumulativeGWA)
    }
}

@Composable
fun GwaCard(gwa: Double, cumulativeGWA: Double?) {
    Card(elevation = 2.dp) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.gwa_graph),
                contentDescription = null,
                modifier = Modifier.size(44.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(
                    text = "GWA: ${String.format("%.2f", gwa)}",
                    style = MaterialTheme.typography.subtitle1
                )
                Text(
                    text = "Cumulative GWA: ${String.format("%.2f", cumulativeGWA)}",
                    style = MaterialTheme.typography.subtitle1
                )
            }
        }
    }
}

@Composable
fun GradesListColumn(grades: List<Grade>, cumulativeGWA: Double?) {
    LazyColumn {
        item {
            val gwa = getGWA(grades = grades)
            if (gwa != null) {
                GwaCard(gwa = gwa, cumulativeGWA = cumulativeGWA)
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
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
                Text(
                    text = grade.subjectName,
                    style = MaterialTheme.typography.subtitle1.copy(fontSize = 17.sp),
                    modifier = Modifier.widthIn(max = 275.dp)
                )
                // If the grades are not yet complete
                // will not display Course Grade
                if (!grade.gradesEveryPeriodList.contains(null)) {
                    Text(
                        text = String.format("%.2f", getCourseGrade(grade.gradesEveryPeriodList)),
                        style = MaterialTheme.typography.subtitle1.copy(fontSize = 17.sp),
                        modifier = Modifier.padding(end = 8.dp)
                    )
                }
            }

            OneStiDivider(modifier = Modifier.padding(top = 8.dp, bottom = 6.dp))

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
            style = MaterialTheme.typography.body2.copy(
                MaterialTheme.colors.primary,
                fontWeight = FontWeight.Medium
            )
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFEDF1F4)
@Composable
fun GradesScreenPreview() {
    OneStiAppTheme {
        GradesScreen(viewModel = MainViewModel())
    }
}