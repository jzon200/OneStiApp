package com.example.onestiapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.onestiapp.ui.CustomDivider
import com.example.onestiapp.ui.theme.DrawerIconColor
import com.example.onestiapp.ui.theme.OneStiAppTheme
import com.example.onestiapp.ui.theme.PrimaryColor

enum class DrawerScreens(val icon: ImageVector) {
    Home(icon = Icons.Filled.Home),
    Grades(icon = Icons.Filled.Grade),
    ClassSchedule(icon = Icons.Filled.Schedule),
    ProgramCurriculum(icon = Icons.Filled.School),
    StudentBalance(icon = Icons.Filled.AttachMoney)
}

// Convert the enum class as a list
private val drawerScreens = DrawerScreens.values().toList()

fun getTitle(screen: DrawerScreens): String {
    val title = when (screen.name) {
        DrawerScreens.Home.name -> "Home"
        DrawerScreens.Grades.name -> "Grades"
        DrawerScreens.ClassSchedule.name -> "Class Schedule"
        DrawerScreens.ProgramCurriculum.name -> "Program Curriculum"
        DrawerScreens.StudentBalance.name -> "Student Balance"
        else -> "No Title"
    }
    return title
}

@Composable
fun InformationTopBar(
    title: String,
    drawerIcon: ImageVector = Icons.Filled.Menu,
    onButtonClicked: () -> Unit,
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.subtitle1,
                color = Color.White
            )
        },
        navigationIcon = {
            IconButton(onClick = { onButtonClicked() }) {
                Icon(
                    imageVector = drawerIcon,
                    contentDescription = "Nav drawer"
                )
            }
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Info,
                    contentDescription = "Info",
                    tint = Color.White
                )
            }
        },
    )
}

@Composable
fun DrawerProfile() {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.size(16.dp))
        Image(
            painter = painterResource(id = R.drawable.profile_pic),
            contentDescription = "Profile Pic",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .clip(CircleShape)
                .size(64.dp)
        )
        // Hard-coded yet
        Text(
            text = "MY PROFILE",
            style = MaterialTheme.typography.overline,
            color = PrimaryColor,
            modifier = Modifier.padding(
                top = 8.dp,
                bottom = 4.dp
            )
        )
        Text(
            text = "EDZON JAEVE BUBAN BAUSA",
            style = MaterialTheme.typography.subtitle2,
        )
        Text(
            text = "02000168406",
            style = MaterialTheme.typography.caption,
        )
        Spacer(modifier = Modifier.size(4.dp))
        Text(
            text = "BSIT • STI COLLEGE SAN JOSE DEL MONTE",
            style = MaterialTheme.typography.caption,
            modifier = Modifier.padding(bottom = 12.dp)
        )
        CustomDivider()
    }
}

@Composable
fun NavDrawer(
    modifier: Modifier = Modifier,
    onDestinationClicked: (route: String) -> Unit,
) {
    Column(
        modifier
            .fillMaxSize()
    ) {
        DrawerProfile()

        Row(
            Modifier
                .fillMaxWidth()
                .size(48.dp)
                .clickable { onDestinationClicked(DrawerScreens.Home.name) },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = modifier.size(12.dp))
            Icon(
                imageVector = DrawerScreens.Home.icon,
                contentDescription = "Home",
                tint = DrawerIconColor,
                modifier = Modifier.size(18.dp)
            )
            Spacer(Modifier.size(16.dp))
            Text(
                text = DrawerScreens.Home.name,
                style = MaterialTheme.typography.subtitle2
            )
        }
        Divider()
        // Information Section
        Text(
            text = "Information",
            style = MaterialTheme.typography.subtitle2,
            color = PrimaryColor,
            modifier = Modifier.padding(12.dp)
        )
        // Drops the first n element [Home Drawer Content]
        // To only display Information Drawer Contents
        val informationDrawerScreens = drawerScreens.drop(1)
        informationDrawerScreens.forEach { screen ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .size(48.dp)
                    .clickable { onDestinationClicked(screen.name) },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = modifier.size(12.dp))
                Icon(
                    imageVector = screen.icon,
                    contentDescription = null,
                    tint = DrawerIconColor,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = modifier.size(16.dp))
                Text(
                    text = if (screen == DrawerScreens.Grades || screen == DrawerScreens.ClassSchedule) "View ${
                        getTitle(
                            screen
                        )
                    }" else getTitle(screen),
                    style = MaterialTheme.typography.subtitle2,
                )
            }
        }
    }
}

@Preview
@Composable
fun DrawerProfilePreview() {
    OneStiAppTheme {
        Surface {
            DrawerProfile()
        }
    }
}