package com.github.frozencure.helix.streams.markers.model

import com.github.frozencure.helix.http.model.AbstractResource
import com.github.frozencure.helix.shared.InstantSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.Instant

/**
 * Data transfer object for a stream marker.
 * One-to-one mapping to the Twitch stream marker JSON object.
 * @constructor Creates a new stream marker object.
 * @param id The identifier of the stream marker.
 * @param createdAt The moment when the marker was created.
 * @param description The description of the stream marker.
 * @param positionSeconds Relative offset (in seconds) of the marker, from the beginning of the stream.
 * @param url A link to the stream with a query parameter that is a timestamp of the marker’s location.
 */
@Serializable
data class StreamMarker(
    @SerialName("id")
    val id: String,
    @SerialName("created_at")
    @Serializable(with = InstantSerializer::class)
    val createdAt: Instant,
    @SerialName("description")
    val description: String,
    @SerialName("position_seconds")
    val positionSeconds: Long,
    @SerialName("URL")
    val url: String? = null
) : AbstractResource()