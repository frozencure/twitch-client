package helix.generic

import kotlinx.serialization.Serializable

@Serializable
data class HelixResponse<T : AbstractResource>(
    val data: Collection<T>,
    val pagination: Pagination? = null
)