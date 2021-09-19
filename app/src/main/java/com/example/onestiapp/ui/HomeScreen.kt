package com.example.onestiapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.onestiapp.R
import com.example.onestiapp.data.ClassSchedule
import com.example.onestiapp.data.getClassSchedule
import com.example.onestiapp.data.getDate
import com.example.onestiapp.data.getDay
import com.example.onestiapp.ui.theme.DividerColor
import com.example.onestiapp.ui.theme.OneStiAppTheme
import com.example.onestiapp.ui.theme.PrimaryColor
import com.example.onestiapp.ui.theme.courseSubjectColor

@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Home",
                        style = MaterialTheme.typography.subtitle1,
                        color = Color.White
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_menu_24),
                            contentDescription = "Nav drawer"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_manage_widgets),
                            contentDescription = "Manage widgets",
                            tint = Color.White
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_notifications_24),
                            contentDescription = "Notifications",
                            tint = Color.White
                        )
                    }
                },
            )
        },
    ) {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                LatestNewsCard()
                Spacer(Modifier.size(12.dp))
                ClassScheduleCard()
            }
        }
    }
}

@Composable
fun LatestNewsCard() {
    Card(elevation = 4.dp) {
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
                    color = PrimaryColor
                )
            }
            Column(Modifier.fillMaxWidth()) {
                Spacer(modifier = Modifier.size(4.dp))
                Divider(color = DividerColor, thickness = 2.dp)
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
                        style = MaterialTheme.typography.overline
                    )
                }
            }
        }
    }
}

@Composable
fun ClassScheduleCard() {
    Card(elevation = 4.dp) {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Classes for Today|${getDay()}", style = MaterialTheme.typography.subtitle1)
            Spacer(Modifier.size(4.dp))
            Text(text = "AS OF ${getDate()}", style = MaterialTheme.typography.overline)
            Spacer(modifier = Modifier.size(6.dp))
            Divider(color = DividerColor, thickness = 2.dp)
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
                .height(64.dp)
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
        Column {
            Text(
                text = schedule.courseSubject,
                style = MaterialTheme.typography.subtitle2
            )
            Spacer(Modifier.size(4.dp))
            Text(
                text = "${schedule.classRoom}|${schedule.classProfessor}",
                style = MaterialTheme.typography.caption
            )
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    OneStiAppTheme {
        HomeScreen()
    }
}