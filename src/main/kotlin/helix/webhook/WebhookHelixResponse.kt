package helix.webhook

import helix.http.model.HelixDTO
import helix.http.model.ScrollableHelixResponse
import helix.users.model.User
import helix.webhook.model.Webhook
import io.ktor.client.HttpClient
import io.ktor.client.call.receive
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.runBlocking

class WebhooksHelixResponse(httpResponse: HttpResponse, httpClient: HttpClient) :
    ScrollableHelixResponse<Webhook>(httpResponse, httpClient) {
    override val helixDTO: HelixDTO<Webhook> = runBlocking {
        httpResponse.receive<HelixDTO<Webhook>>()
    }

    override suspend fun nextPage(): WebhooksHelixResponse? =
        nextPageHttpResponse(cursorKey = "after")?.let {
            WebhooksHelixResponse(
                it, httpClient
            )
        }
}
