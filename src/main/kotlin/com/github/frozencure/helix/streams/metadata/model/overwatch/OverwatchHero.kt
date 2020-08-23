package com.github.frozencure.helix.streams.metadata.model.overwatch


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OverwatchHero(
    @SerialName("role")
    val role: String,
    @SerialName("name")
    val name: String,
    @SerialName("ability")
    val ability: String
)