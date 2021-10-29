package com.example.onestiapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.onestiapp.model.MainViewModel
import com.example.onestiapp.ui.*
import com.example.onestiapp.ui.components.OneStiNavDrawer
import com.example.onestiapp.ui.components.OneStiTopBar
import com.example.onestiapp.ui.theme.OneStiAppTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import kotlinx.coroutines.launch

@ExperimentalAnimationApi
@ExperimentalMaterialApi
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
@ExperimentalAnimationApi
@ExperimentalMaterialApi
@ExperimentalPagerApi
@Composable
fun OneStiApp() {
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    val viewModel: MainViewModel = viewModel()
    val currentScreen by viewModel.currentScreen.observeAsState(Screens.Home)

    Scaffold(
        topBar = {
            OneStiTopBar(
                currentScreen = currentScreen,
                navController = navController,
                onClick = {
                    // Opens NavDrawer
                    coroutineScope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            )

        },
        scaffoldState = scaffoldState,
        drawerContent = {
            OneStiNavDrawer(
                onDestinationClicked = { route ->
                    // Close NavDrawer
                    coroutineScope.launch {
                        scaffoldState.drawerState.close()
                    }
                    // Navigates on the selected route in the NavDrawer
                    navController.navigate(route) {
                        popUpTo(route = Screens.Home.route)
                        launchSingleTop = true
                    }
                },
            )
        },
        drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
    ) { innerPadding ->
        OneStiNavHost(
            modifier = Modifier.padding(innerPadding),
            navController = navController,
            viewModel = viewModel
        )
    }
}

@ExperimentalAnimationApi
@ExperimentalMaterialApi
@ExperimentalPagerApi
@Composable
fun OneStiNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: MainViewModel
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screens.Home.route
    ) {
        composable(route = Screens.Home.route) {
            HomeScreen(viewModel = viewModel, navController = navController)
        }
        composable(route = Screens.Grades.route) {
            GradesScreen(viewModel = viewModel)
        }
        composable(route = Screens.ClassSchedule.route) {
            ClassScheduleScreen(viewModel = viewModel)
        }
        composable(route = Screens.ProgramCurriculum.route) {
            ProgramCurriculumScreen(viewModel = viewModel)
        }
        composable(route = Screens.StudentBalance.route) {
            StudentBalanceScreen(viewModel = viewModel)
        }
    }
}