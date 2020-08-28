package com.github.frozencure.helix.streams.markers.model

import com.github.frozencure.helix.http.model.AbstractResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data transfer object for a collection of stream markers that belong to a user.
 * One-to-one mapping to the Twitch user stream markers JSON object.
 * @constructor Creates a new user stream markers object.
 * @param userId The identifier of the user for which the stream markers will be retrieved.
 * @param userName The user name of the user for which the stream markers will be retrieved.
 * @param videosMarkers The collection of video stream markers.
 */
@Serializable
data class UserStreamMarkers(
    @SerialName("user_id")
    val userId: Long,
    @SerialName("user_name")
    val userName: String,
    @SerialName("videos")
    val videosMarkers: Collection<VideoMarkers>
) : AbstractResource()