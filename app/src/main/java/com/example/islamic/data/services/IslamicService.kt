package com.example.islamic.data.services

import com.example.islamic.data.models.ItemModel
import com.example.islamic.data.utils.AppResponse
import kotlinx.coroutines.flow.Flow

interface IslamicService {
    fun fetchAll(): Flow<AppResponse<List<ItemModel>>>
}