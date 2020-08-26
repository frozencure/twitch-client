package com.github.frozencure.helix.extensions.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Enum that holds the values of all the possible types of Twitch extensions.
 */
@Serializable
enum class ExtensionType {
    @SerialName("component")
    COMPONENT,

    @SerialName("mobile")
    MOBILE,

    @SerialName("panel")
    PANEL,

    @SerialName("overlay")
    OVERLAY
}