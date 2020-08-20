package helix.channels.model


import helix.http.model.AbstractResource
import helix.shared.NullableInstantSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.Instant

/**
 * Data transfer object for a channel.
 * One-to-one mapping to the Twitch channel JSON object.
 * @constructor Creates a new channel object.
 * @param broadcasterLanguage The language of the channel.
 * @param broadcasterDisplayName The display name of the user who owns the channel.
 * @param gameId ID of the game being played on the stream.
 * @param id The channel id.
 * @param isLive Live status of the channel.
 * @param tagsIds The tag IDs that apply to the stream.
 * @param thumbnailUrl The channel thumbnail.
 * @param title The channel title.
 * @param startedAt Timestamp of when the current stream has been started. (only when channel is live)
 */
@Serializable
data class Channel(
    @SerialName("broadcaster_language")
    val broadcasterLanguage: String,
    @SerialName("display_name")
    val broadcasterDisplayName: String,
    @SerialName("game_id")
    val gameId: String,
    @SerialName("id")
    val id: Long,
    @SerialName("is_live")
    val isLive: Boolean,
    @SerialName("tag_ids")
    val tagsIds: Collection<String>,
    @SerialName("thumbnail_url")
    val thumbnailUrl: String,
    @SerialName("title")
    val title: String,
    @SerialName("started_at")
    @Serializable(with = NullableInstantSerializer::class)
    val startedAt: Instant? = null
) : AbstractResource()