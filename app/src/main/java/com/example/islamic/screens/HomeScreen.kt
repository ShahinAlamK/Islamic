package com.example.islamic.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.islamic.R
import com.example.islamic.presentation.ViewModelData
import com.example.islamic.components.CustomCard
import com.example.islamic.components.DrawerComponent
import com.example.islamic.components.ErrorComponent
import com.example.islamic.components.GridCard
import com.example.islamic.components.LoadingComponent
import com.example.islamic.components.RoundComponent
import com.example.islamic.data.view.IslamicViewModel
import com.example.islamic.navigations.NavigateString
import com.example.islamic.presentation.SharedViewModel
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    viewModel: IslamicViewModel = hiltViewModel(),
    navController: NavController,
    sharedViewModel: SharedViewModel
) {
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerComponent(
                navController = navController,
                drawerState = drawerState,
            )
        }
    ) {

        Column(
            Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .statusBarsPadding()
                .navigationBarsPadding(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.weight(0.5f))
            Image(
                modifier = Modifier.size(150.dp),
                painter = painterResource(id = R.drawable.islamic_logo), contentDescription = ""
            )

            Spacer(modifier = Modifier.weight(0.2f))

            if (viewModel.error.value.isNotEmpty()) {
                ErrorComponent(msg = viewModel.error.value)
            } else if (viewModel.isLoading.value) {
                LoadingComponent()
            } else if (viewModel.response.value.isEmpty()) {
                Text(text = "Empty Task Toady", style = MaterialTheme.typography.labelMedium)
            } else if (viewModel.response.value.isNotEmpty()) {
                DataList(navController = navController, sharedViewModel = sharedViewModel)
            }

            Spacer(modifier = Modifier.height(20.dp))
            RoundComponent(modifier = Modifier.padding(10.dp)) {
                IconButton(
                    onClick = {
                        scope.launch { drawerState.open() }
                    }) {
                    Icon(imageVector = Icons.Outlined.Menu, contentDescription = "")
                }
            }
            Spacer(modifier = Modifier.weight(1f))


        }
    }

}


@Composable
fun DataList(
    navController: NavController,
    sharedViewModel: SharedViewModel,
    viewModel: IslamicViewModel = hiltViewModel()
) {
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(viewModel.response.value.size) {
            GridCard(
                title = viewModel.response.value[it].title,
                click = {
                    navController.navigate(NavigateString.ItemRoute.route)
                    sharedViewModel.setShareData(viewModel.response.value[it])
                }
            )
        }

    }
}

