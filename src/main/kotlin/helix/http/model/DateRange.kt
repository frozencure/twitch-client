package helix.http.model


import helix.shared.NullableInstantSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.Instant

@Serializable
data class DateRange(
    @SerialName("started_at")
    @Serializable(with = NullableInstantSerializer::class)
    val startedAt: Instant? = null,
    @SerialName("ended_at")
    @Serializable(with = NullableInstantSerializer::class)
    val endedAt: Instant? = null
)