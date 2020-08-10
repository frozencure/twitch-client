package helix.http.model.array

import helix.http.model.AbstractResource
import io.ktor.client.statement.HttpResponse

abstract class CollectionResponse<T : AbstractResource>(
    httpResponse: HttpResponse
) :
    ArrayHelixResponse<T>(httpResponse) {

    val resources: Collection<T>
        get() = helixArrayDTO.resources.orEmpty()

    val pagination: Pagination?
        get() = helixArrayDTO.pagination

    val total: Long?
        get() = helixArrayDTO.total

    val dateRange: DateRange?
        get() = helixArrayDTO.dateRange

}