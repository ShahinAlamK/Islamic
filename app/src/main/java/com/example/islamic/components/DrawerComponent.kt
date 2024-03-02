package com.example.islamic.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material.icons.outlined.ExitToApp
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.islamic.data.view.IslamicViewModel
import kotlinx.coroutines.launch

@Composable
fun DrawerComponent(drawerState: DrawerState,viewModel: IslamicViewModel = hiltViewModel()) {
    val scope = rememberCoroutineScope()

    ModalDrawerSheet(
        drawerShape = RoundedCornerShape(0.dp),
        drawerContainerColor = MaterialTheme.colorScheme.background,
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(end = 100.dp)
    ) {
        Box(
            modifier = Modifier
                .height(180.dp)
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "প্রয়োজনীয় আয়াত ও সূরাহ", style = MaterialTheme.typography.titleLarge)
        }

        Divider(
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.onSecondary,
            modifier = Modifier.padding(bottom = 10.dp)
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
        ) {
            item {

                NavigationDrawerItem(
                    colors = NavigationDrawerItemDefaults.colors(
                        unselectedContainerColor = Color.Transparent
                    ),
                    shape = RoundedCornerShape(0.dp),
                    icon = { Icon(imageVector = Icons.Outlined.Refresh, contentDescription = "") },
                    label = { Text(text = "Update") },
                    badge = {
                        Icon(
                            imageVector = Icons.Outlined.ArrowForward,
                            contentDescription = ""
                        )
                    },
                    selected = false,
                    onClick = {
                        scope.launch {
                            viewModel.fetchAllIslamic()
                        }
                    }
                )

                NavigationDrawerItem(
                    colors = NavigationDrawerItemDefaults.colors(
                        unselectedContainerColor = Color.Transparent
                    ),
                    shape = RoundedCornerShape(0.dp),
                    icon = { Icon(imageVector = Icons.Outlined.Add, contentDescription = "") },
                    label = { Text(text = "New Post") },
                    badge = {
                        Icon(
                            imageVector = Icons.Outlined.ArrowForward,
                            contentDescription = ""
                        )
                    },
                    selected = false,
                    onClick = {

                    }
                )

                NavigationDrawerItem(
                    colors = NavigationDrawerItemDefaults.colors(
                        unselectedContainerColor = Color.Transparent
                    ),
                    shape = RoundedCornerShape(0.dp),
                    icon = { Icon(imageVector = Icons.Outlined.Settings, contentDescription = "") },
                    label = { Text(text = "Settings") },
                    badge = {
                        Icon(
                            imageVector = Icons.Outlined.ArrowForward,
                            contentDescription = ""
                        )
                    },
                    selected = false,
                    onClick = {}
                )

                NavigationDrawerItem(
                    colors = NavigationDrawerItemDefaults.colors(
                        unselectedContainerColor = Color.Transparent
                    ),
                    shape = RoundedCornerShape(0.dp),
                    icon = { Icon(imageVector = Icons.Outlined.Info, contentDescription = "") },
                    label = { Text(text = "About") },
                    badge = {
                        Icon(
                            imageVector = Icons.Outlined.ArrowForward,
                            contentDescription = ""
                        )
                    },
                    selected = false,
                    onClick = {}
                )
                NavigationDrawerItem(
                    colors = NavigationDrawerItemDefaults.colors(
                        unselectedContainerColor = Color.Transparent
                    ),
                    shape = RoundedCornerShape(0.dp),
                    icon = { Icon(imageVector = Icons.Outlined.Share, contentDescription = "") },
                    label = { Text(text = "Share") },
                    badge = {
                        Icon(
                            imageVector = Icons.Outlined.ArrowForward,
                            contentDescription = ""
                        )
                    },
                    selected = false,
                    onClick = {}
                )


            }
        }

    }
}