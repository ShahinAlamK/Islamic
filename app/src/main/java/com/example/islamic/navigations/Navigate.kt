package com.example.islamic.navigations

sealed class NavigateString(val route:String) {
    data object HomeRoute:NavigateString("HomeSreeen")
    data object ItemRoute:NavigateString("ItemScreen")
    data object DetailRoute:NavigateString("DetailsScreen")
}