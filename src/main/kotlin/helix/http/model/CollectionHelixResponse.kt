package helix.http.model

import io.ktor.client.statement.HttpResponse

abstract class CollectionHelixResponse<T : AbstractResource>(
    httpResponse: HttpResponse
) :
    HelixResponse<T>(httpResponse) {

    val data: Collection<T>
        get() = helixDTO.data

    val pagination: Pagination?
        get() = helixDTO.pagination

    val total: Long?
        get() = helixDTO.total

}