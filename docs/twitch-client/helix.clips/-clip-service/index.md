---
title: ClipService -
---
//[twitch-client](../../index.md)/[helix.clips](../index.md)/[ClipService](index.md)



# ClipService  
 [jvm] class [ClipService](index.md) : [ResourceService](../../helix.http/-resource-service/index.md)   


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
| [createClip](create-clip.md)| [jvm]  <br>Content  <br>suspend fun [createClip](create-clip.md)(broadcasterId: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), hasDelay: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): [ClipCreationHelixResponse](../-clip-creation-helix-response/index.md)  <br><br><br>
| [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)| [jvm]  <br>Content  <br>open operator override fun [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [getClip](get-clip.md)| [jvm]  <br>Content  <br>suspend fun [getClip](get-clip.md)(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [ClipHelixResponse](../-clip-helix-response/index.md)  <br><br><br>
| [getClips](get-clips.md)| [jvm]  <br>Content  <br>suspend fun [getClips](get-clips.md)(ids: [Collection](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)<[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)>): [ClipsHelixResponse](../-clips-helix-response/index.md)  <br><br><br>
| [getClipsByBroadcaster](get-clips-by-broadcaster.md)| [jvm]  <br>Content  <br>suspend fun [getClipsByBroadcaster](get-clips-by-broadcaster.md)(broadcasterId: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), startedAt: [Instant](https://docs.oracle.com/javase/8/docs/api/java/time/Instant.html)?, endedAt: [Instant](https://docs.oracle.com/javase/8/docs/api/java/time/Instant.html)?): [ScrollableClipsResponse](../-scrollable-clips-response/index.md)  <br><br><br>
| [getClipsByGame](get-clips-by-game.md)| [jvm]  <br>Content  <br>suspend fun [getClipsByGame](get-clips-by-game.md)(gameId: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), startedAt: [Instant](https://docs.oracle.com/javase/8/docs/api/java/time/Instant.html)?, endedAt: [Instant](https://docs.oracle.com/javase/8/docs/api/java/time/Instant.html)?): [ScrollableClipsResponse](../-scrollable-clips-response/index.md)  <br><br><br>
| [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)| [jvm]  <br>Content  <br>open override fun [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)| [jvm]  <br>Content  <br>open override fun [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>

