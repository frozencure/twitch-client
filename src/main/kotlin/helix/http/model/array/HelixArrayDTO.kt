package helix.http.model.array

import helix.http.model.AbstractResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HelixArrayDTO<T : AbstractResource>(
    @SerialName("data")
    val resources: Collection<T>? = emptyList(),
    @SerialName("pagination")
    val pagination: Pagination? = null,
    @SerialName("total")
    val total: Long? = null,
    @SerialName("date_range")
    val dateRange: DateRange? = null
)