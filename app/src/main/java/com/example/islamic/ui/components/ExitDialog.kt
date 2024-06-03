package com.example.islamic.ui.components

import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.android.awaitFrame
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun ExitDialog(
    isOpenDialog: MutableState<Boolean>,
) {
    var backPressHandled by remember { mutableStateOf(false) }
    val onBackPressedDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher
    val scope = rememberCoroutineScope()
    if (isOpenDialog.value)
    AlertDialog(
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.small,
        onDismissRequest = { },
        dismissButton = {
            TextButton(
                onClick = {isOpenDialog.value=false}) {
                Text(text = "Cancel",color = MaterialTheme.colorScheme.onPrimary)
            }
        },
        confirmButton = {
            TextButton(
                onClick = { }) {
                Text(text = "Exit", color = MaterialTheme.colorScheme.onPrimary)
            }
        },
        title = { Text(text = "Close Application")},
        text = {
            Text(text = "Are you sure want to exit now")
        }
    )
}



