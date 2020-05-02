package helix.http.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HelixDTO<T : AbstractResource>(
    val data: Collection<T>,
    val pagination: Pagination? = null,
    @SerialName("total")
    val total: Long? = null
)