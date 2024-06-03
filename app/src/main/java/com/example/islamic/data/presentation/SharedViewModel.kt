package com.example.islamic.data.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.islamic.data.models.IbadatModel
import com.example.islamic.data.models.ItemModel

class SharedViewModel : ViewModel() {


    var sharedData by mutableStateOf<ItemModel?>(null)

    fun setShareData(model: ItemModel) {
        sharedData = model
    }

    var getDetailsData by mutableStateOf<IbadatModel?>(null)
    fun setDetailData(model: IbadatModel) {
        getDetailsData = model
    }
}