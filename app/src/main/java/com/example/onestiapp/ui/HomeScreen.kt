package com.example.onestiapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.onestiapp.R
import com.example.onestiapp.data.ClassSchedule
import com.example.onestiapp.data.getClassSchedule
import com.example.onestiapp.data.getDate
import com.example.onestiapp.data.getDay
import com.example.onestiapp.ui.theme.*

@Composable
fun HomeScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(10.dp)
    ) {
        LatestNewsCard()
        Spacer(Modifier.height(12.dp))
        ClassScheduleCard()
        Spacer(Modifier.height(12.dp))
        PaymentScheduleCard()
        Spacer(Modifier.height(12.dp))
        LatestGradeCard()
    }
}


@Composable
fun LatestNewsCard() {
    Card(elevation = 2.dp) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
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
                    style = MaterialTheme.typography.overline,
                    color = MaterialTheme.colors.primary
                )
            }
            Spacer(modifier = Modifier.size(4.dp))
            CustomDivider()
            Spacer(modifier = Modifier.size(12.dp))
            Text(
                text = "Equipping STI Learners with SAP Business One Skills",
                style = MaterialTheme.typography.subtitle2
            )
            Spacer(modifier = Modifier.size(12.dp))
            Row(Modifier.fillMaxWidth()) {
                Image(
                    painterResource(id = R.drawable.latest_news),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.fillMaxWidth(0.66f)
                )
                Spacer(modifier = Modifier.size(12.dp))
                Text(
                    text = "Find out how STI turns students into job-ready individuals through SAP Business One Cloud System.",
                    style = MaterialTheme.typography.overline,
                    fontFamily = OpenSans
                )
            }
        }
    }
}

@Composable
fun ClassScheduleCard() {
    Card(elevation = 2.dp) {
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
            CustomDivider()
            Spacer(modifier = Modifier.size(14.dp))
            // If there's no class schedule, do this
            if (getClassSchedule().isEmpty()) {
                Text(
                    text = "Your schedule is free today.",
                    style = MaterialTheme.typography.caption
                )
            } else {
                // Iterates the @Composable ClassScheduleItem
                // depending on the list of schedules in the current day
                getClassSchedule().forEachIndexed { index, classSchedule ->
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
                    style = MaterialTheme.typography.subtitle2,
                    color = Color.White
                )
                Text(
                    text = "to ${schedule.classEnd}",
                    style = MaterialTheme.typography.caption,
                    color = Color.White
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

@Composable
fun PaymentScheduleCard() {
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
                    text = "Payment Schedule",
                    style = MaterialTheme.typography.subtitle1
                )
                Text(
                    text = "VIEW ALL",
                    style = MaterialTheme.typography.overline,
                    color = MaterialTheme.colors.primary
                )
            }
            Spacer(modifier = Modifier.size(4.dp))
            Text(text = "AS OF ${getDate()}", style = MaterialTheme.typography.overline)
            Spacer(modifier = Modifier.size(6.dp))
            CustomDivider()
            Spacer(modifier = Modifier.size(12.dp))
            Row(Modifier.fillMaxWidth()) {
                Column {
                    Text(
                        text = "Next Payment Amount",
                        style = MaterialTheme.typography.body1
                    )
                    Text(
                        text = "PhP 1,364.80",
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
                        text = "08 Oct, 2021",
                        style = MaterialTheme.typography.subtitle1
                    )
                }
            }
        }
    }
}

@Composable
fun LatestGradeCard() {
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
                    text = "Latest Grade",
                    style = MaterialTheme.typography.subtitle1
                )
                Text(
                    text = "VIEW ALL",
                    style = MaterialTheme.typography.overline,
                    color = MaterialTheme.colors.primary
                )
            }
            Spacer(modifier = Modifier.size(4.dp))
            CustomDivider()
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = "JEFFERSON PRADO",
                style = MaterialTheme.typography.caption
            )
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Data Structures & Algorithms",
                    style = MaterialTheme.typography.body2
                )
                Text(
                    text = "100.00",
                    style = MaterialTheme.typography.body2,
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colors.primary,
                )
            }
        }
    }
}

@Composable
fun CustomDivider() {
    Divider(color = Amber400, thickness = 1.5.dp)
}

@Preview(showBackground = true, backgroundColor = 0xFFFAFAFA)
@Composable
fun HomeScreenPreview() {
    OneStiAppTheme {
        HomeScreen()
    }
}

