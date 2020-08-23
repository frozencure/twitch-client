package com.github.frozencure.helix.moderation.model

import com.github.frozencure.helix.http.model.AbstractResource
import com.github.frozencure.helix.shared.NullableInstantSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.Instant


@Serializable
data class BannedUser(
    @SerialName("user_id")
    val userId: Long,
    @SerialName("user_name")
    val userName: String,
    @SerialName("expires_at")
    @Serializable(with = NullableInstantSerializer::class)
    val expiresAt: Instant? = null
) : AbstractResource()