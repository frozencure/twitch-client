package helix.streams.markers.model

import helix.streams.markers.model.StreamMarker
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VideoMarkers(
    @SerialName("video_id")
    val videoId: Long,
    @SerialName("markers")
    val markers: Collection<StreamMarker>
)