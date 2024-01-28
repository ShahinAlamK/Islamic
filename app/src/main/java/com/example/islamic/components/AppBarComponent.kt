package com.example.islamic.components

import androidx.activity.viewModels
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.islamic.R
import com.example.islamic.presentation.SettingsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppbarComponents() {
    val settingsViewModel: SettingsViewModel = viewModel()

    val icon = if (settingsViewModel.isDark) painterResource(id = R.drawable.mode) else painterResource(
        id = R.drawable.moon
    )
    CenterAlignedTopAppBar(
        modifier = Modifier.shadow(elevation = 2.dp),
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background), 
        title = {Text(text = "প্রয়োজনীয় আয়াত ও সূরাহ", style = MaterialTheme.typography.titleLarge)},
        actions = {
            IconButton(
                onClick = {
                    settingsViewModel.toggleTheme()
                }) {
                Icon(
                    modifier = Modifier.size(22.dp),
                    painter =icon, contentDescription ="" )
            }

            Spacer(modifier = Modifier.width(15.dp))
        }
    )
    
}