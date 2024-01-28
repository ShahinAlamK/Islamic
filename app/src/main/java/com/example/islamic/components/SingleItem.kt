package com.example.islamic.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.islamic.models.IbadatModel

@Composable
fun SingItemPage(ibadatModel: IbadatModel) {
    LazyColumn(
        modifier = Modifier
            .padding(horizontal = 15.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        item {
            Spacer(modifier = Modifier.height(25.dp))

            Text(text = ibadatModel.title,style = MaterialTheme.typography.titleLarge)
            Divider(modifier = Modifier.padding(vertical = 15.dp))

            Text(text = ibadatModel.arabic, textAlign = TextAlign.Center,style = MaterialTheme.typography.titleMedium)
            Divider(modifier = Modifier.padding(vertical = 15.dp))

            Text(text = ibadatModel.bangla, textAlign = TextAlign.Justify, style = MaterialTheme.typography.bodyLarge)
            Divider(modifier = Modifier.padding(vertical = 15.dp))

            Text(text = ibadatModel.meaning, textAlign = TextAlign.Justify, style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(15.dp))
        }
    }
}