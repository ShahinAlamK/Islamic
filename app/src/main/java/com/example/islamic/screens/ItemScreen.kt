package com.example.islamic.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.islamic.R
import com.example.islamic.components.CustomCard
import com.example.islamic.components.ErrorComponent
import com.example.islamic.components.RoundComponent
import com.example.islamic.navigations.NavigateString
import com.example.islamic.presentation.SharedViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemScreen(sharedViewModel: SharedViewModel, navController: NavController) {
    val data = sharedViewModel.sharedData

    Scaffold(
        topBar = {

            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    navigationIconContentColor = MaterialTheme.colorScheme.onBackground,
                    actionIconContentColor = MaterialTheme.colorScheme.onBackground,
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                title = {
                    Image(
                        modifier = Modifier.size(100.dp),
                        painter = painterResource(id = R.drawable.islamic_logo), contentDescription = "")
                },

                navigationIcon = {

                    IconButton(
                        onClick = { navController.popBackStack()}
                    ) {
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "")
                    }
                },
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .navigationBarsPadding()
        ) {
            if (data?.items!!.isEmpty()) {
                ErrorComponent("No Data")
            } else {
                LazyColumn{
                    items(data.items.size) {
                        //Spacer(modifier = Modifier.height(1.dp))
                        CustomCard(
                            title = data.items[it].title,
                            click = {
                                navController.navigate(NavigateString.DetailRoute.route)
                                sharedViewModel.setDetailData(data.items[it])
                            }
                        )
                    }
                }
            }
        }


    }
}