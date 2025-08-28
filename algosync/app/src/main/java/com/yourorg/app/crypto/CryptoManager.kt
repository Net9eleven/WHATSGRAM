package com.yourorg.app.crypto

object CryptoManager {
  var myId: String = "me"
  fun encryptMessageForChat(chatId: String, plaintext: String): ByteArray {
    return plaintext.toByteArray(Charsets.UTF_8) // placeholder; replace with Signal
  }
  fun decryptMessageForChat(chatId: String, ciphertext: ByteArray): String {
    return String(ciphertext, Charsets.UTF_8)
  }
}
