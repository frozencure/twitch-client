package com.github.frozencure.helix.extensions.model.active

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OverlayExtensions(
    @SerialName("1")
    val firstExtension: ActiveExtension
)