package com.github.frozencure.helix.extensions.model.active


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * An object that represents the status of a user extension.
 * @constructor Creates a new active extension object.
 * @param isActive Whether the extension is active or not.
 * @param id The identifier of the extension.
 * @param version The extension version.
 * @param name The name of the extension.
 */
@Serializable
class ActiveExtension(
    @SerialName("active")
    val isActive: Boolean,
    @SerialName("id")
    val id: String? = null,
    @SerialName("version")
    val version: String? = null,
    @SerialName("name")
    val name: String? = null
)