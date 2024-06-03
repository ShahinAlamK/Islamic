package com.example.islamic.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun RoundComponent(modifier: Modifier = Modifier, icon: @Composable () -> Unit = {}) {
    Box(
        modifier = modifier
            .size(40.dp)
            .clip(CircleShape)
            .background(color = MaterialTheme.colorScheme.secondary),
        contentAlignment = Alignment.Center
    ) {
        icon()
    }
}