---
title: GameService -
---
//[twitch-client](../../index.md)/[helix.games](../index.md)/[GameService](index.md)



# GameService  
 [jvm] class [GameService](index.md) : [ResourceService](../../helix.http/-resource-service/index.md)   


## Constructors  
  
|  Name|  Summary| 
|---|---|
| [<init>](-init-.md)|  [jvm] fun [<init>](-init-.md)(apiSettings: [ApiSettings](../../helix.http.credentials/-api-settings/index.md), httpClientEngineConfig: [HttpClientEngineConfig]())   <br>
| [<init>](-init-.md)|  [jvm] fun [<init>](-init-.md)(httpClient: [HttpClient]())   <br>


## Types  
  
|  Name|  Summary| 
|---|---|
| [Companion](-companion/index.md)| [jvm]  <br>Content  <br>object [Companion](-companion/index.md)  <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)| [jvm]  <br>Content  <br>open operator override fun [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [getGame](get-game.md)| [jvm]  <br>Content  <br>suspend fun [getGame](get-game.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [GameHelixResponse](../-game-helix-response/index.md)  <br>suspend fun [getGame](get-game.md)(id: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)): [GameHelixResponse](../-game-helix-response/index.md)  <br><br><br>
| [getGames](get-games.md)| [jvm]  <br>Content  <br>suspend fun [getGames](get-games.md)(names: [Collection](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)<[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)>?, ids: [Collection](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)<[Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)>?): [GamesHelixResponse](../-games-helix-response/index.md)  <br>suspend fun [getGames](get-games.md)(query: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), first: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [ScrollableGamesResponse](../-scrollable-games-response/index.md)  <br><br><br>
| [getTopGames](get-top-games.md)| [jvm]  <br>Content  <br>suspend fun [getTopGames](get-top-games.md)(first: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [ScrollableGamesResponse](../-scrollable-games-response/index.md)  <br><br><br>
| [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)| [jvm]  <br>Content  <br>open override fun [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)| [jvm]  <br>Content  <br>open override fun [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>

