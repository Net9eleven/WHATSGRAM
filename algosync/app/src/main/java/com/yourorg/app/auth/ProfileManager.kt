package com.yourorg.app.auth

import com.yourorg.app.data.remote.SupabaseClientProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProfileManager {
  private val postgrest = SupabaseClientProvider.client.postgrest
  suspend fun createProfile(userId: String, username: String, displayName: String?, avatarUrl: String?) {
    withContext(Dispatchers.IO) {
      postgrest["profiles"].insert(
        mapOf("id" to userId, "username" to username, "display_name" to displayName, "avatar_url" to avatarUrl)
      )
    }
  }
}
