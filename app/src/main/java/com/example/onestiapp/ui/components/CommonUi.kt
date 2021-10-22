package com.example.onestiapp.ui.components

import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.onestiapp.ui.theme.Amber400

@Composable
fun OneStiDivider(modifier: Modifier = Modifier) {
    Divider(modifier = modifier, color = Amber400, thickness = 1.5.dp)
}