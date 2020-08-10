package helix.extensions.model.active

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PanelExtensions(
    @SerialName("1")
    val firstExtension: ActiveExtension,
    @SerialName("2")
    val secondExtension: ActiveExtension,
    @SerialName("3")
    val thirdExtension: ActiveExtension
)
