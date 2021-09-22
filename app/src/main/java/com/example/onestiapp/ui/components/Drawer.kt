package com.example.onestiapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.onestiapp.DrawerScreens
import com.example.onestiapp.R
import com.example.onestiapp.getTitle
import com.example.onestiapp.ui.CustomDivider
import com.example.onestiapp.ui.theme.DrawerContentIconColor
import com.example.onestiapp.ui.theme.DrawerHighlightRowColor
import com.example.onestiapp.ui.theme.OneStiAppTheme
import com.example.onestiapp.ui.theme.PrimaryColor

//// Convert the enum class as a list
//private val drawerScreens = DrawerScreens.values().toList()

@Composable
fun DrawerProfile() {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.size(16.dp))
        Image(
            painter = painterResource(id = R.drawable.profile_pic),
            contentDescription = "Profile Pic",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .clip(CircleShape)
                .size(64.dp)
        )
        // Hard-coded yet
        Text(
            text = "MY PROFILE",
            style = MaterialTheme.typography.overline,
            color = PrimaryColor,
            modifier = Modifier.padding(
                top = 8.dp,
                bottom = 4.dp
            )
        )
        Text(
            text = "EDZON JAEVE BUBAN BAUSA",
            style = MaterialTheme.typography.subtitle2,
        )
        Text(
            text = "02000168406",
            style = MaterialTheme.typography.caption,
        )
        Spacer(modifier = Modifier.size(4.dp))
        Text(
            text = "BSIT • STI COLLEGE SAN JOSE DEL MONTE",
            style = MaterialTheme.typography.caption,
            modifier = Modifier.padding(bottom = 12.dp)
        )
        CustomDivider()
    }
}

@Composable
fun NavDrawer(
    modifier: Modifier = Modifier,
    rowItems: List<DrawerScreens> = DrawerScreens.values().toList(),
    activeHighlightColor: Color = DrawerHighlightRowColor,
    initialItemSelectedIndex: Int = 0,
    onDestinationClicked: (route: String) -> Unit,
) {
    var selectedItemIndex by remember {
        mutableStateOf(initialItemSelectedIndex)
    }
    Column(modifier.fillMaxSize()) {
        DrawerProfile()
        NavDrawerRowItem(
            item = rowItems.first(),
            isSelected = rowItems.indexOf(rowItems.first()) == selectedItemIndex,
            activeHighlightColor = activeHighlightColor,
            onItemClicked = {
                onDestinationClicked(rowItems.first().name)
                selectedItemIndex = rowItems.indexOf(rowItems.first())
            }
        )
        Divider()
        // Information Section
        Text(
            text = "Information",
            style = MaterialTheme.typography.subtitle2,
            color = PrimaryColor,
            modifier = Modifier.padding(12.dp)
        )
        // return Information Drawer Row Items excluding the Home
        rowItems.forEachIndexed { index, drawerScreens ->
            if (drawerScreens != DrawerScreens.Home){
                NavDrawerRowItem(
                    item = drawerScreens,
                    isSelected = index == selectedItemIndex,
                    activeHighlightColor = activeHighlightColor,
                    onItemClicked = {
                        onDestinationClicked(drawerScreens.name)
                        selectedItemIndex = index
                    }
                )
            }
        }
        Divider()
    }
}

@Composable
private fun NavDrawerRowItem(
    modifier: Modifier = Modifier,
    item: DrawerScreens,
    isSelected: Boolean = false,
    activeHighlightColor: Color = DrawerHighlightRowColor,
    onItemClicked: (route: String) -> Unit,
) {
    Row(
        modifier
            .fillMaxWidth()
            .size(48.dp)
            .background(if (isSelected) activeHighlightColor else Color.Transparent)
            .clickable { onItemClicked(item.name) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = modifier.size(12.dp))
        Icon(
            imageVector = item.icon,
            contentDescription = null,
            tint = DrawerContentIconColor,
            modifier = Modifier.size(18.dp)
        )
        Spacer(modifier = modifier.size(16.dp))
        Text(
            text = if (item == DrawerScreens.Grades || item == DrawerScreens.ClassSchedule) "View ${
                getTitle(
                    item
                )
            }" else getTitle(item),
            style = MaterialTheme.typography.subtitle2,
        )
    }
}

@Preview
@Composable
fun DrawerProfilePreview() {
    OneStiAppTheme {
        Surface {
            DrawerProfile()
        }
    }
}

@Preview
@Composable
fun DrawerPreview() {
    OneStiAppTheme {
        Surface {
            NavDrawer() { "" }
        }
    }
}