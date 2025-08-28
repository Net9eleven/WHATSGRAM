package com.yourorg.app.presentation.auth

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import com.yourorg.app.auth.AuthRepository
import androidx.compose.ui.platform.LocalContext

@Composable
fun SignupScreen(onLogin: () -> Unit, onSignedUp: () -> Unit) {
  val context = LocalContext.current
  val repo = remember { AuthRepository(context) }
  var email by remember { mutableStateOf("") }
  var password by remember { mutableStateOf("") }
  var error by remember { mutableStateOf<String?>(null) }
  val scope = rememberCoroutineScope()

  Column(Modifier.fillMaxSize().padding(16.dp)) {
    Text("Sign Up", style = MaterialTheme.typography.h5)
    Spacer(Modifier.height(8.dp))
    OutlinedTextField(value = email, onValueChange = { email = it }, label={Text("Email")}, modifier=Modifier.fillMaxWidth())
    OutlinedTextField(value = password, onValueChange = { password = it }, label={Text("Password")}, visualTransformation = PasswordVisualTransformation(), modifier=Modifier.fillMaxWidth())
    if (error != null) { Text(error!!, color = MaterialTheme.colors.error) }
    Spacer(Modifier.height(8.dp))
    Button(onClick = {
      scope.launch {
        val res = repo.signUp(email, password)
        if (res.isSuccess) onSignedUp() else error = res.exceptionOrNull()?.message
      }
    }, modifier=Modifier.fillMaxWidth()) { Text("Create account") }
    TextButton(onClick = onLogin) { Text("Have an account? Log in") }
  }
}
