package helix.webhook

import helix.http.model.array.HelixArrayDTO
import helix.http.model.array.ScrollableResponse
import helix.webhook.model.Webhook
import io.ktor.client.HttpClient
import io.ktor.client.call.receive
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.runBlocking

class WebhooksResponse(httpResponse: HttpResponse, httpClient: HttpClient) :
    ScrollableResponse<Webhook>(httpResponse, httpClient) {
    override val helixArrayDTO: HelixArrayDTO<Webhook> = runBlocking {
        httpResponse.receive<HelixArrayDTO<Webhook>>()
    }

    override suspend fun nextPage(): WebhooksResponse? =
        nextPageHttpResponse(cursorKey = "after")?.let {
            WebhooksResponse(
                it, httpClient
            )
        }
}
