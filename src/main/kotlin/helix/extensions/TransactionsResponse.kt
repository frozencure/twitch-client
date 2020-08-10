package helix.extensions

import helix.extensions.model.transaction.ExtensionTransaction
import helix.http.model.array.HelixArrayDTO
import helix.http.model.array.ScrollableResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.receive
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.runBlocking

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