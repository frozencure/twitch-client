---
title: GameService - twitch-client
---

[twitch-client](../../index.html) / [helix.games](../index.html) / [GameService](./index.html)

# GameService

`class GameService : `[`ResourceService`](../../helix.http/-resource-service/index.html)

### Constructors

| [&lt;init&gt;](-init-.html) | `GameService(apiSettings: `[`ApiSettings`](../../helix.http.credentials/-api-settings/index.html)`, httpClientEngineConfig: HttpClientEngineConfig)`<br>`GameService(httpClient: HttpClient)` |

### Functions

| [getGame](get-game.html) | `suspend fun getGame(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`GameHelixResponse`](../-game-helix-response/index.html)<br>`suspend fun getGame(id: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`GameHelixResponse`](../-game-helix-response/index.html) |
| [getGames](get-games.html) | `suspend fun getGames(names: `[`Collection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>? = null, ids: `[`Collection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)`<`[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`>? = null): `[`GamesHelixResponse`](../-games-helix-response/index.html)<br>`suspend fun getGames(query: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, first: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 100): `[`ScrollableGamesResponse`](../-scrollable-games-response/index.html) |
| [getTopGames](get-top-games.html) | `suspend fun getTopGames(first: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 100): `[`ScrollableGamesResponse`](../-scrollable-games-response/index.html) |

### Companion Object Properties

| [BASE_URL](-b-a-s-e_-u-r-l.html) | `const val BASE_URL: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

