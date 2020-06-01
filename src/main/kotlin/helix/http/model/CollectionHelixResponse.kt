package helix.http.model

import io.ktor.client.statement.HttpResponse

abstract class CollectionHelixResponse<T : AbstractResource>(
    httpResponse: HttpResponse
) :
    HelixResponse<T>(httpResponse) {

    val resources: Collection<T>
        get() = helixDTO.resources

    val pagination: Pagination?
        get() = helixDTO.pagination

    val total: Long?
        get() = helixDTO.total

    val dateRange: DateRange?
        get() = helixDTO.dateRange

}