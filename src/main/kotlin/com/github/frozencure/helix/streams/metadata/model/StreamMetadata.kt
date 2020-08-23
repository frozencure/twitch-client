package com.github.frozencure.helix.streams.metadata.model


import com.github.frozencure.helix.http.model.AbstractResource
import com.github.frozencure.helix.streams.metadata.model.hearthstone.HearthstoneMetadata
import com.github.frozencure.helix.streams.metadata.model.overwatch.OverwatchMetadata
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StreamMetadata(
    @SerialName("user_id")
    val userId: Long,
    @SerialName("user_name")
    val userName: String,
    @SerialName("game_id")
    val gameId: String? = null,
    @SerialName("overwatch")
    val overwatchMetadata: OverwatchMetadata? = null,
    @SerialName("hearthstone")
    val hearthstoneMetadata: HearthstoneMetadata? = null
) : AbstractResource()