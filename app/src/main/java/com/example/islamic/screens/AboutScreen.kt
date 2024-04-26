package com.example.islamic.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.islamic.R

@Composable
fun AboutScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 15.dp)
            .statusBarsPadding()
            .navigationBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(0.3f))

        Image(
            modifier = Modifier
                .size(80.dp)
                .clip(MaterialTheme.shapes.small)
                .background(Color.Black)
                .padding(10.dp),
            painter = painterResource(R.drawable.light_logo), contentDescription = ""
        )

        Spacer(modifier = Modifier.height(30.dp))
        Text(text = "Shahin Alam Kiron",
            fontWeight = FontWeight.Medium,
            style = MaterialTheme.typography.labelMedium)

        Spacer(modifier = Modifier.height(5.dp))
        Text(text = "shahinalam2334@gmail.com",style = MaterialTheme.typography.labelMedium)

        Spacer(modifier = Modifier.weight(0.3f))

    }
}