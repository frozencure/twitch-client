package com.github.frozencure.helix.streams.markers.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StreamMarkerRequest(
    @SerialName("user_id")
    val userId: Long,
    @SerialName("description")
    val description: String? = null
)