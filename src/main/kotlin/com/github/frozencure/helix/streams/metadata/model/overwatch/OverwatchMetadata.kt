package com.github.frozencure.helix.streams.metadata.model.overwatch

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OverwatchMetadata(
    @SerialName("broadcaster")
    val broadcaster: OverwatchBroadcaster
)
