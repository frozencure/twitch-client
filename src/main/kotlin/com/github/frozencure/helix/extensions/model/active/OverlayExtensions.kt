package com.github.frozencure.helix.extensions.model.active

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * An object that represents the collection of overlay extensions for a channel.
 * A maximum of 1 overlay extensions can be enabled for a channel.
 * @constructor Creates a new overlay extensions object.
 * @param firstExtension The first overlay extension.
 */
@Serializable
data class OverlayExtensions(
    @SerialName("1")
    val firstExtension: ActiveExtension
)