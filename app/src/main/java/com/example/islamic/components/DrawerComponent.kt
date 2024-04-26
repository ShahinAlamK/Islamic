package com.example.islamic.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.material3.DrawerState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.islamic.R
import com.example.islamic.data.view.IslamicViewModel
import com.example.islamic.navigations.NavigateString
import kotlinx.coroutines.launch

@Composable
fun DrawerComponent(
    navController: NavController,
    drawerState: DrawerState,
    viewModel: IslamicViewModel = hiltViewModel()
) {
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
                .height(150.dp)
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier.size(100.dp),
                painter = painterResource(id = R.drawable.islamic_logo), contentDescription = ""
            )
        }

        HorizontalDivider(
            modifier = Modifier.padding(bottom = 10.dp),
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.onSecondary
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
        ) {
            item {

                CustomTile(
                    onClick = {},
                    label = "Share",
                    icon = Icons.Outlined.Share
                )
                CustomTile(
                    onClick = {},
                    label = "Privacy Policy",
                    icon = Icons.Outlined.Warning
                )
                CustomTile(
                    onClick = {
                        navController.navigate(NavigateString.About.route)},
                    label = "About",
                    icon = Icons.Outlined.Info
                )


            }
        }

    }
}


@Composable
fun CustomTile(
    onClick: () -> Unit,
    icon: ImageVector,
    label: String,
) {
    NavigationDrawerItem(
        colors = NavigationDrawerItemDefaults.colors(
            unselectedContainerColor = Color.Transparent
        ),
        shape = RoundedCornerShape(0.dp),
        icon = {
            Icon(
                tint = MaterialTheme.colorScheme.onBackground,
                imageVector = icon, contentDescription = ""
            )
        },
        label = {
            Text(
                text = label,
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.labelMedium
            )
        },
        badge = {
            Icon(
                tint = MaterialTheme.colorScheme.onBackground,
                imageVector = Icons.Outlined.ArrowForward,
                contentDescription = ""
            )
        },
        selected = false,
        onClick = { onClick() }
    )
}