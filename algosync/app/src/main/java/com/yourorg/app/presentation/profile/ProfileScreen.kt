package com.yourorg.app.presentation.profile

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.launch
import com.yourorg.app.auth.AuthRepository
import com.yourorg.app.auth.ProfileManager

@Composable
fun ProfileScreen(onDone: () -> Unit) {
  val context = LocalContext.current
  val repo = remember { AuthRepository(context) }
  val userId = remember { repo.getStoredUserId() }
  var username by remember { mutableStateOf("") }
  var displayName by remember { mutableStateOf("") }
  var status by remember { mutableStateOf<String?>(null) }
  val scope = rememberCoroutineScope()

  Column(Modifier.fillMaxSize().padding(16.dp)) {
    Text("Set up profile", style = MaterialTheme.typography.h5)
    Spacer(Modifier.height(8.dp))
    OutlinedTextField(value = username, onValueChange = { username = it }, label={Text("Username")}, modifier=Modifier.fillMaxWidth())
    OutlinedTextField(value = displayName, onValueChange = { displayName = it }, label={Text("Display name")}, modifier=Modifier.fillMaxWidth())
    Spacer(Modifier.height(8.dp))
    Button(onClick = {
      scope.launch {
        if (userId == null) { status = "Not logged in"; return@launch }
        try {
          ProfileManager().createProfile(userId, username, displayName, null)
          status = "Profile created."; onDone()
        } catch (e: Exception) { status = e.message }
      }
    }, modifier=Modifier.fillMaxWidth()) { Text("Save") }
    if (status != null) Text(status!!)
  }
}
