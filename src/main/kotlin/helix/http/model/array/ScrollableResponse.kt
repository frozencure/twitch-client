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

    abstract suspend fun nextPage(): CollectionResponse<T>?

}