package com.github.frozencure.helix.moderation.model


import com.github.frozencure.helix.http.model.AbstractResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AutoModMessageStatus(
    @SerialName("msg_id")
    val messageId: String,
    @SerialName("is_permitted")
    val isPermitted: Boolean
): AbstractResource()