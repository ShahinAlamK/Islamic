package com.example.islamic.screens

import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
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
import com.example.islamic.navigations.itemScreen
import com.example.islamic.presentation.SharedViewModel
import kotlinx.coroutines.delay


@Composable
fun HomeScreen(
    viewModel: IslamicViewModel = hiltViewModel(),
    viewModelData: ViewModelData,
    navController: NavController, sharedViewModel: SharedViewModel
) {
    val items = viewModelData.listData.collectAsState().value

    val isExit = remember { mutableStateOf(false) }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    BackPressSample()
    //ExitDialog(isOpenDialog = isExit)

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
                    navController.navigate(itemScreen)
                    sharedViewModel.setShareData(viewModel.response.value[it])
                }
            )
        }
    }
}


sealed class BackPress {
    object Idle : BackPress()
    object InitialTouch : BackPress()
}

@Composable
fun BackPressSample() {
    var showToast by remember { mutableStateOf(false) }

    var backPressState by remember { mutableStateOf<BackPress>(BackPress.Idle) }
    val context = LocalContext.current

    if (showToast) {
        Toast.makeText(context, "Press again to exit", Toast.LENGTH_SHORT).show()
        showToast = false
    }


    LaunchedEffect(key1 = backPressState) {
        if (backPressState == BackPress.InitialTouch) {
            delay(2000)
            backPressState = BackPress.Idle
        }
    }

    BackHandler(backPressState == BackPress.Idle) {
        backPressState = BackPress.InitialTouch
        showToast = true
    }
}


