package com.example.onestiapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults.Indicator
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.onestiapp.Screens
import com.example.onestiapp.informationScreens
import com.example.onestiapp.ui.ClassScheduleScreen
import com.example.onestiapp.ui.MyGradesScreen
import com.example.onestiapp.ui.ProgramCurriculumScreen
import com.example.onestiapp.ui.StudentBalanceScreen
import com.example.onestiapp.ui.theme.DividerColor
import com.example.onestiapp.ui.theme.OneStiAppTheme
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch


@Composable
fun OneStiTabRow(
    currentScreen: Screens,
    modifier: Modifier = Modifier
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
                    color = DividerColor
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
                    selected = state == index,
                    unselectedContentColor = Color.White,
                    onClick = { state = index }
                )
            }
        }
    }
}

/**
 * This composable [ExperimentalPagerApi] may vary in the future.
 */
@ExperimentalPagerApi
@Composable
fun OneStiTabLayout() {
    val pagerState = rememberPagerState(informationScreens.size)
    val scope = rememberCoroutineScope()
//    val currentPageIndex = when (screen) {
//        DrawerScreens.Grades -> 0
//        DrawerScreens.ClassSchedule -> 1
//        DrawerScreens.ProgramCurriculum -> 2
//        DrawerScreens.StudentBalance -> 3
//        else -> pagerState.currentPage
//    }

    Column {
        TabRow(
            selectedTabIndex = pagerState.currentPage,
            indicator = { tabPosition ->
                // Changed the default color of the Indicator in TabRow
                // and syncs with the scrolls of HorizontalPager
                Indicator(
                    Modifier.pagerTabIndicatorOffset(pagerState, tabPosition),
                    color = DividerColor
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
                        scope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    }
                )
            }
        }
        OneStiHorizontalPager(pagerState = pagerState)
    }
}


@ExperimentalPagerApi
@Composable
private fun OneStiHorizontalPager(pagerState: PagerState) {
    HorizontalPager(state = pagerState) { page ->
        when (page) {
            0 -> MyGradesScreen()
            1 -> ClassScheduleScreen()
            2 -> ProgramCurriculumScreen()
            3 -> StudentBalanceScreen()
        }
    }
}

@ExperimentalPagerApi
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TabRowPreview() {
    OneStiAppTheme {
        OneStiTabRow(Screens.ProgramCurriculum)
    }
}
