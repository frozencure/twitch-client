package com.github.frozencure.helix.channels.model.hypetrain

import com.github.frozencure.helix.shared.InstantSerializer

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.Instant

/**
 * An object that holds the data about a hype train event.
 * @constructor Creates a new hype train event data object.
 * @param cooldownEndTime Timestamp of when another Hype Train can be started again.
 * @param expiresAt Expiration timestamp of this hype train event.
 * @param goal The goal value of reaching the next level of the hype train.
 * @param id The ID of the this hype train event.
 * @param lastContribution The most recent contribution.
 * @param level The highest level of the hype train (on a scale of 1-5) reached.
 * @param startedAt Timestamp of when this hype train started.
 * @param topContributions An array of top contribution objects, one object for each type.
 * @param total The total score so far towards reaching the next level of the hype train.
 */

@Serializable
data class HypeTrainData(
    @SerialName("broadcaster_id")
    val broadcasterId: Long,
    @SerialName("cooldown_end_time")
    @Serializable(with = InstantSerializer::class)
    val cooldownEndTime: Instant,
    @SerialName("expires_at")
    @Serializable(with = InstantSerializer::class)
    val expiresAt: Instant,
    @SerialName("goal")
    val goal: Int,
    @SerialName("id")
    val id: String,
    @SerialName("last_contribution")
    val lastContribution: Contribution,
    @SerialName("level")
    val level: Int,
    @SerialName("started_at")
    @Serializable(with = InstantSerializer::class)
    val startedAt: Instant,
    @SerialName("top_contributions")
    val topContributions: List<Contribution>,
    @SerialName("total")
    val total: Int
)