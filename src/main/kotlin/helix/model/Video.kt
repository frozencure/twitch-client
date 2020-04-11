package helix.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Video(
    @SerialName("id")
    val id: String,
    @SerialName("user_id")
    val userId: String,
    @SerialName("user_name")
    val userName: String,
    @SerialName("title")
    val title: String,
    @SerialName("description")
    val description: String,
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("published_at")
    val publishedAt: String,
    @SerialName("url")
    val url: String,
    @SerialName("thumbnail_url")
    val thumbnailUrl: String,
    @SerialName("viewable")
    val viewable: String,
    @SerialName("view_count")
    val viewCount: Int,
    @SerialName("language")
    val language: String,
    @SerialName("type")
    val type: String,
    @SerialName("duration")
    val duration: String
)