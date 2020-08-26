package com.github.frozencure.helix.games

import com.github.frozencure.helix.auth.model.AuthCredentials
import com.github.frozencure.helix.exceptions.BadRequestException
import com.github.frozencure.helix.games.model.Game
import com.github.frozencure.helix.http.ResourceService
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * Service class that can be used to access **Games** endpoints:
 * *GET games* and *GET top games*
 */
class GameService : ResourceService {

    /**
     * Creates a new game service object given some authentication credentials and a HTTP client configuration.
     * @param credentials The authentication credentials: can be OAuth or simple credentials with only a client ID
     */
    constructor(credentials: AuthCredentials) : super(credentials)

    /**
     * Creates a new game service object given an HTTP client.
     * @param httpClient The HTTP client.
     */
    constructor(httpClient: HttpClient) : super(httpClient)

    private companion object {
        private const val BASE_URL = "${ResourceService.BASE_URL}/games"
    }

    /**
     * Retrieves a single game given the name of the game.
     * For more information visit the [Twitch Developer Reference](https://dev.twitch.tv/docs/api/reference#get-games)
     * @param name The name of the game. Has to be a perfect match.
     * @return A [GamesResponse] that has a single [Game] resource as payload.
     * @sample samples.getGameByName
     */
    suspend fun getGame(name: String): GameResponse =
        GameResponse(
            httpClient.get(BASE_URL) {
                parameter("name", name)
            }
        )

    /**
     * Retrieves a single game given the ID of the game.
     * For more information visit the [Twitch Developer Reference](https://dev.twitch.tv/docs/api/reference#get-games)
     * @param id The ID of the game.
     * @return A [GamesResponse] that has a single [Game] resource as payload.
     * @sample samples.getGameById
     */
    suspend fun getGame(id: Long): GameResponse =
        GameResponse(
            httpClient.get(BASE_URL) {
                parameter("id", id)
            }
        )


    /**
     * Retrieves the most popular games on Twitch, sorted by popularity in descending order.
     * For more information visit the [Twitch Developer Reference](https://dev.twitch.tv/docs/api/reference#get-top-games)
     * @param first The number of games to be retrieved. Maximum 100, Default 100.
     * @return A [ScrollableGamesResponse] that holds one or multiple [Game] resources as payload (can have multiple pages).
     * @sample samples.getTopGames
     */
    suspend fun getTopGames(first: Int = 100): ScrollableGamesResponse =
        ScrollableGamesResponse(
            httpClient
                .get("${BASE_URL}/top") {
                    parameter("first", first)
                }, httpClient
        )

    /**
     * Retrieves multiple games given a list of game names and/or a list of game IDs.
     * For more information visit the [Twitch Developer Reference](https://dev.twitch.tv/docs/api/reference#get-games)
     * @param names A list of game names.
     * @param ids A list of game IDs.
     * @throws BadRequestException An exception is thrown if both the [names] and [ids] are null or empty.
     * @return A [GamesResponse] object that holds one or multiple [Game] resources.
     * @sample samples.getGames
     */
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

    /**
     * Returns a list of games or categories that match the query via name either entirely or partially.
     * Requires an app or user access token.
     * For more information visit the [Twitch Developer Reference](https://dev.twitch.tv/docs/api/reference#search-categories)
     * @param query The search query that needs to be matched fully or partially.
     * @param first Maximum number of games to return. Maximum: 100. Default: 100.
     * @return A [ScrollableGamesResponse] that holds one or multiple [Game] resources as payload (can have multiple pages).
     * @sample samples.searchGames
     */
    suspend fun getGames(query: String, first: Int = 100): ScrollableGamesResponse = ScrollableGamesResponse(
        httpClient.get("${ResourceService.BASE_URL}/search/categories") {
            parameter("query", query)
            parameter("first", first)
        }, httpClient
    )
}