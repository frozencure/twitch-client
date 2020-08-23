package com.github.frozencure.helix.games

import com.github.frozencure.helix.auth.model.AuthCredentials
import com.github.frozencure.helix.exceptions.BadRequestException
import com.github.frozencure.helix.http.ResourceService
import io.ktor.client.*
import io.ktor.client.request.*

class GameService : ResourceService {

    constructor(credentials: AuthCredentials) : super(credentials)

    constructor(httpClient: HttpClient) : super(httpClient)

    companion object {
        const val BASE_URL = "${ResourceService.BASE_URL}/games"
    }

    suspend fun getGame(name: String): GameResponse =
        GameResponse(
            httpClient.get(BASE_URL) {
                parameter("name", name)
            }
        )

    suspend fun getGame(id: Long): GameResponse =
        GameResponse(
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

    suspend fun getGames(names: Collection<String>? = null, ids: Collection<Long>? = null): GamesResponse {
        if (ids.isNullOrEmpty() && names.isNullOrEmpty()) {
            throw BadRequestException("Must provide at least one game ID or name")
        }
        return GamesResponse(
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