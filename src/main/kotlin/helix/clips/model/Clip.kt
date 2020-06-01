package helix.clips.model


import helix.http.model.AbstractResource
import helix.shared.InstantSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.Instant

@Serializable
data class Clip(
    @SerialName("broadcaster_id")
    val broadcasterId: Long,
    @SerialName("broadcaster_name")
    val broadcasterName: String,
    @SerialName("created_at")
    @Serializable(with = InstantSerializer::class)
    val createdAt: Instant,
    @SerialName("creator_id")
    val creatorId: Long,
    @SerialName("creator_name")
    val creatorName: String,
    @SerialName("embed_url")
    val embedUrl: String,
    @SerialName("game_id")
    val gameId: Long,
    @SerialName("id")
    val id: String,
    @SerialName("language")
    val language: String,
    @SerialName("thumbnail_url")
    val thumbnailUrl: String,
    @SerialName("title")
    val title: String,
    @SerialName("url")
    val url: String,
    @SerialName("video_id")
    val videoId: String,
    @SerialName("view_count")
    val viewCount: Int
) : AbstractResource()