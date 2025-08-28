package com.yourorg.app.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ChatDao {
  @Query("SELECT * FROM chats ORDER BY updatedAt DESC")
  fun observeChats(): Flow<List<ChatEntity>>

  @Insert
  suspend fun insert(chat: ChatEntity)
}

@Dao
interface MessageDao {
  @Query("SELECT * FROM messages WHERE chatId = :chatId ORDER BY createdAt DESC")
  fun observeMessagesInChat(chatId: String): Flow<List<MessageEntity>>

  @Insert
  suspend fun insert(message: MessageEntity)

  @Query("UPDATE messages SET pending = :pending WHERE id = :id")
  suspend fun setPending(id: String, pending: Boolean)

  @Query("UPDATE messages SET id = :newId WHERE id = :oldId")
  suspend fun updateId(oldId: String, newId: String)

  @Query("SELECT * FROM messages WHERE pending = 1 ORDER BY createdAt ASC")
  suspend fun getAllPendingOnce(): List<MessageEntity>

  @Query("DELETE FROM messages WHERE id = :id")
  suspend fun deleteById(id: String)
}
