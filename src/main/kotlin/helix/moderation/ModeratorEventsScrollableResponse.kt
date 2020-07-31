package helix.moderation

import helix.http.model.HelixDTO
import helix.http.model.ScrollableHelixResponse
import helix.moderation.model.ModeratorEvent
import io.ktor.client.HttpClient
import io.ktor.client.call.receive
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.runBlocking

class ModeratorEventsScrollableResponse(
    httpResponse: HttpResponse,
    httpClient: HttpClient
) :
    ScrollableHelixResponse<ModeratorEvent>(httpResponse, httpClient) {
    override val helixDTO: HelixDTO<ModeratorEvent> = runBlocking {
        httpResponse.receive<HelixDTO<ModeratorEvent>>()
    }

    override suspend fun nextPage(): ModeratorEventsScrollableResponse? =
        nextPageHttpResponse(cursorKey = "after")?.let {
            ModeratorEventsScrollableResponse(
                it, httpClient
            )
        }

}