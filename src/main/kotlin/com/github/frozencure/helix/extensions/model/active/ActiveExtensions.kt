package com.github.frozencure.helix.extensions.model.active

import com.github.frozencure.helix.http.model.AbstractResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data transfer object for a structured collection active extensions.
 * One-to-one mapping to the Twitch active extensions JSON object.
 * @constructor Creates a new active extensions object.
 * @param panelExtensions The collection of panel extensions.
 * @param overlayExtensions The collection of overlay extensions.
 * @param componentExtension The collection of component extensions.
 */
@Serializable
data class ActiveExtensions(
    @SerialName("panel")
    val panelExtensions: PanelExtensions,
    @SerialName("overlay")
    val overlayExtensions: OverlayExtensions,
    @SerialName("component")
    val componentExtension: ComponentExtensions
) : AbstractResource()