package helix.subscriptions

import helix.http.model.array.HelixArrayDTO
import helix.http.model.array.ScrollableResponse
import helix.subscriptions.model.Subscription
import io.ktor.client.HttpClient
import io.ktor.client.call.receive
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.runBlocking

class SubscriptionsResponse(httpResponse: HttpResponse, httpClient: HttpClient) :
    ScrollableResponse<Subscription>(httpResponse, httpClient) {
    override val helixArrayDTO: HelixArrayDTO<Subscription> = runBlocking {
        httpResponse.receive<HelixArrayDTO<Subscription>>()
    }

    override suspend fun nextPage(): SubscriptionsResponse? =
        nextPageHttpResponse()?.let {
            SubscriptionsResponse(
                it, httpClient
            )
        }
}