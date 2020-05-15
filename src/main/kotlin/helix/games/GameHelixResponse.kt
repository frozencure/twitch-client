package helix.games

import helix.games.model.Game
import helix.http.model.CollectionHelixResponse
import helix.http.model.HelixDTO
import helix.http.model.ScrollableHelixResponse
import helix.http.model.SingleHelixResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.receive
import io.ktor.client.request.headers
import io.ktor.client.request.parameter
import io.ktor.client.request.request
import io.ktor.client.request.url
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.request
import kotlinx.coroutines.runBlocking

class GameHelixResponse(httpResponse: HttpResponse) : SingleHelixResponse<Game>(httpResponse) {
    override val helixDTO: HelixDTO<Game> = runBlocking {
        httpResponse.receive<HelixDTO<Game>>()
    }
}

class GamesHelixResponse(httpResponse: HttpResponse) : CollectionHelixResponse<Game>(httpResponse) {
    override val helixDTO: HelixDTO<Game> = runBlocking {
        httpResponse.receive<HelixDTO<Game>>()
    }
}


class ScrollableGamesResponse(
    httpResponse: HttpResponse,
    httpClient: HttpClient
) :
    ScrollableHelixResponse<Game>(httpResponse, httpClient) {
    override val helixDTO: HelixDTO<Game> = runBlocking {
        httpResponse.receive<HelixDTO<Game>>()
    }

    override suspend fun nextPage(): ScrollableGamesResponse? =
        pagination?.let {
            ScrollableGamesResponse(httpClient.request<HttpResponse> {
                url(httpResponse.request.url)
                parameter("after", it.asPair().second)
                headers { httpResponse.request.headers }
                method = httpResponse.request.method
            }, httpClient)
        }

}