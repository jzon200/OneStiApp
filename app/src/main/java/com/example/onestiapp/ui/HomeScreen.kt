package com.example.onestiapp.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.onestiapp.R
import com.example.onestiapp.Screens
import com.example.onestiapp.data.*
import com.example.onestiapp.model.MainViewModel
import com.example.onestiapp.ui.components.OneStiDivider
import com.example.onestiapp.ui.theme.OneStiAppTheme
import com.example.onestiapp.ui.theme.OpenSans
import com.example.onestiapp.ui.theme.courseSubjectColor

@ExperimentalMaterialApi
@Composable
fun HomeScreen(viewModel: MainViewModel, navController: NavController) {
    viewModel.setCurrentScreen(Screens.Home)
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(10.dp)
    ) {
        LatestNewsCard(
            newsTitle = "STI Students to Represent PH in the Global Stage",
            description = "Meet the STI students who will be competing at the Asia Pacific and Global levels of the Huawei ICT Competition 2021",
            imageIdRes = R.drawable.new_huawei_thumb
        )
        Spacer(Modifier.height(12.dp))
        ClassScheduleCard(navController)
        Spacer(Modifier.height(12.dp))
        PaymentScheduleCard(navController)
        Spacer(Modifier.height(12.dp))
        LatestGradeCard(navController)
    }
}


@Composable
private fun LatestNewsCard(newsTitle: String, description: String, @DrawableRes imageIdRes: Int) {
    Card(elevation = 2.dp) {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Latest News",
                    style = MaterialTheme.typography.subtitle1
                )
                Text(
                    text = "MORE NEWS",
                    style = MaterialTheme.typography.overline.copy(
                        color = MaterialTheme.colors.primary,
                        fontWeight = FontWeight.Medium
                    ),
                )
            }
            Spacer(modifier = Modifier.size(4.dp))
            OneStiDivider()
            Spacer(modifier = Modifier.size(12.dp))
            Text(
                text = newsTitle,
                style = MaterialTheme.typography.subtitle2
            )
            Spacer(modifier = Modifier.size(12.dp))
            Row(Modifier.fillMaxWidth()) {
                Image(
                    painterResource(id = imageIdRes),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.fillMaxWidth(0.66f)
                )
                Spacer(modifier = Modifier.size(12.dp))
                Text(
                    text = description,
                    style = MaterialTheme.typography.overline.copy(fontFamily = OpenSans)
                )
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
private fun ClassScheduleCard(navController: NavController) {
    Card(elevation = 2.dp, onClick = {
        navController.navigate(Screens.ClassSchedule.route) {
            launchSingleTop = true
        }
    }) {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Classes for Today|${getDay()}",
                style = MaterialTheme.typography.subtitle1
            )
            Spacer(Modifier.size(4.dp))
            Text(
                text = "AS OF ${getDate()}",
                style = MaterialTheme.typography.overline
            )
            Spacer(modifier = Modifier.size(6.dp))
            OneStiDivider()
            Spacer(modifier = Modifier.size(14.dp))
            // If there's no class schedule, do this
            if (getCurrentClassSchedule().isEmpty()) {
                Text(
                    text = "Your schedule is free today.",
                    style = MaterialTheme.typography.caption
                )
            } else {
                // Iterates the @Composable ClassScheduleItem
                // depending on the list of schedules in the current day
                getCurrentClassSchedule().forEachIndexed { index, classSchedule ->
                    ClassScheduleItem(
                        schedule = classSchedule,
                        color = courseSubjectColor[index]
                    )
                }
            }
        }
    }
}

@Composable
private fun ClassScheduleItem(
    schedule: ClassSchedule,
    color: Color
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .background(color)
                .height(58.dp)
                .width(96.dp)
        ) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = schedule.classStart,
                    style = MaterialTheme.typography.subtitle2.copy(color = MaterialTheme.colors.onPrimary),
                )
                Text(
                    text = "to ${schedule.classEnd}",
                    style = MaterialTheme.typography.caption.copy(color = MaterialTheme.colors.onPrimary),
                )
            }
        }
        Spacer(Modifier.size(12.dp))
        Column(Modifier.fillMaxWidth()) {
            Text(
                text = schedule.courseSubject,
                style = MaterialTheme.typography.subtitle2
            )
            Spacer(Modifier.height(2.dp))
            Text(
                text = "${schedule.classRoom} | ${schedule.classProfessor.uppercase()}",
                style = MaterialTheme.typography.overline
            )
        }
    }
}

