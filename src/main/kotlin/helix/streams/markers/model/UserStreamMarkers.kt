package helix.streams.markers.model

import helix.http.model.AbstractResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserStreamMarkers(
    @SerialName("user_id")
    val userId: Long,
    @SerialName("user_name")
    val userLoginName: String,
    @SerialName("videos")
    val videosMarkers: Collection<VideoMarkers>
) : AbstractResource()