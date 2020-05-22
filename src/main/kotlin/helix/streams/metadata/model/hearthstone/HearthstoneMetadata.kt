package helix.streams.metadata.model.hearthstone

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HearthstoneMetadata(
    @SerialName("broadcaster")
    val broadcaster: HearthstoneBroadcaster,
    @SerialName("opponent")
    val opponent: HearthstoneBroadcaster
)