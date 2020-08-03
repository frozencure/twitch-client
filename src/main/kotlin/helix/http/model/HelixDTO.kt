package helix.http.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HelixDTO<T : AbstractResource>(
    @SerialName("data")
    val resources: Collection<T>? = emptyList(),
    @SerialName("pagination")
    val pagination: Pagination? = null,
    @SerialName("total")
    val total: Long? = null,
    @SerialName("date_range")
    val dateRange: DateRange? = null
)