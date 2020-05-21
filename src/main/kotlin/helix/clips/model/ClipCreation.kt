package helix.clips.model


import helix.http.model.AbstractResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ClipCreation(
    @SerialName("id")
    val id: String,
    @SerialName("edit_url")
    val editUrl: String
) : AbstractResource()