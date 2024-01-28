package com.example.islamic.screens

import androidx.compose.runtime.Composable
import com.example.islamic.components.SingItemPage
import com.example.islamic.presentation.SharedViewModel

@Composable
fun DetailScreen(sharedViewModel: SharedViewModel) {
    val model = sharedViewModel.sharedData
    model.let { ibadatModel -> model }?.let { SingItemPage(ibadatModel = it) }

}