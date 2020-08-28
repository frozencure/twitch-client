package com.github.frozencure.helix.streams.model


import com.github.frozencure.helix.http.model.AbstractResource
import com.github.frozencure.helix.shared.InstantSerializer

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.Instant

/**
 * Data transfer object for a stream.
 * One-to-one mapping to the Twitch stream JSON object.
 * @constructor Creates a new stream object.
 * @param gameId The identifier of the game being played.
 * @param id The identifier of the stream.
 * @param language The language of the stream.
 * @param startedAt The moment when the stream was started.
 * @param tagIds The identifier of the tags added to the stream.
 * @param thumbnailUrl The URL where the stream thumbnail can be found.
 * @param title The stream title.
 * @param type The type of the stream. (can be "live" or "" in case of error)
 * @param userId The identifier of the user who is streaming.
 * @param userName The name of the user who is streaming.
 * @param viewerCount The number of viewers currently watching the stream.
 */
@Serializable
data class Stream(
    @SerialName("game_id")
    val gameId: String,
    @SerialName("id")
    val id: Long,
    @SerialName("language")
    val language: String,
    @SerialName("started_at")
    @Serializable(with = InstantSerializer::class)
    val startedAt: Instant,
    @SerialName("tag_ids")
    val tagIds: List<String>,
    @SerialName("thumbnail_url")
    val thumbnailUrl: String,
    @SerialName("title")
    val title: String,
    @SerialName("type")
    val type: String,
    @SerialName("user_id")
    val userId: Long,
    @SerialName("user_name")
    val userName: String,
    @SerialName("viewer_count")
    val viewerCount: Int
) : AbstractResource()