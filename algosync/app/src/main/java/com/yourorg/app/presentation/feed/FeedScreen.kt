package com.yourorg.app.presentation.feed

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.yourorg.app.data.remote.SupabaseClientProvider
import kotlinx.coroutines.launch

@Composable
fun FeedScreen() {
    val scope = rememberCoroutineScope()
    var posts by remember { mutableStateOf<List<Map<String, Any>>>(emptyList()) }

    LaunchedEffect(Unit) {
        scope.launch {
            try {
                val res = SupabaseClientProvider.client.postgrest["posts"].select()
                // This returns a JsonElement; kept simple here
                posts = emptyList()
            } catch (_: Exception) {}
        }
    }

    Column(Modifier.fillMaxSize()) {
        Text("Explore / Feed", style = MaterialTheme.typography.h5, modifier = Modifier.padding(8.dp))
        LazyColumn(Modifier.fillMaxSize()) {
            items(posts.size) { i ->
                Card(Modifier.padding(8.dp)) {
                    Column(Modifier.padding(8.dp)) {
                        Text(text = "Post #$i", style = MaterialTheme.typography.subtitle1)
                    }
                }
            }
        }
    }
}
