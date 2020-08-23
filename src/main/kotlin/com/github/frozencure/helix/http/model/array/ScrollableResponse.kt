package com.github.frozencure.helix.http.model.array

import com.github.frozencure.helix.http.model.AbstractResource
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

/**
 * Generic class used for all Twitch Helix responses that can return more than one page of results.
 * Holds the state of the last request and provides an easy way of requesting the next pages.
 * @param httpClient The HTTP client necessary for making requests for the next parts of the collection (pages).
 */
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