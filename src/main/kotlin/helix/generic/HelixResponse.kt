package helix.generic

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HelixResponse<T : AbstractResource>(
    val data: Collection<T>,
    val pagination: Pagination? = null,
    @SerialName("total")
    val total: Long? = null
)