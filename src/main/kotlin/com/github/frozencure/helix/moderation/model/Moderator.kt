package com.github.frozencure.helix.moderation.model

import com.github.frozencure.helix.http.model.AbstractResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Moderator(
    @SerialName("user_id")
    val userId: Long,
    @SerialName("user_name")
    val userName: String
) : AbstractResource()