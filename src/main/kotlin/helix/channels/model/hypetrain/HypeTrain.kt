package helix.channels.model.hypetrain


import helix.http.model.AbstractResource
import helix.shared.InstantSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.Instant

/**
 * Data transfer object for a hype train.
 * One-to-one mapping to the Twitch hype train JSON object.
 * @constructor Creates a new hype train object.
 * @param id The distinct ID of the hype train event.
 * @param eventType The type of hype train event.
 * @param eventTimestamp The timestamp of the event.
 * @param version The version of the endpoint.
 * @param eventData The data of the hype train event.
 */
@Serializable
data class HypeTrain(
    @SerialName("id")
    val id: String,
    @SerialName("event_type")
    val eventType: HypeTrainType,
    @SerialName("event_timestamp")
    @Serializable(with = InstantSerializer::class)
    val eventTimestamp: Instant,
    @SerialName("version")
    val version: String,
    @SerialName("event_data")
    val eventData: HypeTrainData
) : AbstractResource()