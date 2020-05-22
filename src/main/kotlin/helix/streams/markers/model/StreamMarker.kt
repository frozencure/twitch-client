package helix.streams.markers.model


import helix.http.model.AbstractResource
import helix.util.InstantSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.Instant

@Serializable
data class StreamMarker(
    @SerialName("id")
    val id: Long,
    @SerialName("created_at")
    @Serializable(with = InstantSerializer::class)
    val createdAt: Instant,
    @SerialName("description")
    val description: String,
    @SerialName("position_seconds")
    val positionSeconds: Long
) : AbstractResource()