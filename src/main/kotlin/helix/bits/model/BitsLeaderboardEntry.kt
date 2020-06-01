package helix.bits.model


import helix.http.model.AbstractResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BitsLeaderboardEntry(
    @SerialName("user_id")
    val userId: String,
    @SerialName("user_name")
    val userName: String,
    @SerialName("rank")
    val rank: Int,
    @SerialName("score")
    val score: Int
) : AbstractResource()