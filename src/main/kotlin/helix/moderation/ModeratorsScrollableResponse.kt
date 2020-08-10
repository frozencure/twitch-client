package helix.moderation

import helix.http.model.array.HelixArrayDTO
import helix.http.model.array.ScrollableResponse
import helix.moderation.model.Moderator
import io.ktor.client.HttpClient
import io.ktor.client.call.receive
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.runBlocking


class ModeratorsScrollableResponse(
    httpResponse: HttpResponse,
    httpClient: HttpClient
) :
    ScrollableResponse<Moderator>(httpResponse, httpClient) {
    override val helixArrayDTO: HelixArrayDTO<Moderator> = runBlocking {
        httpResponse.receive<HelixArrayDTO<Moderator>>()
    }

    override suspend fun nextPage(): ModeratorsScrollableResponse? =
        nextPageHttpResponse(cursorKey = "after")?.let {
            ModeratorsScrollableResponse(
                it, httpClient
            )
        }

}