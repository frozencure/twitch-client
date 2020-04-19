package helix.model


import helix.generic.AbstractResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FollowEvent(
    @SerialName("from_id")
    val fromUserId: String,
    @SerialName("from_name")
    val fromUserName: String,
    @SerialName("to_id")
    val toUserId: String,
    @SerialName("to_name")
    val toUserName: String,
    @SerialName("followed_at")
    val followedAt: String
) : AbstractResource()