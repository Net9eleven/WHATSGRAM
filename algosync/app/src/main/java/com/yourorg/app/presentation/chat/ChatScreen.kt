package com.yourorg.app.presentation.chat

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ChatScreen(chatId: String) {
    var input by remember { mutableStateOf("") }
    val messages = listOf<String>() // placeholder

    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.weight(1f), reverseLayout = true) {
            items(messages.size) { idx ->
                Text(text = messages[idx], modifier = Modifier.padding(8.dp))
            }
        }
        Row(modifier = Modifier.padding(8.dp)) {
            TextField(value = input, onValueChange = { input = it }, modifier = Modifier.weight(1f))
            Spacer(Modifier.width(8.dp))
            Button(onClick = { input = "" }) { Text("Send") }
        }
    }
}
