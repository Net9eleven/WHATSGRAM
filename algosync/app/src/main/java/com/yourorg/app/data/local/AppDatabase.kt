package com.yourorg.app.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yourorg.app.crypto.signal.*

@Database(entities = [ChatEntity::class, MessageEntity::class,
                      SignalIdentityEntity::class, SignalPreKeyEntity::class,
                      SignalSignedPreKeyEntity::class, SignalSessionEntity::class],
          version = 1)
abstract class AppDatabase : RoomDatabase() {
  abstract fun chatDao(): ChatDao
  abstract fun messageDao(): MessageDao
  abstract fun signalIdentityDao(): SignalIdentityDao
  abstract fun signalPreKeyDao(): SignalPreKeyDao
  abstract fun signalSignedPreKeyDao(): SignalSignedPreKeyDao
  abstract fun signalSessionDao(): SignalSessionDao
}
