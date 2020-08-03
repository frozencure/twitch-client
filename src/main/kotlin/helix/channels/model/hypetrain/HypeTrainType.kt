package helix.channels.model.hypetrain

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class HypeTrainType {
    @SerialName("hypetrain.progression")
    PROGRESSION
}