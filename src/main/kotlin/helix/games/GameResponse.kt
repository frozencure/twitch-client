package helix.games

import helix.games.model.Game
import helix.http.model.array.CollectionResponse
import helix.http.model.array.HelixArrayDTO
import helix.http.model.array.ScrollableResponse
import helix.http.model.array.SingleResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.receive
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.runBlocking

class GameResponse(httpResponse: HttpResponse) : SingleResponse<Game>(httpResponse) {
    override val helixArrayDTO: HelixArrayDTO<Game> = runBlocking {
        httpResponse.receive<HelixArrayDTO<Game>>()
    }
}

class GamesResponse(httpResponse: HttpResponse) : CollectionResponse<Game>(httpResponse) {
    override val helixArrayDTO: HelixArrayDTO<Game> = runBlocking {
        httpResponse.receive<HelixArrayDTO<Game>>()
    }
}


class ScrollableGamesResponse(
    httpResponse: HttpResponse,
    httpClient: HttpClient
) :
    ScrollableResponse<Game>(httpResponse, httpClient) {
    override val helixArrayDTO: HelixArrayDTO<Game> = runBlocking {
        httpResponse.receive<HelixArrayDTO<Game>>()
    }

    override suspend fun nextPage(): ScrollableGamesResponse? =
        nextPageHttpResponse(cursorKey = "after")?.let {
            ScrollableGamesResponse(
                it, httpClient
            )
        }

}