package helix.channels.model.commercial

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CommercialRequest(
    @SerialName("broadcaster_id")
    val broadcasterId: Long,
    @SerialName("length")
    val length: Int
)