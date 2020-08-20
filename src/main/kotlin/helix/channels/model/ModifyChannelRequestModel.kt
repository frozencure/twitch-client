package helix.channels.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Model used for the payload when requesting a modification of the channel information.
 * @constructor Creates a new channel modify request model.
 * @param title The title of the stream.
 * @param gameId The current game ID played on the channel.
 * @param language The language of the channel.
 */
@Serializable
data class ModifyChannelRequestModel(
    @SerialName("game_id")
    val gameId: String? = null,
    @SerialName("title")
    val title: String? = null,
    @SerialName("broadcaster_language")
    val language: String? = null
)