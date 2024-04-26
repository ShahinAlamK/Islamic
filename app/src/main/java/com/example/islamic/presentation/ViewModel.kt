package com.example.islamic.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.islamic.data.models.ItemModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ViewModelData:ViewModel() {

    private val _number = MutableStateFlow<List<ItemModel>>(emptyList())
    val listData = _number




}