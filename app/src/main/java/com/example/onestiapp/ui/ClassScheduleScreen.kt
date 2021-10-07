package com.example.onestiapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onestiapp.data.ClassSchedule
import com.example.onestiapp.data.Grade
import com.example.onestiapp.data.getClassSchedule
import com.example.onestiapp.data.getDay
import com.example.onestiapp.ui.components.OneStiSelectionButton
import com.example.onestiapp.ui.theme.OneStiAppTheme
import com.example.onestiapp.ui.theme.Roboto
import com.example.onestiapp.ui.theme.courseSubjectColor

@Composable
fun ClassScheduleScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OneStiSelectionButton(
            text = "Today | ${getDay()}",
            alertDialogTitle = "Class Days",
            items = listOf(
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday",
                "Entire Week",
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        // If there's no class schedule, do this
        if (getClassSchedule().isEmpty()) {
            Text(
                text = "Your schedule is free today.",
                style = MaterialTheme.typography.caption
            )
        } else {
            // Iterates the @Composable ClassScheduleItem
            // depending on the list of schedules in the current day
            ClassScheduleListColumn(getClassSchedule())
        }
    }
}

@Composable
fun ClassScheduleListColumn(schedules: List<ClassSchedule>) {
    LazyColumn(contentPadding = PaddingValues(16.dp)) {
        items(schedules) { classSchedule ->
            ClassScheduleItem(
                schedule = classSchedule,
                color = courseSubjectColor[schedules.indexOf(classSchedule)]
            )
            Spacer(modifier = Modifier.height(18.dp))
        }
    }
}

@Composable
private fun ClassScheduleItem(
    schedule: ClassSchedule,
    color: Color
) {
    Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Column(
            Modifier.wrapContentWidth(), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = schedule.classStart,
                style = MaterialTheme.typography.subtitle1.copy(
                    fontFamily = Roboto,
                    fontSize = 17.sp
                ),
            )
            Text(
                text = "to ${schedule.classEnd}",
                style = MaterialTheme.typography.body2,
            )
        }
        Box(
            contentAlignment = Alignment.CenterStart,
            modifier = Modifier
                .clip(RoundedCornerShape(6.dp))
                .background(color)
                .width(210.dp)
                .wrapContentHeight()
        ) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = schedule.courseSubject,
                    style = MaterialTheme.typography.body2.copy(
                        color = MaterialTheme.colors.onPrimary,
                        fontWeight = FontWeight.Medium
                    )
                )
                Spacer(Modifier.height(2.dp))
                Text(
                    text = "${schedule.classRoom} | ${schedule.classProfessor.uppercase()}",
                    style = MaterialTheme.typography.overline.copy(
                        color = MaterialTheme.colors.onPrimary,
                        fontWeight = FontWeight.Medium
                    )
                )
            }
        }
    }

}

@Preview(showBackground = true, backgroundColor = 0xFFEDF1F4)
@Composable
fun ClassScheduleScreenPreview() {
    OneStiAppTheme {
        ClassScheduleScreen()
    }
}