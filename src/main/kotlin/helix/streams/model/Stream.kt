package helix.streams.model


import helix.util.DateSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.util.*

@Serializable
data class Stream(
    @SerialName("game_id")
    val gameId: String,
    @SerialName("id")
    val id: String,
    @SerialName("language")
    val language: String,
    @SerialName("started_at")
    @Serializable(with = DateSerializer::class)
    val startedAt: Date,
    @SerialName("tag_ids")
    val tagIds: List<String>,
    @SerialName("thumbnail_url")
    val thumbnailUrl: String,
    @SerialName("title")
    val title: String,
    @SerialName("type")
    val type: String,
    @SerialName("user_id")
    val userId: String,
    @SerialName("user_name")
    val userName: String,
    @SerialName("viewer_count")
    val viewerCount: Int
)