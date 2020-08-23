package com.github.frozencure.helix.channels.model.commercial

import com.github.frozencure.helix.http.model.AbstractResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data transfer object for a channel commercial.
 * One-to-one mapping to the Twitch commercial JSON object.
 * @constructor Creates a new channel commercial object.
 * @param length The length of the commercial in seconds.
 * @param message Provides contextual information on why the request failed.
 * @param retryAfter Seconds until the next commercial can be served on this channel.
 */
@Serializable
data class Commercial(
    @SerialName("length")
    val length: Int,
    @SerialName("message")
    val message: String,
    @SerialName("retry_after")
    val retryAfter: Int
) : AbstractResource()