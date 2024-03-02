package com.example.islamic.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.islamic.presentation.ViewModelData
import com.example.islamic.components.AppbarComponents
import com.example.islamic.components.CustomCard
import com.example.islamic.components.DrawerComponent
import com.example.islamic.components.ErrorComponent
import com.example.islamic.components.LoadingComponent
import com.example.islamic.data.view.IslamicViewModel
import com.example.islamic.navigations.NavigateString
import com.example.islamic.presentation.SharedViewModel

@Composable
fun HomeScreen(
    viewModel: IslamicViewModel = hiltViewModel(),
    viewModelData: ViewModelData,
    navController: NavController, sharedViewModel: SharedViewModel
) {
    val items = viewModelData.listData.collectAsState().value

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = { DrawerComponent(drawerState = drawerState) }
    ) {
        Scaffold(
            topBar = { AppbarComponents(drawerState = drawerState) }
        ) { paddingValues ->
            Box(
                Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                if (viewModel.error.value.isNotEmpty()) {
                    ErrorComponent(msg = viewModel.error.value)
                } else if (viewModel.isLoading.value) {
                    LoadingComponent()
                } else if (viewModel.response.value.isEmpty()) {
                    Text(text = "Empty Task Toady")
                } else if (viewModel.response.value.isNotEmpty()) {
                    DataList(navController = navController, sharedViewModel = sharedViewModel)
                }
            }
        }
    }
}

@Composable
fun DataList(
    navController: NavController,
    sharedViewModel: SharedViewModel,
    viewModel: IslamicViewModel = hiltViewModel()
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        items(viewModel.response.value.size) {
            Spacer(modifier = Modifier.height(10.dp))
            CustomCard(
                index = it,
                title = viewModel.response.value[it].title,
                click = {
                    navController.navigate(NavigateString.ItemRoute.route)
                    sharedViewModel.setShareData(viewModel.response.value[it])
                }
            )
        }
    }
}


