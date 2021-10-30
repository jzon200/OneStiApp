package com.example.onestiapp.ui.components

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.example.onestiapp.R
import com.example.onestiapp.Screens
import com.example.onestiapp.ui.theme.Roboto

@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun OneStiTopBar(
    currentScreen: Screens,
    navController: NavController,
    onClick: () -> Unit,
) {
    Column {
        TopAppBar(
            title = {
                Text(text = currentScreen.title)
            },
            navigationIcon = {
                IconButton(onClick = { onClick() }) {
                    Icon(
                        imageVector = Icons.Filled.Menu,
                        contentDescription = "Nav drawer"
                    )
                }
            },
            actions = {
                ActionsIconItem(currentScreen = currentScreen)
            },
        )
        // Displays only in Information Tab Screens
        if (currentScreen == Screens.Grades || currentScreen == Screens.ClassSchedule || currentScreen == Screens.ProgramCurriculum || currentScreen == Screens.StudentBalance) {
            OneStiTabRow(navController = navController)
        }
    }
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
        var openDialog by remember { mutableStateOf(false) }
        IconButton(onClick = { openDialog = true }) {
            Icon(
                imageVector = Icons.Filled.Info,
                contentDescription = "Info",
                tint = Color.White
            )
        }

        if (openDialog) {
            InfoAlertDialog(
                title = currentScreen.title,
                text = stringResource(
                    id = when (currentScreen) {
                        Screens.Grades -> R.string.grades_info
                        Screens.ClassSchedule -> R.string.class_schedule_info
                        Screens.ProgramCurriculum -> R.string.program_curriculum_info
                        Screens.StudentBalance -> R.string.student_balance_info
                        else -> R.string.grades_info
                    }
                ),
                onDismiss = {
                    openDialog = false
                },
            )
        }
    }
}

@Composable
fun InfoAlertDialog(title: String, text: String, onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.h6.copy(fontFamily = Roboto)
            )
        },
        text = {
            Text(
                text = text,
                style = MaterialTheme.typography.body2.copy(color = Color.Black)
            )
        },
        confirmButton = {
            // No Confirm Button
        },
        dismissButton = {
            TextButton(onClick = { onDismiss() }) {
                Text(
                    text = "OK",
                    style = MaterialTheme.typography.body2.copy(fontWeight = FontWeight.Medium)
                )
            }
        }
    )
}