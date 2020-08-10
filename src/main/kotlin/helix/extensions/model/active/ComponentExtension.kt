package helix.extensions.model.active

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ComponentExtension(
    @SerialName("active")
    val active: Boolean,
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