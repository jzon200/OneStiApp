package com.example.onestiapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.onestiapp.ui.*
import com.example.onestiapp.ui.components.NavDrawer
import com.example.onestiapp.ui.components.OneStiTopBar
import com.example.onestiapp.ui.theme.OneStiAppTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import kotlinx.coroutines.launch

@ExperimentalPagerApi
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

@ExperimentalPagerApi
@Composable
fun OneStiApp() {
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val backstackEntry = navController.currentBackStackEntryAsState()
    val currentScreen = Screens.fromRoute(backstackEntry.value?.destination?.route)

    Scaffold(
        topBar = {
            OneStiTopBar(
                currentScreen = currentScreen,
                onButtonClicked = {
                    // Opens NavDrawer
                    scope.launch {
                        scaffoldState.drawerState.open()
//                        pagerState.animateScrollToPage(informationTabs.indexOf(currentScreen))
                    }
                }
            )
        },
        scaffoldState = scaffoldState,
        drawerContent = {
            NavDrawer(
                onDestinationClicked = { route ->
                    // Close NavDrawer
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
    ) { innerPadding ->
        OneStiNavHost(modifier = Modifier.padding(innerPadding), navController = navController)
    }
}

@ExperimentalPagerApi
@Composable
fun OneStiNavHost(modifier: Modifier = Modifier, navController: NavHostController) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screens.Home.route
    ) {
        composable(route = Screens.Home.route) {
            HomeScreen()
        }
        composable(route = Screens.Grades.route) {
            MyGradesScreen()
        }
        composable(route = Screens.ClassSchedule.route) {
            ClassScheduleScreen()
        }
        composable(route = Screens.ProgramCurriculum.route) {
            ProgramCurriculumScreen()
        }
        composable(route = Screens.StudentBalance.route) {
            StudentBalanceScreen()
        }
    }
}