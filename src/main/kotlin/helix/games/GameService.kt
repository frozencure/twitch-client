package helix.games

import helix.exceptions.BadRequestException
import helix.http.ResourceService
import helix.http.credentials.ApiSettings
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class GameService : ResourceService {

    constructor(apiSettings: ApiSettings, httpClientEngineConfig: HttpClientEngineConfig)
            : super(apiSettings, httpClientEngineConfig)

    constructor(httpClient: HttpClient) : super(httpClient)

    companion object {
        const val BASE_URL = "${ResourceService.BASE_URL}/games"
    }

    suspend fun getGame(name: String): GameHelixResponse =
        GameHelixResponse(
            httpClient.get(BASE_URL) {
                parameter("name", name)
            }
        )

    suspend fun getGame(id: Long): GameHelixResponse =
        GameHelixResponse(
            httpClient.get(BASE_URL) {
                parameter("id", id)
            }
        )


    suspend fun getTopGames(first: Int = 100): ScrollableGamesResponse =
        ScrollableGamesResponse(
            httpClient
                .get("${BASE_URL}/top") {
                    parameter("first", first)
                }, httpClient
        )

    suspend fun getGames(names: Collection<String>? = null, ids: Collection<Long>? = null): GamesHelixResponse {
        if (ids.isNullOrEmpty() && names.isNullOrEmpty()) {
            throw BadRequestException("Must provide at least one game ID or name")
        }
        return GamesHelixResponse(
            httpClient
                .get(BASE_URL) {
                    ids?.forEach {
                        parameter("id", it)
                    }
                    names?.forEach {
                        parameter("name", it)
                    }
                }
        )
    }

    suspend fun getGames(query: String, first: Int = 100): ScrollableGamesResponse = ScrollableGamesResponse(
        httpClient.get("${ResourceService.BASE_URL}/search/categories") {
            parameter("query", query)
            parameter("first", first)
        }, httpClient
    )
}