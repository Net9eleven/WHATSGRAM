package com.yourorg.app.crypto.signal

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SignalIdentityDao {
    @Query("SELECT * FROM signal_identity WHERE userId = :userId LIMIT 1")
    fun getIdentity(userId: String): SignalIdentityEntity?
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsertIdentity(entity: SignalIdentityEntity)
}

@Dao
interface SignalPreKeyDao {
    @Query("SELECT * FROM signal_prekeys WHERE preKeyId = :preKeyId LIMIT 1")
    fun getPreKey(preKeyId: Int): SignalPreKeyEntity?
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsertPreKey(entity: SignalPreKeyEntity)
    @Query("DELETE FROM signal_prekeys WHERE preKeyId = :preKeyId")
    fun deletePreKey(preKeyId: Int)
}

@Dao
interface SignalSignedPreKeyDao {
    @Query("SELECT * FROM signal_signed_prekeys WHERE signedPreKeyId = :signedPreKeyId LIMIT 1")
    fun getSignedPreKey(signedPreKeyId: Int): SignalSignedPreKeyEntity?
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsertSignedPreKey(entity: SignalSignedPreKeyEntity)
}

@Dao
interface SignalSessionDao {
    @Query("SELECT * FROM signal_sessions WHERE sessionId = :sessionId LIMIT 1")
    fun getSession(sessionId: String): SignalSessionEntity?
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsertSession(entity: SignalSessionEntity)
    @Query("DELETE FROM signal_sessions WHERE sessionId = :sessionId")
    fun deleteSession(sessionId: String)
}
