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

/**
 * A collection response that can hold a single game resource as payload.
 * @constructor Creates a new game response response object.
 */
class GameResponse(httpResponse: HttpResponse) : SingleResponse<Game>(httpResponse) {
    override val helixArrayDTO: HelixArrayDTO<Game> = runBlocking {
        httpResponse.receive<HelixArrayDTO<Game>>()
    }
}


/**
 * A collection response that contains one or multiple game objects.
 * @constructor Creates a new games response object.
 */
class GamesResponse(httpResponse: HttpResponse) : CollectionResponse<Game>(httpResponse) {
    override val helixArrayDTO: HelixArrayDTO<Game> = runBlocking {
        httpResponse.receive<HelixArrayDTO<Game>>()
    }
}

/**
 * A collection response that holds one or multiple game resources as payload.
 * The resource collection can be split into multiple pages.
 * @constructor Creates a new scrollable games response object.
 */
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