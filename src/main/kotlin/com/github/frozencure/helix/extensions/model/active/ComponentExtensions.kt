package com.github.frozencure.helix.extensions.model.active

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * An object that represents the collection of component extensions for a channel.
 * A maximum of 2 component extensions can be enabled for a channel.
 * @constructor Creates a new component extensions object.
 * @param firstExtension The first component extension.
 * @param secondExtension The second component extension.
 */
@Serializable
data class ComponentExtensions(
    @SerialName("1")
    val firstExtension: ComponentExtension,
    @SerialName("2")
    val secondExtension: ComponentExtension
)