package com.example.islamic.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.islamic.models.IbadatModel

class SharedViewModel:ViewModel() {

    var sharedData by mutableStateOf<IbadatModel?>(null)

    fun setShareData(model: IbadatModel){
        sharedData = model
    }
}