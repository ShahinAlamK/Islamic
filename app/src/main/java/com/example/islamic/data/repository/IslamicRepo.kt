package com.example.islamic.data.repository

import com.example.islamic.data.models.IbadatModel
import com.example.islamic.data.models.ItemModel
import com.example.islamic.data.models.itemList
import com.example.islamic.data.services.IslamicService
import com.example.islamic.data.utils.AppResponse
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.getField
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class IslamicRepo @Inject constructor(private val db: FirebaseFirestore) : IslamicService {
    override fun fetchAll(): Flow<AppResponse<List<ItemModel>>> = callbackFlow {
        try {
            trySend(AppResponse.Loading)
            db.collection("message").get()
                .addOnSuccessListener { snapshot ->
                    val data = snapshot.map { item ->
                        ItemModel(
                            title = item["title"] as String,
                            items = item["items"] as ArrayList<IbadatModel>
                        )
                    }
                    trySend(AppResponse.Success(data))
                }.addOnFailureListener {
                    trySend(AppResponse.Failure(it))
                }
        } catch (e: Exception) {
            trySend(AppResponse.Failure(e))
        }
        awaitClose { close() }
    }
}