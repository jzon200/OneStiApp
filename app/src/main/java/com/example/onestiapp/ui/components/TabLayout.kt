package com.example.onestiapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults.Indicator
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.onestiapp.Screens
import com.example.onestiapp.informationScreens
import com.example.onestiapp.model.MainViewModel
import com.example.onestiapp.ui.theme.Amber400
import com.example.onestiapp.ui.theme.OneStiAppTheme


/**
 * Information Tabs (Grades, Class Schedule, Program Curriculum, Student Balance).
 */
@Composable
fun OneStiTabRow(
    navController: NavController
) {
    val viewModel: MainViewModel = viewModel()
    val currentScreenIndex by viewModel.currentTabSelectedIndex.observeAsState(0)
    Column {
        TabRow(
            selectedTabIndex = currentScreenIndex,
            indicator = { tabPosition ->
                // Changed the default color of the Indicator in TabRow
                Indicator(
                    Modifier.tabIndicatorOffset(tabPosition[currentScreenIndex]),
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
                    enabled = currentScreenIndex != index,
                    selected = currentScreenIndex == index,
                    unselectedContentColor = Color.White,
                    onClick = {
                        navController.navigate(tab.route) {
                            popUpTo(route = Screens.Home.route)
                            launchSingleTop = true
                        }
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TabRowPreview() {
    OneStiAppTheme {
        OneStiTabRow(rememberNavController())
    }
}
