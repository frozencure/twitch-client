package helix.clips.model


import helix.http.model.AbstractResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data transfer object for a clip creation.
 * One-to-one mapping to the Twitch clip creation JSON object.
 * @constructor Creates a new creation clip object.
 * @param id The ID of the created clip.
 * @param editUrl The URL where the clip can be edited.
 */
@Serializable
data class ClipCreation(
    @SerialName("id")
    val id: String,
    @SerialName("edit_url")
    val editUrl: String
) : AbstractResource()