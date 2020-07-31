package helix.moderation.model


import helix.shared.NullableInstantSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.Instant

@Serializable
data class ModerationEventData(
    @SerialName("broadcaster_id")
    val broadcasterId: String,
    @SerialName("broadcaster_name")
    val broadcasterName: String,
    @SerialName("user_id")
    val userId: String,
    @SerialName("user_name")
    val userName: String,
    @SerialName("expires_at")
    @Serializable(with = NullableInstantSerializer::class)
    val expiresAt: Instant? = null
)