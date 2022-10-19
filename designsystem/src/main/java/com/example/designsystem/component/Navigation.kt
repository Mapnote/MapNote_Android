package com.example.designsystem.component

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.VerifiedUser
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.theme.Gray03
import com.example.designsystem.theme.MapNoteTheme
import com.example.designsystem.theme.Primary

@Composable
fun MapNoteNavigationBar(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit
) {
    NavigationBar(
        modifier = modifier,
        contentColor = Primary,
        tonalElevation = 0.dp,
        content = content
    )
}

@Composable
fun RowScope.MapNoteNavigationBarItem(
    selected: Boolean,
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    selectedIcon: @Composable () -> Unit = icon,
    enabled: Boolean = true,
    label: @Composable (() -> Unit)? = null,
) {
    NavigationBarItem(
        selected = selected,
        onClick = onClick,
        icon = if (selected) selectedIcon else icon,
        modifier = modifier,
        enabled = enabled,
        label = label,
        alwaysShowLabel = false,
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = Primary,
            unselectedIconColor = Gray03,
            indicatorColor = Color.White
        )
    )
}

@Preview(name = "Light Mode", showBackground = true)
@Composable
fun MapNoteNavigationBarPreview() {
    MapNoteTheme {
        MapNoteNavigationBar {
            MapNoteNavigationBarItem(selected = false,
                icon = { Icon(imageVector = Icons.Filled.CalendarMonth, contentDescription = "") },
                onClick = {}
            )
            MapNoteNavigationBarItem(selected = false,
                icon = { Icon(imageVector = Icons.Filled.AccountBox, contentDescription = "") },
                onClick = {}
            )
            MapNoteNavigationBarItem(selected = true,
                icon = { Icon(imageVector = Icons.Filled.VerifiedUser, contentDescription = "") },
                onClick = {}

            )
        }
    }
}





