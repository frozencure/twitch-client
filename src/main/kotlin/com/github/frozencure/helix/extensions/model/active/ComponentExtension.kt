package com.github.frozencure.helix.extensions.model.active

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * An object that represents a component extension, that is displayed as part of the video on Twitch.
 * @constructor Creates a new component extension object.
 * @param isActive Whether the extension is active or not.
 * @param id The identifier of the extension.
 * @param version The extension version.
 * @param name The name of the extension.
 * @param x The X position of the extension inside the video player.
 * @param y The Y position of the extension inside the video player.
 */
@Serializable
data class ComponentExtension(
    @SerialName("active")
    val isActive: Boolean,
    @SerialName("id")
    val id: String? = null,
    @SerialName("version")
    val version: String? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("x")
    val x: Int? = null,
    @SerialName("y")
    val y: Int? = null
)