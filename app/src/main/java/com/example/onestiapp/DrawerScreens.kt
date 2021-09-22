package com.example.onestiapp

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

enum class DrawerScreens(title: String, val icon: ImageVector) {
    Home(title = "Home", icon = Icons.Filled.Home),
    Grades(title = "Grades", icon = Icons.Filled.Grade),
    ClassSchedule(title = "Class Schedule", icon = Icons.Filled.Schedule),
    ProgramCurriculum(title = "Program Curriculum", icon = Icons.Filled.School),
    StudentBalance(title = "Student Balance", icon = Icons.Filled.AttachMoney)
}



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

