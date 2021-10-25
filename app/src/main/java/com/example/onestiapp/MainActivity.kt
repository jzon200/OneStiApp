package com.example.onestiapp

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
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
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.onestiapp.data.ClassSchedule
import com.example.onestiapp.data.StudentBalance
import com.example.onestiapp.model.OneStiViewModel
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
//    private val viewModel by viewModels<OneStiViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OneStiAppTheme {
                OneStiApp()
//                StudentBalanceScreenSample(viewModel)
//                ClassScheduleScreenSample(viewModel)
            }
        }
    }
}

@Composable
fun ClassScheduleScreenSample(oneStiViewModel: OneStiViewModel) {
//    val items: List<PaymentSchedule> by viewModel.paymentScheduleItems.observeAsState(listOf())
    val termList = listOf(
        "2021-2022 First Term",
        "2020-2021 Second Term",
        "2020-2021 First Term",
        "2019-2020 Second Term",
        "2019-2020 First Term",
    )
    val text by oneStiViewModel.classScheduleText.observeAsState("")
    val items: List<ClassSchedule> by oneStiViewModel.classScheduleItems.observeAsState(listOf())
    ClassScheduleScreen(
        text = text,
        items = listOf(
            "Monday",
            "Tuesday",
            "Wednesday",
            "Thursday",
            "Friday",
            "Saturday",
            "Sunday",
            "Entire Week",
        ),
        schedules = items,
        onItemClicked = {
            oneStiViewModel.apply {
                onTextChanged2(it)
                getClassSchedule(it)
            }
        }
    )
}

@Composable
fun StudentBalanceScreenSample(oneStiViewModel: OneStiViewModel) {
//    val items: List<PaymentSchedule> by viewModel.paymentScheduleItems.observeAsState(listOf())
    val termList = listOf(
        "2021-2022 First Term",
        "2020-2021 Second Term",
        "2020-2021 First Term",
        "2019-2020 Second Term",
        "2019-2020 First Term",
    )
    val text by oneStiViewModel.yearText.observeAsState(termList.first())
    val studentBalance by oneStiViewModel.studentBalance.observeAsState(StudentBalance.ThirdYearFirstTerm)
    StudentBalanceScreen(
        text = text,
        studentBalance = studentBalance,
        items = listOf(
            "2021-2022 First Term",
            "2020-2021 Second Term",
            "2020-2021 First Term",
            "2019-2020 Second Term",
            "2019-2020 First Term",
        ),
        onItemClicked = {
            oneStiViewModel.apply {
                onYearTextChanged(it)
                when(it){
                    termList[0] -> onStudentBalanceChanged(StudentBalance.ThirdYearFirstTerm)
                    termList[1] -> onStudentBalanceChanged(StudentBalance.SecondYearSecondTerm)
                    else -> onStudentBalanceChanged(StudentBalance.SecondYearSecondTerm)
                }
            }
        }
    )
}

@ExperimentalAnimationApi
@ExperimentalMaterialApi
@ExperimentalPagerApi
@Composable
fun OneStiApp() {
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val backstackEntry = navController.currentBackStackEntryAsState()
    val currentScreen = Screens.fromRoute(backstackEntry.value?.destination?.route)
    val viewModel: OneStiViewModel = viewModel()
    Scaffold(
        topBar = {
            OneStiTopBar(
                currentScreen = currentScreen,
                navController = navController,
                onButtonClicked = {
                    // Opens NavDrawer
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                    Log.d(TAG, "OneStiAppTopBar: $currentScreen")
                }
            )

        },
        scaffoldState = scaffoldState,
        drawerContent = {
            OneStiNavDrawer(
                onDestinationClicked = { route ->
                    // Close NavDrawer
                    scope.launch {
                        scaffoldState.drawerState.close()
                    }
                    navController.navigate(route) {
                        popUpTo = navController.graph.startDestinationId
                        launchSingleTop = true
                        Log.d(TAG, "OneStiAppDrawer: $currentScreen")
                    }
                },
            )
        },
        drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
    ) { innerPadding ->
        OneStiNavHost(modifier = Modifier.padding(innerPadding), navController = navController, viewModel = viewModel)
    }
}

@ExperimentalAnimationApi
@ExperimentalMaterialApi
@ExperimentalPagerApi
@Composable
fun OneStiNavHost(modifier: Modifier = Modifier, navController: NavHostController, viewModel: OneStiViewModel) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screens.Home.route
    ) {
        composable(route = Screens.Home.route) {
            HomeScreen()
        }
        composable(route = Screens.Grades.route) {
            GradesScreen()
        }
        composable(route = Screens.ClassSchedule.route) {
            ClassScheduleScreenSample(viewModel)
        }
        composable(route = Screens.ProgramCurriculum.route) {
            ProgramCurriculumScreen()
        }
        composable(route = Screens.StudentBalance.route) {
            StudentBalanceScreenSample(viewModel)
        }
    }
}