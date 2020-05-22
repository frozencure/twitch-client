package helix.streams.metadata.model.overwatch

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OverwatchBroadcaster(
    @SerialName("hero")
    val hero: OverwatchHero
)