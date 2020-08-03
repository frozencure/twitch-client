package helix.channels.model.hypetrain


import helix.shared.InstantSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.Instant

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