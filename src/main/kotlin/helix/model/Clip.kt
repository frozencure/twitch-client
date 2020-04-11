package helix.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Clip(
    @SerialName("broadcaster_id")
    val broadcasterId: String, // 67955580
    @SerialName("broadcaster_name")
    val broadcasterName: String, // ChewieMelodies
    @SerialName("created_at")
    val createdAt: String, // 2017-11-30T22:34:18Z
    @SerialName("creator_id")
    val creatorId: String, // 53834192
    @SerialName("creator_name")
    val creatorName: String, // BlackNova03
    @SerialName("embed_url")
    val embedUrl: String, // https://clips.twitch.tv/embed?clip=AwkwardHelplessSalamanderSwiftRage
    @SerialName("game_id")
    val gameId: String, // 488191
    @SerialName("id")
    val id: String, // AwkwardHelplessSalamanderSwiftRage
    @SerialName("language")
    val language: String, // en
    @SerialName("thumbnail_url")
    val thumbnailUrl: String, // https://clips-media-assets.twitch.tv/157589949-preview-480x272.jpg
    @SerialName("title")
    val title: String, // babymetal
    @SerialName("url")
    val url: String, // https://clips.twitch.tv/AwkwardHelplessSalamanderSwiftRage
    @SerialName("video_id")
    val videoId: String, // 205586603
    @SerialName("view_count")
    val viewCount: Int // 10
)