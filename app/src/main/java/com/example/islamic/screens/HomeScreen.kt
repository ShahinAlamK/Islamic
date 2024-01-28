package com.example.islamic.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.islamic.presentation.ViewModelData
import com.example.islamic.components.AppbarComponents
import com.example.islamic.components.CustomCard
import com.example.islamic.models.IbadatModel
import com.example.islamic.navigations.details
import com.example.islamic.presentation.SharedViewModel
import com.google.accompanist.pager.ExperimentalPagerApi


@Composable
fun HomeScreen(viewModelData: ViewModelData, navController: NavController,sharedViewModel: SharedViewModel) {
    val data = viewModelData.listData.collectAsState().value

    Scaffold(
        topBar = { AppbarComponents() }
    ) {paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
        ) {
            items(data.size){
                Spacer(modifier = Modifier.height(15.dp))
                CustomCard(
                    index = it,
                    title =  data[it].title,
                    click = {
                        val datas = IbadatModel(
                            id = data[it].id,
                            title = data[it].title,
                            bangla = data[it].bangla,
                            arabic = data[it].arabic,
                            meaning = data[it].meaning,
                        )
                        sharedViewModel.setShareData(model = datas)
                        navController.navigate(details)
                    }
                )
            }
        }
    }
}





