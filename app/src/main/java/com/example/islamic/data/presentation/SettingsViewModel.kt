package com.example.islamic.data.presentation

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SettingsViewModel:ViewModel() {

    var isDark by mutableStateOf(false)

    fun toggleTheme(){
        isDark=!isDark
    }
}