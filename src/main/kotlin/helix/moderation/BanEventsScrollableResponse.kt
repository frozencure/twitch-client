package helix.moderation

import helix.http.model.HelixDTO
import helix.http.model.ScrollableHelixResponse
import helix.moderation.model.BanEvent
import io.ktor.client.HttpClient
import io.ktor.client.call.receive
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.runBlocking

class BanEventsScrollableResponse(
    httpResponse: HttpResponse,
    httpClient: HttpClient
) :
    ScrollableHelixResponse<BanEvent>(httpResponse, httpClient) {
    override val helixDTO: HelixDTO<BanEvent> = runBlocking {
        httpResponse.receive<HelixDTO<BanEvent>>()
    }

    override suspend fun nextPage(): BanEventsScrollableResponse? =
        nextPageHttpResponse(cursorKey = "after")?.let {
            BanEventsScrollableResponse(
                it, httpClient
            )
        }

}