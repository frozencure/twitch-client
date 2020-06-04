package helix.extensions

import helix.extensions.model.ExtensionTransaction
import helix.http.model.HelixDTO
import helix.http.model.ScrollableHelixResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.receive
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.runBlocking

class TransactionsHelixResponse(
    httpResponse: HttpResponse,
    httpClient: HttpClient
) :
    ScrollableHelixResponse<ExtensionTransaction>(httpResponse, httpClient) {
    override val helixDTO: HelixDTO<ExtensionTransaction> = runBlocking {
        httpResponse.receive<HelixDTO<ExtensionTransaction>>()
    }

    override suspend fun nextPage(): TransactionsHelixResponse? =
        nextPageHttpResponse(cursorKey = "after")?.let {
            TransactionsHelixResponse(
                it, httpClient
            )
        }

}