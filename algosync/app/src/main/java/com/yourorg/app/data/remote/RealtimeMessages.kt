package com.yourorg.app.data.remote

import io.github.jan.supabase.realtime.realtime
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow

object RealtimeMessages {
  private val _events = MutableSharedFlow<Map<String, Any>>(replay = 0)
  val events: SharedFlow<Map<String, Any>> get() = _events

  suspend fun subscribeToChat(chatId: String) {
    val channel = SupabaseClientProvider.client.realtime.channel("realtime:public:messages")
    // Add subscription logic (insert/update)
    channel.subscribe()
  }
}
