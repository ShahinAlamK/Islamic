package com.example.islamic.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.islamic.ui.components.RoundComponent
import com.example.islamic.data.presentation.SharedViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(sharedViewModel: SharedViewModel, navController: NavController) {
    val model = sharedViewModel.getDetailsData
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background),
                navigationIcon = {
                    RoundComponent(modifier = Modifier.padding(10.dp)) {
                        IconButton(
                            onClick = {navController.popBackStack()}) {
                            Icon(imageVector = Icons.Outlined.ArrowBack, contentDescription = "")
                        }
                    }
                },
                title = { Text(text = model?.title!!) })
        }
    ) {padding->
        LazyColumn(
            modifier = Modifier.padding(padding)
                .padding(horizontal = 15.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            item {
                Spacer(modifier = Modifier.height(20.dp))

                Text(text = model?.arabic!!, textAlign = TextAlign.Center,style = MaterialTheme.typography.titleMedium)
                Divider(modifier = Modifier.padding(vertical = 15.dp))

                Text(text = model.bangla, textAlign = TextAlign.Center, style = MaterialTheme.typography.bodyLarge)
                Divider(modifier = Modifier.padding(vertical = 15.dp))

                Text(text = model.meaning, textAlign = TextAlign.Justify, style = MaterialTheme.typography.bodyLarge)
                Spacer(modifier = Modifier.height(15.dp))
            }
        }
    }

}