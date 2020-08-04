---
title: GameService.getGames - twitch-client
---

[twitch-client](../../index.html) / [helix.games](../index.html) / [GameService](index.html) / [getGames](./get-games.html)

# getGames

`suspend fun getGames(names: `[`Collection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>? = null, ids: `[`Collection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)`<`[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`>? = null): `[`GamesHelixResponse`](../-games-helix-response/index.html)
`suspend fun getGames(query: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, first: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 100): `[`ScrollableGamesResponse`](../-scrollable-games-response/index.html)