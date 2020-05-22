package helix.streams.metadata.model.hearthstone


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HearthstoneHero(
    @SerialName("type")
    val type: String,
    @SerialName("class")
    val classX: String,
    @SerialName("name")
    val name: String
)