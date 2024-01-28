package com.example.islamic.navigations

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.islamic.models.IbadatModel
import com.example.islamic.presentation.SettingsViewModel
import com.example.islamic.presentation.SharedViewModel
import com.example.islamic.presentation.ViewModelData
import com.example.islamic.screens.DetailScreen
import com.example.islamic.screens.HomeScreen
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun Routes(viewModelData: ViewModelData) {

    val navHostController = rememberNavController()
    val sharedViewModel:SharedViewModel = viewModel()
    val settingsViewModel:SettingsViewModel = viewModel()

    NavHost(navController = navHostController, startDestination = home){
        composable(home){ HomeScreen(
            viewModelData=viewModelData,
            navController = navHostController,
            sharedViewModel = sharedViewModel
        ) }
        composable(details){
            DetailScreen(
                sharedViewModel = sharedViewModel
            )}
    }

}

const val home = "HomeScreen"
const val details = "DetailsScreen"