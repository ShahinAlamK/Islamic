package com.example.islamic.navigations

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.islamic.presentation.SettingsViewModel
import com.example.islamic.presentation.SharedViewModel
import com.example.islamic.presentation.ViewModelData
import com.example.islamic.screens.DetailScreen
import com.example.islamic.screens.HomeScreen
import com.example.islamic.screens.ItemScreen

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
        composable(
            details,
            enterTransition = {
                fadeIn(tween(delayMillis = 200))+slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left,tween(delayMillis = 200)
                )
            },
            exitTransition = {
                fadeOut(tween(delayMillis = 200)) +slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left,tween(delayMillis = 200)
                )
            },
            popEnterTransition = {
                fadeIn(tween(delayMillis = 80))+slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right,tween(delayMillis = 80)
                )
            },
            popExitTransition = {
                fadeOut(tween(delayMillis = 80)) +slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right,tween(delayMillis = 80)
                )
            },

        ){ DetailScreen(sharedViewModel = sharedViewModel, navController = navHostController)}

        composable(
            itemScreen,
            enterTransition = {
                fadeIn(tween(delayMillis = 200))+slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left,tween(delayMillis = 200)
                )
            },
            exitTransition = {
                fadeOut(tween(delayMillis = 200)) +slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left,tween(delayMillis = 200)
                )
            },
            popEnterTransition = {
                fadeIn(tween(delayMillis = 80))+slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right,tween(delayMillis = 80)
                )
            },
            popExitTransition = {
                fadeOut(tween(delayMillis = 80)) +slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right,tween(delayMillis = 80)
                )
            },

            ){ ItemScreen(sharedViewModel = sharedViewModel, navController = navHostController) }
    }

}

const val home = "HomeScreen"
const val itemScreen = "ItemScreen"
const val details = "DetailsScreen"