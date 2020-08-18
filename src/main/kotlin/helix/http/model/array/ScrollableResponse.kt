package helix.http.model.array

import helix.http.model.AbstractResource
import io.ktor.client.HttpClient
import io.ktor.client.request.headers
import io.ktor.client.request.parameter
import io.ktor.client.request.request
import io.ktor.client.request.url
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.request

abstract class ScrollableResponse<T : AbstractResource>(
    httpResponse: HttpResponse,
    protected val httpClient: HttpClient
) :
    CollectionResponse<T>(httpResponse) {

    protected suspend fun nextPageHttpResponse(cursorKey: String? = null): HttpResponse? =
        pagination?.let {
            httpClient.request<HttpResponse> {
                url(httpResponse.request.url)
                parameter(cursorKey ?: it.asPair().first, it.asPair().second)
                headers { httpResponse.request.headers }
                method = httpResponse.request.method
            }
        }

    /**
     * When a collection has more than a certain number of elements, it will be split into multiple pages.
     * If the collection response has multiple pages, a cursor will be used to access the next page.
     * @return The next part of the collection, if the current response has a cursor.
     */
    abstract suspend fun nextPage(): CollectionResponse<T>?

}