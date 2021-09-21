package com.example.onestiapp

import android.accounts.Account
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.onestiapp.ui.*
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
    Surface {
        val drawerState = rememberDrawerState(DrawerValue.Closed)
        val scope = rememberCoroutineScope()
        val openDrawer = {
            scope.launch {
                drawerState.open()
            }
        }
        // Navigation Drawer
        ModalDrawer(
            drawerState = drawerState,
            gesturesEnabled = drawerState.isOpen,
            drawerContent = {
                NavDrawer(
                    onDestinationClicked = { route ->
                        scope.launch {
                            drawerState.close()
                        }
                        navController.navigate(route) {
                            popUpTo = navController.graph.startDestinationId
                            launchSingleTop = true
                        }
                    }
                )
            }
        ) {
            // NavHost composable
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
    }
}