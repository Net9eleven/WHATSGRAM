package com.yourorg.app.crypto.signal

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "signal_identity")
data class SignalIdentityEntity(
    @PrimaryKey val userId: String,
    val identityKeyPairBase64: String,
    val registrationId: Int
)

@Entity(tableName = "signal_prekeys")
data class SignalPreKeyEntity(
    @PrimaryKey val preKeyId: Int,
    val userId: String,
    val recordBase64: String
)

@Entity(tableName = "signal_signed_prekeys")
data class SignalSignedPreKeyEntity(
    @PrimaryKey val signedPreKeyId: Int,
    val userId: String,
    val recordBase64: String
)

@Entity(tableName = "signal_sessions")
data class SignalSessionEntity(
    @PrimaryKey val sessionId: String,
    val userId: String,
    val remoteName: String,
    val deviceId: Int,
    val recordBase64: String
)
