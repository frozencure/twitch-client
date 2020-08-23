package com.github.frozencure.helix.streams.markers.model

import com.github.frozencure.helix.http.model.AbstractResource
import com.github.frozencure.helix.shared.InstantSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.Instant


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