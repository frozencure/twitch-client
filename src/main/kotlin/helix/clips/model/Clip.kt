package helix.clips.model


import helix.util.DateSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.util.*

@Serializable
data class Clip(
    @SerialName("broadcaster_id")
    val broadcasterId: String,
    @SerialName("broadcaster_name")
    val broadcasterName: String,
    @SerialName("created_at")
    @Serializable(with = DateSerializer::class)
    val createdAt: Date,
    @SerialName("creator_id")
    val creatorId: String,
    @SerialName("creator_name")
    val creatorName: String,
    @SerialName("embed_url")
    val embedUrl: String,
    @SerialName("game_id")
    val gameId: String,
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
)