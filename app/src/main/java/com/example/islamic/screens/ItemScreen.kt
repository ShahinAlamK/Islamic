package com.example.islamic.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.islamic.components.CustomCard
import com.example.islamic.components.ErrorComponent
import com.example.islamic.components.RoundComponent
import com.example.islamic.navigations.details
import com.example.islamic.navigations.itemScreen
import com.example.islamic.presentation.SharedViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemScreen(sharedViewModel: SharedViewModel,navController: NavController) {
    val data = sharedViewModel.sharedData

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background),
                title = {
                    Text(
                        text = data?.title!!,
                        style = MaterialTheme.typography.titleLarge
                    )
                },

                navigationIcon = {
                    RoundComponent(modifier = Modifier.padding(10.dp)) {
                        IconButton(
                            onClick = {navController.popBackStack()}) {
                            Icon(imageVector = Icons.Outlined.ArrowBack, contentDescription = "")
                        }
                    }
                },

                )
        }
    ){paddingValues ->
        Box(
            modifier = Modifier.padding(paddingValues)
        ) {
            if(data?.items!!.isEmpty()){
                ErrorComponent("No Data")
            }else{
                LazyColumn(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                ) {
                    items(data.items.size) {
                        Spacer(modifier = Modifier.height(10.dp))
                        CustomCard(
                            index = it,
                            title = data.items[it].title,
                            click = {
                                navController.navigate(details)
                                sharedViewModel.setDetailData(data.items[it])
                            }
                        )
                    }
                }
            }
        }


    }
}