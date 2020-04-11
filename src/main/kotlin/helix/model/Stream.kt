package helix.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Stream(
    @SerialName("game_id")
    val gameId: String, // 516575
    @SerialName("id")
    val id: String, // 37461209856
    @SerialName("language")
    val language: String, // en
    @SerialName("started_at")
    val startedAt: String, // 2020-04-10T08:24:06Z
    @SerialName("tag_ids")
    val tagIds: List<String>,
    @SerialName("thumbnail_url")
    val thumbnailUrl: String, // https://static-cdn.jtvnw.net/previews-ttv/live_user_xqcow-{width}x{height}.jpg
    @SerialName("title")
    val title: String, // 🔴VALORANT BETA DROPS HERE 🔴 HIGH % CHANCE HERE
    @SerialName("type")
    val type: String, // live
    @SerialName("user_id")
    val userId: String, // 71092938
    @SerialName("user_name")
    val userName: String, // xQcOW
    @SerialName("viewer_count")
    val viewerCount: Int // 191865
)