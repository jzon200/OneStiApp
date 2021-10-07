package com.example.onestiapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onestiapp.ui.theme.Roboto

/**
 * Set to Reusable Composable
 * Used in Information Tabs [GradesScreen], [ClassScheduleScreen], [StudentBalanceScreen]
 */
@Composable
fun OneStiSelectionButton(
    text: String,
    alertDialogTitle: String,
    items: List<String>
) {
    // Alert Dialog state set to false
    var openDialog by remember { mutableStateOf(false) }
    Card(
        elevation = 1.5.dp,
        shape = RoundedCornerShape(12.dp),
        contentColor = MaterialTheme.colors.primary,
        modifier = Modifier
            .fillMaxWidth()
            .size(38.dp)
            .clickable(
                // Disable the click indication
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) {
                // Open the Alert Dialog
                openDialog = true
            }
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                imageVector = Icons.Default.CalendarToday,
                contentDescription = Icons.Default.CalendarToday.name,
                modifier = Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = text,
                style = MaterialTheme.typography.subtitle2
            )
            Spacer(modifier = Modifier.width(4.dp))
            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = Icons.Default.ArrowDropDown.name,
                modifier = Modifier.size(32.dp)
            )
        }
    }

    // Alert Dialog Condition
    if (openDialog) {
        OneStiSelectionDialog(
            onDismiss = { openDialog = false },
            title = alertDialogTitle,
            items = items
        )
    }
}

@Composable
fun OneStiSelectionDialog(
    onDismiss: () -> Unit,
    title: String = "School Year/ Term",
    items: List<String>
) {
    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.h6.copy(fontFamily = Roboto)
            )
        },
        text = {
            Column {
                items.forEach {
                    OneStiSelectionRowItem(title = it) {

                    }
                }
            }
        },
        confirmButton = {
            // No Confirm Button
        },
        dismissButton = {
            TextButton(onClick = { onDismiss() }) {
                Text(
                    "CANCEL",
                    style = MaterialTheme.typography.body2.copy(fontWeight = FontWeight.Medium)
                )
            }
        }
    )
}

@Composable
fun OneStiSelectionRowItem(
    modifier: Modifier = Modifier,
    title: String,
    onItemClicked: () -> Unit,
) {
    Row(
        modifier
            .fillMaxWidth()
            .size(42.dp)
            .clickable { onItemClicked() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.body1.copy(color = MaterialTheme.colors.onBackground)
        )
    }
}