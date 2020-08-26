package com.github.frozencure.helix.extensions.model


import com.github.frozencure.helix.http.model.AbstractResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data transfer object for an extension.
 * One-to-one mapping to the Twitch extension JSON object.
 * @constructor Creates a new extension object.
 * @param id The identifier of the extension.
 * @param version The version of the extension.
 * @param name The name of the extension.
 * @param canActivate Indicates whether the extension is configured such that it can be activated.
 * @param types Types for which the extension can be activated.
 */
@Serializable
data class Extension(
    @SerialName("id")
    val id: String,
    @SerialName("version")
    val version: String,
    @SerialName("name")
    val name: String,
    @SerialName("can_activate")
    val canActivate: Boolean,
    @SerialName("type")
    val types: List<ExtensionType>
) : AbstractResource()