package com.movies.examenmovies.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.filled.Business
import androidx.compose.material.icons.outlined.AttachMoney
import androidx.compose.material.icons.outlined.Cancel
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.People
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import com.movies.examenmovies.data.CoworkingSpace
import com.movies.examenmovies.ui.components.BottomBar
import com.movies.examenmovies.ui.components.PrimaryButton
import com.movies.examenmovies.ui.screens.mockSpaces
import com.movies.examenmovies.ui.theme.GreenBackground
import com.movies.examenmovies.ui.theme.GreenBorder
import com.movies.examenmovies.ui.theme.GreenIconTint
import com.movies.examenmovies.ui.theme.GreenLight
import com.movies.examenmovies.ui.theme.GreenPrimary
import com.movies.examenmovies.ui.theme.GreenSecondaryText
import com.movies.examenmovies.ui.theme.GreenSurface

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    spaceId: Int,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val space = mockSpaces.find { it.id == spaceId }
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = GreenBackground,
        topBar = {
            TopAppBar(
                title = { Text(space?.name ?: "Space Details") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = GreenBackground
                )
            )
        },
        bottomBar = {
            BottomBar()
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState) { snackbarData ->
                Snackbar(
                    modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp),
                    snackbarData = snackbarData,
                    containerColor = GreenPrimary,
                    contentColor = GreenSurface
                )
            }
        }
    ) { paddingValues ->
        if (space == null) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text("Space not found")
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Spacer(modifier = Modifier.height(8.dp))

                // IMAGEN SIMULADA GRANDE
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(22.dp))
                        .background(GreenLight),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Business,
                        contentDescription = "Space image",
                        tint = GreenPrimary,
                        modifier = Modifier.size(80.dp)
                    )
                }

                // Información del espacio
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(22.dp),
                    border = BorderStroke(1.dp, GreenBorder),
                    colors = CardDefaults.cardColors(containerColor = GreenSurface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(20.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Text(
                            text = space.name,
                            style = MaterialTheme.typography.headlineSmall,
                            color = GreenPrimary
                        )
                        DetailInfoRow(
                            icon = Icons.Outlined.LocationOn,
                            text = space.location
                        )
                        DetailInfoRow(
                            icon = Icons.Outlined.People,
                            text = "Capacity: ${space.capacity} people"
                        )
                        DetailInfoRow(
                            icon = Icons.Outlined.AttachMoney,
                            text = "Price: $${space.pricePerHour} per hour"
                        )
                        DetailInfoRow(
                            icon = if (space.isAvailable) Icons.Outlined.CheckCircle else Icons.Outlined.Cancel,
                            text = if (space.isAvailable) "Available now" else "Currently unavailable",
                            iconTint = if (space.isAvailable) GreenPrimary else GreenSecondaryText
                        )
                    }
                }

                // Descripción
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(22.dp),
                    border = BorderStroke(1.dp, GreenBorder),
                    colors = CardDefaults.cardColors(containerColor = GreenSurface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(20.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Text(
                            text = "Description",
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            text = space.description,
                            style = MaterialTheme.typography.bodyMedium,
                            color = GreenSecondaryText
                        )
                    }
                }

                Spacer(modifier = Modifier.weight(1f))

                PrimaryButton(
                    text = if (space.isAvailable) "Reserve Now" else "Not Available",
                    onClick = {
                        if (space.isAvailable) {
                            scope.launch {
                                snackbarHostState.showSnackbar(
                                    message = "${space.name} reserved successfully!"
                                )
                            }
                        }
                    },
                    enabled = space.isAvailable,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                )
            }
        }
    }
}

// Función corregida - el problema estaba aquí
@Composable
private fun DetailInfoRow(
    icon: ImageVector,
    text: String,
    iconTint: Color = GreenIconTint  // <--- Tipo correcto: Color, no otro tipo
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = iconTint,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = text,
            color = GreenSecondaryText,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}