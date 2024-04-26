package com.example.islamic.navigations

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.islamic.presentation.SharedViewModel
import com.example.islamic.presentation.ViewModelData
import com.example.islamic.screens.AboutScreen
import com.example.islamic.screens.DetailScreen
import com.example.islamic.screens.HomeScreen
import com.example.islamic.screens.ItemScreen
import com.example.islamic.screens.SplashScreen

@Composable
fun Routes(navHostController: NavHostController) {

    val sharedViewModel: SharedViewModel = viewModel()

    NavHost(navController = navHostController, startDestination = NavigateString.Splash.route) {

        composable(
            NavigateString.Splash.route,
        ) {
            SplashScreen(navController = navHostController)
        }

        composable(NavigateString.HomeRoute.route) {

            HomeScreen(
                navController = navHostController,
                sharedViewModel = sharedViewModel
            )
        }

        composable(
            NavigateString.DetailRoute.route,
        ) { DetailScreen(sharedViewModel = sharedViewModel, navController = navHostController) }


        composable(NavigateString.ItemRoute.route) {
            ItemScreen(
                sharedViewModel = sharedViewModel,
                navController = navHostController
            )
        }


        composable(NavigateString.About.route) {
            AboutScreen(navController = navHostController)
        }
    }

}
