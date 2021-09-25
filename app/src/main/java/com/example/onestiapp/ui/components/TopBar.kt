package com.example.onestiapp.ui.components

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import com.example.onestiapp.R
import com.example.onestiapp.Screens

@Composable
fun OneStiTopBar(
    currentScreen: Screens = Screens.Home,
    drawerIcon: ImageVector = Icons.Filled.Menu,
    onButtonClicked: () -> Unit,
) {
    TopAppBar(
        title = {
            Text(
                text = currentScreen.title,
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
            ActionsIconItem(currentScreen = currentScreen)
        },
    )
}

/**
 * Changes the Action Icon buttons
 * in Home Screen (2),
 * in Information Screens (Grades, ClassSchedule, etc.) = 1
 */
@Composable
private fun ActionsIconItem(currentScreen: Screens) {
    if (currentScreen == Screens.Home) {
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
    } else {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Filled.Info,
                contentDescription = "Info",
                tint = Color.White
            )
        }
    }
}