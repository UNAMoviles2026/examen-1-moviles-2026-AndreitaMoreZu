package com.movies.examenmovies.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.movies.examenmovies.ui.theme.GreenPrimary
import com.movies.examenmovies.ui.theme.GreenSurface

@Composable
fun BottomBar(modifier: Modifier = Modifier) {
    BottomAppBar(
        modifier = modifier,
        containerColor = GreenSurface
    ) {
        NavigationBarItem(
            selected = true,
            onClick = { },
            icon = { Icon(Icons.Default.Home, contentDescription = "Spaces") },
            label = { Text("Spaces") }
        )
        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = { Icon(Icons.Default.Info, contentDescription = "Info") },
            label = { Text("Info") }
        )
    }
}