package com.github.frozencure.helix.videos.model

import com.github.frozencure.helix.http.model.AbstractResource
import com.github.frozencure.helix.shared.InstantSerializer
import com.github.frozencure.helix.shared.NullableStringSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.Instant


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
    @Serializable(with = NullableStringSerializer::class)
    val description: String? = null,
    @SerialName("created_at")
    @Serializable(with = InstantSerializer::class)
    val createdAt: Instant,
    @SerialName("published_at")
    @Serializable(with = InstantSerializer::class)
    val publishedAt: Instant,
    @SerialName("url")
    val url: String,
    @SerialName("thumbnail_url")
    val thumbnailUrl: String,
    @SerialName("viewable")
    val viewable: VideoVisibility,
    @SerialName("view_count")
    val viewCount: Int,
    @SerialName("language")
    val language: String,
    @SerialName("type")
    val type: VideoType,
    @SerialName("duration")
    val duration: String
) : AbstractResource()