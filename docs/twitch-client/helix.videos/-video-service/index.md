---
title: VideoService -
---
//[twitch-client](../../index.md)/[helix.videos](../index.md)/[VideoService](index.md)



# VideoService  
 [jvm] class [VideoService](index.md) : [ResourceService](../../helix.http/-resource-service/index.md)   


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
| [getVideo](get-video.md)| [jvm]  <br>Content  <br>suspend fun [getVideo](get-video.md)(id: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)): [VideoHelixResponse](../-video-helix-response/index.md)  <br><br><br>
| [getVideos](get-videos.md)| [jvm]  <br>Content  <br>suspend fun [getVideos](get-videos.md)(ids: [Collection](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)<[Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)>): [VideosHelixResponse](../-videos-helix-response/index.md)  <br><br><br>
| [getVideosByGame](get-videos-by-game.md)| [jvm]  <br>Content  <br>suspend fun [getVideosByGame](get-videos-by-game.md)(gameId: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), videosNumber: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), period: [Period](../../helix.shared.model.request/-period/index.md), sorting: [VideoSorting](../../helix.videos.model.request/-video-sorting/index.md), type: [VideoType](../../helix.videos.model.request/-video-type/index.md), language: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?): [ScrollableVideosResponse](../-scrollable-videos-response/index.md)  <br><br><br>
| [getVideosByUser](get-videos-by-user.md)| [jvm]  <br>Content  <br>suspend fun [getVideosByUser](get-videos-by-user.md)(userId: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), videosNumber: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), period: [Period](../../helix.shared.model.request/-period/index.md), sorting: [VideoSorting](../../helix.videos.model.request/-video-sorting/index.md), type: [VideoType](../../helix.videos.model.request/-video-type/index.md), language: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?): [ScrollableVideosResponse](../-scrollable-videos-response/index.md)  <br><br><br>
| [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)| [jvm]  <br>Content  <br>open override fun [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)| [jvm]  <br>Content  <br>open override fun [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>

