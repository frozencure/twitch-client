package helix.extensions.model


import helix.http.model.AbstractResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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
    val type: List<ExtensionType>
) : AbstractResource()