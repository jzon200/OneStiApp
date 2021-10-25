package com.example.onestiapp.ui.components

import android.content.ContentValues
import android.util.Log
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults.Indicator
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.onestiapp.ClassScheduleScreenSample
import com.example.onestiapp.Screens
import com.example.onestiapp.StudentBalanceScreenSample
import com.example.onestiapp.informationScreens
import com.example.onestiapp.model.OneStiViewModel
import com.example.onestiapp.ui.*
import com.example.onestiapp.ui.theme.Amber400
import com.example.onestiapp.ui.theme.OneStiAppTheme
import com.google.accompanist.pager.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
fun OneStiTabRow(
    currentScreen: Screens,
    navController: NavController
) {
    val selectedTabIndex = when (currentScreen) {
        Screens.Grades -> 0
        Screens.ClassSchedule -> 1
        Screens.ProgramCurriculum -> 2
        Screens.StudentBalance -> 3
        else -> 0
    }
    var state by remember { mutableStateOf(selectedTabIndex) }
    Column {
        TabRow(
            selectedTabIndex = state,
            indicator = { tabPosition ->
                // Changed the default color of the Indicator in TabRow
                Indicator(
                    Modifier.tabIndicatorOffset(tabPosition[state]),
                    color = Amber400
                )
            }
        ) {
            informationScreens.forEachIndexed { index, tab ->
                Tab(
                    icon = {
                        Icon(
                            imageVector = tab.icon,
                            contentDescription = tab.icon.name
                        )
                    },
                    enabled = state != index,
                    selected = state == index,
                    unselectedContentColor = Color.White,
                    onClick = {
                        state = index
                        navController.navigate(tab.route) {
                            launchSingleTop = true
                        }
                        Log.d(ContentValues.TAG, "OneStiAppTabRow: $currentScreen")
                    }
                )
            }
        }
    }
}

/**
 * This composable [ExperimentalPagerApi] may vary in the future.
 * I would not use it for now :((
 */
@ExperimentalMaterialApi
@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun OneStiTabLayout(
    currentScreen: Screens,
    navController: NavController,
//    onClick: (index: Int) -> Unit
) {
    val pagerState = rememberPagerState(informationScreens.size)
    val scope = rememberCoroutineScope()
    val viewModel: OneStiViewModel = viewModel()
    val selectedTabIndex = when (currentScreen) {
        Screens.Grades -> 0
        Screens.ClassSchedule -> 1
        Screens.ProgramCurriculum -> 2
        Screens.StudentBalance -> 3
        else -> 0
    }
    var state by remember { mutableStateOf(selectedTabIndex) }
    Column {
        TabRow(
            selectedTabIndex = pagerState.currentPage,
            indicator = { tabPosition ->
                // Changed the default color of the Indicator in TabRow
                // and syncs with the scrolls of HorizontalPager
                Indicator(
                    Modifier.pagerTabIndicatorOffset(pagerState, tabPosition),
                    color = Amber400
                )
            }
        ) {
            informationScreens.forEachIndexed { index, tab ->
                Tab(
                    icon = {
                        Icon(
                            imageVector = tab.icon,
                            contentDescription = "Tab Icon"
                        )
                    },
                    selected = pagerState.currentPage == index,
                    unselectedContentColor = Color.White,
                    onClick = {
                        state = index
                        navController.navigate(tab.route) {
                            launchSingleTop = true
                        }
                        scope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    }
                )
            }
        }
        HorizontalPager(state = pagerState) { page ->
            when (page) {
                0 -> GradesScreen()
                1 -> ClassScheduleScreenSample(oneStiViewModel = viewModel)
                2 -> ProgramCurriculumScreen()
                3 -> StudentBalanceScreenSample(oneStiViewModel = viewModel)
            }
        }
//        scope.launch {
//            pagerState.animateScrollToPage(state)
//        }
    }
}

@ExperimentalPagerApi
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TabRowPreview() {
    OneStiAppTheme {
        OneStiTabRow(Screens.ProgramCurriculum, rememberNavController())
    }
}
