package com.example.islamic.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.islamic.models.IbadatModel
import com.example.islamic.models.dataList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ViewModelData:ViewModel() {

    private val _number = MutableStateFlow<List<IbadatModel>>(emptyList())
    val listData = _number

    init {
        viewModelScope.launch {
            _number.value= dataList
        }
    }


}