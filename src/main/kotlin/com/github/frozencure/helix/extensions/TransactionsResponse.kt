package com.github.frozencure.helix.extensions

import com.github.frozencure.helix.extensions.model.transaction.ExtensionTransaction
import com.github.frozencure.helix.http.model.array.HelixArrayDTO
import com.github.frozencure.helix.http.model.array.ScrollableResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.statement.*
import kotlinx.coroutines.runBlocking

/**
 * A collection response that holds one or multiple extension transactions as payload.
 * The resource collection can be split into multiple pages.
 * @constructor Creates a new transactions response object.
 */
class TransactionsResponse(
    httpResponse: HttpResponse,
    httpClient: HttpClient
) :
    ScrollableResponse<ExtensionTransaction>(httpResponse, httpClient) {
    override val helixArrayDTO: HelixArrayDTO<ExtensionTransaction> = runBlocking {
        httpResponse.receive<HelixArrayDTO<ExtensionTransaction>>()
    }

    override suspend fun nextPage(): TransactionsResponse? =
        nextPageHttpResponse(cursorKey = "after")?.let {
            TransactionsResponse(
                it, httpClient
            )
        }

}