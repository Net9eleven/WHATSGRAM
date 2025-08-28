package com.yourorg.app.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "chats")
data class ChatEntity(
  @PrimaryKey val id: String,
  val isGroup: Boolean,
  val title: String?,
  val lastMessage: String?,
  val updatedAt: Long
)

@Entity(tableName = "messages")
data class MessageEntity(
  @PrimaryKey val id: String,
  val chatId: String,
  val senderId: String,
  val ciphertext: ByteArray,
  val contentType: String?,
  val mediaPath: String?,
  val createdAt: Long,
  val pending: Boolean = false
)
