package com.example.onestiapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.onestiapp.ui.*
import com.example.onestiapp.ui.components.CustomTopBar
import com.example.onestiapp.ui.components.NavDrawer
import com.example.onestiapp.ui.theme.OneStiAppTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OneStiAppTheme {
                OneStiApp()
            }
        }
    }
}

@Composable
fun OneStiApp() {
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val backstackEntry = navController.currentBackStackEntryAsState()
    val currentScreen = DrawerScreens.fromRoute(backstackEntry.value?.destination?.route)
    val openDrawer = {
        scope.launch {
            scaffoldState.drawerState.open()
        }
    }
    Scaffold(
        topBar = {
            CustomTopBar(
                currentScreen = currentScreen,
                title = if (currentScreen == DrawerScreens.Grades || currentScreen == DrawerScreens.ClassSchedule) "My ${
                    getTitle(currentScreen)
                }" else getTitle(currentScreen)
            ) {
                openDrawer()
            }
        },
        scaffoldState = scaffoldState,
        drawerContent = {
            NavDrawer(
                onDestinationClicked = { route ->
                    scope.launch {
                        scaffoldState.drawerState.close()
                    }
                    navController.navigate(route) {
                        popUpTo = navController.graph.startDestinationId
                        launchSingleTop = true
                    }
                },
            )
        },
        drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
    ) {
        OneStiNavHost(navController = navController) {
            openDrawer()
        }
    }
}

@Composable
fun OneStiNavHost(navController: NavHostController, openDrawer: () -> Unit) {
    NavHost(
        navController = navController,
        startDestination = DrawerScreens.Home.name
    ) {
        composable(route = DrawerScreens.Home.name) {
            HomeScreen(
                openDrawer = {
                    openDrawer()
                }
            )
        }
        composable(route = DrawerScreens.Grades.name) {
            MyGradesScreen(
                openDrawer = {
                    openDrawer()
                }
            )
        }
        composable(route = DrawerScreens.ClassSchedule.name) {
            ClassScheduleScreen(
                openDrawer = {
                    openDrawer()
                }
            )
        }
        composable(route = DrawerScreens.ProgramCurriculum.name) {
            ProgramCurriculumScreen(
                openDrawer = {
                    openDrawer()
                }
            )
        }
        composable(route = DrawerScreens.StudentBalance.name) {
            StudentBalanceScreen(
                openDrawer = {
                    openDrawer()
                }
            )
        }
    }
}