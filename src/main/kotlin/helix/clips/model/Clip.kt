package helix.clips.model


import helix.http.model.AbstractResource
import helix.shared.InstantSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.Instant

/**
 * Data transfer object for a clip.
 * One-to-one mapping to the Twitch clip JSON object.
 * @constructor Creates a new clip object.
 * @param broadcasterId The ID of the user that owns the broadcast from which the clip was created.
 * @param broadcasterName The name of user that owns the broadcast from which the clip was created.
 * @param createdAt The timestamp of when the clip was created.
 * @param creatorId The ID of the user that created the clip.
 * @param creatorName The name of the user that created the clip.
 * @param embedUrl URL that can be used to embed the clip inside a web page.
 * @param gameId The ID of the game that was being played when the clip was created.
 * @param title The title of the clip.
 * @param url The URL where the clip can be viewed.
 * @param videoId ID of the video from which the clip was created.
 * @param viewCount Number of times the clip has been viewed.
 */
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