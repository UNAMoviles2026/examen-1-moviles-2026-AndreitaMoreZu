package com.movies.examenmovies.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.movies.examenmovies.data.mockSpaces  // Importar desde data
import com.movies.examenmovies.ui.components.BottomBar
import com.movies.examenmovies.ui.components.SpaceCard
import com.movies.examenmovies.ui.theme.GreenBackground

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(
    onSpaceClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    var spaces by remember { mutableStateOf(mockSpaces) }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = GreenBackground,
        topBar = {
            TopAppBar(
                title = { Text("Coworking Spaces") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = GreenBackground
                )
            )
        },
        bottomBar = {
            BottomBar()
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(
                start = 14.dp,
                end = 14.dp,
                top = 12.dp,
                bottom = 80.dp
            ),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(spaces) { space ->
                SpaceCard(
                    space = space,
                    onClick = { onSpaceClick(space.id) }
                )
            }
        }
    }
}