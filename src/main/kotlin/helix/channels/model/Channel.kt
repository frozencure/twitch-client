package helix.channels.model


import helix.http.model.AbstractResource
import helix.shared.NullableInstantSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.Instant

@Serializable
data class Channel(
    @SerialName("broadcaster_language")
    val broadcasterLanguage: String,
    @SerialName("display_name")
    val displayName: String,
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