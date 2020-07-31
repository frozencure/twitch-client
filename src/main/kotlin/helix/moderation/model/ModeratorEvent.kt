package helix.moderation.model


import helix.http.model.AbstractResource
import helix.shared.InstantSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.Instant

@Serializable
data class ModeratorEvent(
    @SerialName("id")
    val id: String,
    @SerialName("event_type")
    val eventType: ModeratorEventType,
    @SerialName("event_timestamp")
    @Serializable(with = InstantSerializer::class)
    val eventTimestamp: Instant,
    @SerialName("version")
    val version: String,
    @SerialName("event_data")
    val eventData: ModerationEventData
) : AbstractResource()