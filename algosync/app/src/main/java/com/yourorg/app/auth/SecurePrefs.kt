package com.yourorg.app.auth

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey

class SecurePrefs(context: Context) {
  private val masterKey = MasterKey.Builder(context).setKeyScheme(MasterKey.KeyScheme.AES256_GCM).build()
  private val prefs = EncryptedSharedPreferences.create(
    context, "secure_prefs", masterKey,
    EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
    EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
  )
  fun putString(key: String, value: String) = prefs.edit().putString(key, value).apply()
  fun getString(key: String, default: String? = null): String? = prefs.getString(key, default)
  fun remove(key: String) = prefs.edit().remove(key).apply()
}
