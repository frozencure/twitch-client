package com.github.frozencure.helix.webhook.model


import com.github.frozencure.helix.http.model.AbstractResource
import com.github.frozencure.helix.shared.InstantSerializer

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.Instant


@Serializable
data class Webhook(
    @SerialName("topic")
    val topic: String,
    @SerialName("callback")
    val callback: String,
    @SerialName("expires_at")
    @Serializable(with = InstantSerializer::class)
    val expiresAt: Instant
) : AbstractResource()