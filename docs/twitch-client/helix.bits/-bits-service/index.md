---
title: BitsService -
---
//[twitch-client](../../index.md)/[helix.bits](../index.md)/[BitsService](index.md)



# BitsService  
 [jvm] class [BitsService](index.md) : [ResourceService](../../helix.http/-resource-service/index.md)   


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
| [getBitsLeaderboard](get-bits-leaderboard.md)| [jvm]  <br>Content  <br>suspend fun [getBitsLeaderboard](get-bits-leaderboard.md)(count: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), period: [Period](../../helix.shared.model.request/-period/index.md), userId: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)?, startedAt: [Instant](https://docs.oracle.com/javase/8/docs/api/java/time/Instant.html)?): [BitsLeaderboardResponse](../-bits-leaderboard-response/index.md)  <br><br><br>
| [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)| [jvm]  <br>Content  <br>open override fun [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)| [jvm]  <br>Content  <br>open override fun [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>

