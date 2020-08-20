package helix.channels.model.hypetrain

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Enum that holds the types of Hype Train events.
 */
@Serializable
enum class HypeTrainType {
    @SerialName("hypetrain.progression")
    PROGRESSION
}