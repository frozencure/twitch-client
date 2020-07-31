package helix.moderation

import helix.http.model.HelixDTO
import helix.http.model.ScrollableHelixResponse
import helix.moderation.model.Moderator
import io.ktor.client.HttpClient
import io.ktor.client.call.receive
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.runBlocking


class ModeratorsScrollableHelixResponse(
    httpResponse: HttpResponse,
    httpClient: HttpClient
) :
    ScrollableHelixResponse<Moderator>(httpResponse, httpClient) {
    override val helixDTO: HelixDTO<Moderator> = runBlocking {
        httpResponse.receive<HelixDTO<Moderator>>()
    }

    override suspend fun nextPage(): ModeratorsScrollableHelixResponse? =
        nextPageHttpResponse(cursorKey = "after")?.let {
            ModeratorsScrollableHelixResponse(
                it, httpClient
            )
        }

}