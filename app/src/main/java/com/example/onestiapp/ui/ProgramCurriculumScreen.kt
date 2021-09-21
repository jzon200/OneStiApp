package com.example.onestiapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.onestiapp.DrawerScreens
import com.example.onestiapp.InformationTopBar
import com.example.onestiapp.getTitle

@Composable
fun ProgramCurriculumScreen(openDrawer: () -> Unit) {
    Scaffold(
        topBar = {
            InformationTopBar(title = getTitle(DrawerScreens.ProgramCurriculum), onButtonClicked = { openDrawer() })
        },
    ) {
        Surface(modifier = Modifier.fillMaxSize()) {
//            val scrollState = rememberScrollState()
//            Column(
//                Modifier
//                    .fillMaxSize()
//                    .verticalScroll(scrollState)
//                    .padding(10.dp)
//            ) {
//                LatestNewsCard()
//                Spacer(Modifier.size(12.dp))
//                ClassScheduleCard()
//                Spacer(Modifier.size(12.dp))
//                PaymentScheduleCard()
//                Spacer(Modifier.size(12.dp))
//                LatestGradeCard()
//            }
        }
    }
}