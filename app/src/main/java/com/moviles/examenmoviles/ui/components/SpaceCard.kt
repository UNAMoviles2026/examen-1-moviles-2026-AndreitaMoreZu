package com.movies.examenmovies.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Business
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.People
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.res.painterResource
import com.movies.examenmovies.data.CoworkingSpace
import com.movies.examenmovies.ui.theme.GreenBorder
import com.movies.examenmovies.ui.theme.GreenIconTint
import com.movies.examenmovies.ui.theme.GreenPrimary
import com.movies.examenmovies.ui.theme.GreenSecondaryText
import com.movies.examenmovies.ui.theme.GreenLight

@Composable
fun SpaceCard(
    space: CoworkingSpace,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(22.dp),
        border = BorderStroke(1.dp, GreenBorder),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        onClick = onClick
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Imagen simulada (placeholder)
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(GreenLight),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Business,
                    contentDescription = "Space image",
                    tint = GreenPrimary,
                    modifier = Modifier.size(40.dp)
                )
            }

            // Información del espacio
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = space.name,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = "$${space.pricePerHour}/hour",
                    style = MaterialTheme.typography.bodyMedium,
                    color = GreenPrimary
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.LocationOn,
                        contentDescription = null,
                        modifier = Modifier.size(14.dp),
                        tint = GreenIconTint
                    )
                    Text(
                        text = space.location,
                        style = MaterialTheme.typography.bodySmall,
                        color = GreenSecondaryText
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.People,
                        contentDescription = null,
                        modifier = Modifier.size(14.dp),
                        tint = GreenIconTint
                    )
                    Text(
                        text = "Capacity: ${space.capacity}",
                        style = MaterialTheme.typography.bodySmall,
                        color = GreenSecondaryText
                    )
                }
            }
        }
    }
}