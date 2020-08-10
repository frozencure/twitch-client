package helix.moderation

import helix.http.model.array.HelixArrayDTO
import helix.http.model.array.ScrollableResponse
import helix.moderation.model.ModeratorEvent
import io.ktor.client.HttpClient
import io.ktor.client.call.receive
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.runBlocking

class ModeratorEventsScrollableResponse(
    httpResponse: HttpResponse,
    httpClient: HttpClient
) :
    ScrollableResponse<ModeratorEvent>(httpResponse, httpClient) {
    override val helixArrayDTO: HelixArrayDTO<ModeratorEvent> = runBlocking {
        httpResponse.receive<HelixArrayDTO<ModeratorEvent>>()
    }

    override suspend fun nextPage(): ModeratorEventsScrollableResponse? =
        nextPageHttpResponse(cursorKey = "after")?.let {
            ModeratorEventsScrollableResponse(
                it, httpClient
            )
        }

}