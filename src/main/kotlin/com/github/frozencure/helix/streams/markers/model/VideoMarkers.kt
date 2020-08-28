package com.github.frozencure.helix.streams.markers.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


/**
 * A collection of stream markers that belong to a video (VOD).
 * @constructor Creates a new video markers object.
 * @param videoId The identifier of the video (VOD).
 * @param markers The collection of stream markers.
 */
@Serializable
data class VideoMarkers(
    @SerialName("video_id")
    val videoId: Long,
    @SerialName("markers")
    val markers: Collection<StreamMarker>
)