package com.example.islamic.components

import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.islamic.R
import com.example.islamic.presentation.SettingsViewModel
import com.example.islamic.ui.theme.OnPrimary
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppbarComponents(
    drawerState: DrawerState
) {
    val settingsViewModel: SettingsViewModel = viewModel()
    val scope = rememberCoroutineScope()

    val icon =
        if (settingsViewModel.isDark) painterResource(id = R.drawable.mode) else painterResource(
            id = R.drawable.moon
        )
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background),
        title = {
            Text(
                text = "প্রয়োজনীয় আয়াত ও সূরাহ",
                style = MaterialTheme.typography.titleLarge
            )
        },

        navigationIcon = {
            RoundComponent(modifier = Modifier.padding(10.dp)) {
                IconButton(
                    onClick = {
                        scope.launch { drawerState.open() }
                    }) {
                    Icon(imageVector = Icons.Outlined.Menu, contentDescription = "")
                }
            }
        },

        actions = {
            RoundComponent(
                modifier = Modifier.padding(start = 10.dp)
            ) {
                IconButton(
                    onClick = {
                        settingsViewModel.toggleTheme()
                    }) {
                    Icon(
                        modifier = Modifier.size(20.dp),
                        painter = icon, contentDescription = ""
                    )
                }
            }

            Spacer(modifier = Modifier.width(15.dp))
        }
    )

}

