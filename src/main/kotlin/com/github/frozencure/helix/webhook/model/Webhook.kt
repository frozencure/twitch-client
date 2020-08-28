package com.github.frozencure.helix.webhook.model


import com.github.frozencure.helix.http.model.AbstractResource
import com.github.frozencure.helix.shared.InstantSerializer

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.Instant

/**
 * Data transfer object for a webhook.
 * One-to-one mapping to the Twitch webhook JSON object.
 * @constructor Creates a new webhook object.
 * @param topic The webhook topic.
 * @param callback The callback provided for this subscription.
 * @param expiresAt The moment when the webhook subscription expires.
 */
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