package com.github.frozencure.helix.extensions.model.active

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * An object that represents the collection of panel extensions for a channel.
 * A maximum of 3 panel extensions can be enabled for a channel.
 * @constructor Creates a new panel extensions object.
 * @param firstExtension The first panel extension.
 * @param secondExtension The second panel extension.
 * @param thirdExtension The third panel extension.
 */
@Serializable
data class PanelExtensions(
    @SerialName("1")
    val firstExtension: ActiveExtension,
    @SerialName("2")
    val secondExtension: ActiveExtension,
    @SerialName("3")
    val thirdExtension: ActiveExtension
)