@ExperimentalMaterialApi
@Composable
private fun PaymentScheduleCard(navController: NavController) {
    Card(elevation = 2.dp, onClick = {
        navController.navigate(Screens.StudentBalance.route) {
            launchSingleTop = true
        }
    }) {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Payment Schedule",
                    style = MaterialTheme.typography.subtitle1
                )
                Text(
                    text = "VIEW ALL",
                    style = MaterialTheme.typography.overline.copy(
                        color = MaterialTheme.colors.primary,
                        fontWeight = FontWeight.Medium
                    )
                )
            }
            Spacer(modifier = Modifier.size(4.dp))
            Text(
                text = "AS OF ${getDate()}",
                style = MaterialTheme.typography.overline
            )
            Spacer(modifier = Modifier.size(6.dp))
            OneStiDivider()
            Spacer(modifier = Modifier.size(12.dp))
            val latestPaymentSchedule = StudentBalance.ThirdYearFirstTerm.paymentScheduleList[1]
            Row(Modifier.fillMaxWidth()) {
                Column {
                    Text(
                        text = "Next Payment Amount",
                        style = MaterialTheme.typography.body1
                    )
                    Text(
                        text = "PhP ${String.format("%,.2f", latestPaymentSchedule.amountBalance)} ",
                        style = MaterialTheme.typography.subtitle1
                    )
                }
                Spacer(modifier = Modifier.size(36.dp))
                Column {
                    Text(
                        text = "Due Date",
                        style = MaterialTheme.typography.body2
                    )
                    Text(
                        text = latestPaymentSchedule.scheduleDate,
                        style = MaterialTheme.typography.subtitle1
                    )
                }
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun LatestGradeCard(navController: NavController) {
    Card(elevation = 2.dp, onClick = {
        navController.navigate(Screens.Grades.route) {
            launchSingleTop = true
        }
    }) {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Latest Grade",
                    style = MaterialTheme.typography.subtitle1
                )
                Text(
                    text = "VIEW ALL",
                    style = MaterialTheme.typography.overline.copy(
                        color = MaterialTheme.colors.primary,
                        fontWeight = FontWeight.Medium
                    ),
                )
            }
            Text(
                text = "AS OF ${getDate()}",
                style = MaterialTheme.typography.overline
            )
            Spacer(modifier = Modifier.size(4.dp))
            OneStiDivider()
            Spacer(modifier = Modifier.size(8.dp))
            val latestGrade = GradesPerTerm.ThirdYearFirstTerm.gradesList[0]
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = latestGrade.instructorName.uppercase(),
                        style = MaterialTheme.typography.overline,
                    )
                    Text(
                        text = latestGrade.subjectName,
                        style = MaterialTheme.typography.body1.copy(
                            fontWeight = FontWeight.Medium,
                            fontSize = 18.sp
                        ),
                        modifier = Modifier.widthIn(max = 250.dp)
                    )
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "PRELIM",
                        style = MaterialTheme.typography.overline.copy(
                            color = MaterialTheme.colors.primary,
                            fontWeight = FontWeight.Medium
                        ),
                    )
                    Text(
                        text = String.format("%.2f", latestGrade.gradesEveryPeriodList.first()),
                        style = MaterialTheme.typography.body1.copy(
                            fontWeight = FontWeight.Medium,
                            fontSize = 18.sp
                        ),
                    )
                }
            }
        }
    }
}

@ExperimentalMaterialApi
@Preview(showBackground = true, backgroundColor = 0xFFEDF1F4)
@Composable
fun HomeScreenPreview() {
    OneStiAppTheme {
        HomeScreen(MainViewModel(), navController = rememberNavController())
    }
}

