package helix.subscriptions

import helix.http.model.HelixDTO
import helix.http.model.ScrollableHelixResponse
import helix.subscriptions.model.Subscription
import io.ktor.client.HttpClient
import io.ktor.client.call.receive
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.runBlocking

class SubscriptionsHelixResponse(httpResponse: HttpResponse, httpClient: HttpClient) :
    ScrollableHelixResponse<Subscription>(httpResponse, httpClient) {
    override val helixDTO: HelixDTO<Subscription> = runBlocking {
        httpResponse.receive<HelixDTO<Subscription>>()
    }

    override suspend fun nextPage(): SubscriptionsHelixResponse? =
        nextPageHttpResponse()?.let {
            SubscriptionsHelixResponse(
                it, httpClient
            )
        }
}