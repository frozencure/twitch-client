package helix.streams.metadata.model.hearthstone

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HearthstoneBroadcaster(
    @SerialName("hero")
    val hero: HearthstoneHero
)