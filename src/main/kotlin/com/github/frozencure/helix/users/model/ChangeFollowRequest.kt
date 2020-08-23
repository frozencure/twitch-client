package com.github.frozencure.helix.users.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ChangeFollowRequest(
    @SerialName("from_id")
    val fromId: Long,
    @SerialName("to_id")
    val toId: Long,
    @SerialName("allow_notifications")
    val allowNotifications: Boolean? = null
)