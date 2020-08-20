package helix.channels.model.commercial

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Model used for the payload to make a start commercial request.
 * @constructor Creates a new commercial request model.
 * @param broadcasterId The ID of the channel for which the commercial is requested.
 * @param length The length of the commercial in seconds.
 */
@Serializable
data class CommercialRequest(
    @SerialName("broadcaster_id")
    val broadcasterId: Long,
    @SerialName("length")
    val length: Int
)