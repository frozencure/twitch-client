package helix.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Game(
    @SerialName("id")
    val id: String,
    @SerialName("name")
    val name: String,
    @SerialName("box_art_url")
    val boxArtUrl: String
)