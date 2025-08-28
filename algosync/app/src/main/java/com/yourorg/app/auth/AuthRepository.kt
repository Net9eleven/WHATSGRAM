package com.yourorg.app.auth

import android.content.Context
import io.github.jan.supabase.gotrue.gotrue
import io.github.jan.supabase.gotrue.user.UserInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.yourorg.app.data.remote.SupabaseClientProvider

class AuthRepository(context: Context) {
  private val auth = SupabaseClientProvider.client.gotrue
  private val prefs = SecurePrefs(context)

  companion object {
    const val KEY_USER_ID = "user_id"
  }

  suspend fun signUp(email: String, password: String): Result<String> = withContext(Dispatchers.IO) {
    try {
      auth.signUpWith(io.github.jan.supabase.gotrue.providers.email.Email) { this.email = email; this.password = password }
      val user: UserInfo = auth.retrieveUserForCurrentSession()
      prefs.putString(KEY_USER_ID, user.id)
      Result.success(user.id)
    } catch (e: Exception) { Result.failure(e) }
  }

  suspend fun signIn(email: String, password: String): Result<String> = withContext(Dispatchers.IO) {
    try {
      auth.loginWith(io.github.jan.supabase.gotrue.providers.email.Email) { this.email = email; this.password = password }
      val user: UserInfo = auth.retrieveUserForCurrentSession()
      prefs.putString(KEY_USER_ID, user.id)
      Result.success(user.id)
    } catch (e: Exception) { Result.failure(e) }
  }

  fun getStoredUserId(): String? = prefs.getString(KEY_USER_ID)
}
