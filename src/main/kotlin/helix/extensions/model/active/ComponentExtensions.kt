package helix.extensions.model.active

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ComponentExtensions(
    @SerialName("1")
    val firstExtension: ComponentExtension,
    @SerialName("2")
    val secondExtension: ComponentExtension
)