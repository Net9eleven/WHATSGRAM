package com.yourorg.app.data.remote

import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.gotrue.gotrue
import io.github.jan.supabase.storage.storage
import io.github.jan.supabase.realtime.realtime

object SupabaseClientProvider {
    private const val SUPABASE_URL = https://qdsuwpchqyigzetxsapu.supabase.co
    private const val SUPABASE_KEY = eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InFkc3V3cGNocXlpZ3pldHhzYXB1Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3NTYxMTY4NDksImV4cCI6MjA3MTY5Mjg0OX0.7O2X6Y6evzMyAy42qbf4-lRQMMaUAXLgLZEj9VCuuk4

    val client = createSupabaseClient(
        supabaseUrl = SUPABASE_URL,
        supabaseKey = SUPABASE_KEY
    ) {
        install(io.github.jan.supabase.gotrue.Auth) { }
        install(io.github.jan.supabase.postgrest.Postgrest)
        install(io.github.jan.supabase.storage.Storage)
        install(io.github.jan.supabase.realtime.Realtime)
    }
}
