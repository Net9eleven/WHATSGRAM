package com.yourorg.app.presentation.nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yourorg.app.presentation.auth.LoginScreen
import com.yourorg.app.presentation.auth.SignupScreen
import com.yourorg.app.presentation.profile.ProfileScreen
import com.yourorg.app.presentation.chat.ChatScreen
import com.yourorg.app.presentation.feed.FeedScreen

@Composable
fun AppNavHost() {
  val nav = rememberNavController()
  NavHost(navController = nav, startDestination = "login") {
    composable("login") { LoginScreen(onSignup = { nav.navigate("signup") }, onLoggedIn = { nav.navigate("feed") }) }
    composable("signup") { SignupScreen(onLogin = { nav.popBackStack() }, onSignedUp = { nav.navigate("feed") }) }
    composable("profile") { ProfileScreen(onDone = { nav.navigate("feed") }) }
    composable("chat") { ChatScreen(chatId = "demo-chat") }
    composable("feed") { FeedScreen() }
  }
}
