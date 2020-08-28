package com.github.frozencure.helix.streams.markers.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Model class used as payload for the request of the creation of a new stream marker.
 * @constructor Creates a new stream marker request model.
 * @param userId The identifier of the broadcaster in whose live-stream the marker is created.
 * @param description The optional description of the marker.
 */
@Serializable
data class StreamMarkerRequestModel(
    @SerialName("user_id")
    val userId: Long,
    @SerialName("description")
    val description: String? = null
)