package com.github.frozencure.helix.games

import com.github.frozencure.helix.games.model.Game
import com.github.frozencure.helix.http.model.array.CollectionResponse
import com.github.frozencure.helix.http.model.array.HelixArrayDTO
import com.github.frozencure.helix.http.model.array.ScrollableResponse
import com.github.frozencure.helix.http.model.array.SingleResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.statement.*
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