package com.github.frozencure.helix.streams.markers.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class VideoMarkers(
    @SerialName("video_id")
    val videoId: Long,
    @SerialName("markers")
    val markers: Collection<StreamMarker>
)