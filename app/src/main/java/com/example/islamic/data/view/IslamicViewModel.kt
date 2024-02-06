package com.example.islamic.data.view

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.islamic.data.models.ItemModel
import com.example.islamic.data.repository.IslamicRepo
import com.example.islamic.data.utils.AppResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class IslamicViewModel @Inject constructor(private val islamicRepo: IslamicRepo):ViewModel() {

    val response: MutableState<List<ItemModel>> = mutableStateOf(emptyList())
    val error: MutableState<String> = mutableStateOf("")

    private var _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    init {
        fetchAllIslamic()
    }
    fun fetchAllIslamic() = viewModelScope.launch {
        islamicRepo.fetchAll().collect{snapshot->
            when(snapshot){
                is AppResponse.Loading->{_isLoading.value = true}
                is AppResponse.Failure->{error.value = snapshot.msg.message!!}
                is AppResponse.Success->{
                    response.value = snapshot.data
                    _isLoading.value = false
                }
            }
        }
    }
}