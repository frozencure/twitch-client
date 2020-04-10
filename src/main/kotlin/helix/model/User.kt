package helix.model

import helix.generic.AbstractResource
import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: String,
    val login: String,
    val display_name: String,
    val type: String,
    val broadcaster_type: String,
    val description: String,
    val profile_image_url: String,
    val offline_image_url: String,
    val view_count: Long
) : AbstractResource()