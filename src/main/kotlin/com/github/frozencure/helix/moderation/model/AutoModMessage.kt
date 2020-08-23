package com.github.frozencure.helix.moderation.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AutoModMessage(
    @SerialName("msg_id")
    val messageId: String,
    @SerialName("msg_text")
    val messageText: String,
    @SerialName("user_id")
    val userId: Long
)