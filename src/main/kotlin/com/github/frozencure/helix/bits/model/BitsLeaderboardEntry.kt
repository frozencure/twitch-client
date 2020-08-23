package com.github.frozencure.helix.bits.model

import com.github.frozencure.helix.http.model.AbstractResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data transfer object for a bits leaderboard entry.
 * One-to-one mapping to the Twitch bits leaderboard entry JSON object.
 * @constructor Creates a new bits leaderboard entry object.
 * @param userId The ID of the user.
 * @param userName The user name of the user.
 * @param rank The rank of the user in the bits leaderboard.
 * @param score The score of the user in the bits leaderboard.
 */
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