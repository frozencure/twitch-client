package helix.channels.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ModifyChannelBody(
    @SerialName("game_id")
    val gameId: String? = null,
    @SerialName("title")
    val title: String? = null,
    @SerialName("broadcaster_language")
    val broadcasterLanguage: String? = null
)