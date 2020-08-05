---
title: StreamService -
---
//[twitch-client](../../index.md)/[helix.streams](../index.md)/[StreamService](index.md)



# StreamService  
 [jvm] class [StreamService](index.md) : [ResourceService](../../helix.http/-resource-service/index.md)   


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
| [createStreamMarker](create-stream-marker.md)| [jvm]  <br>Content  <br>suspend fun [createStreamMarker](create-stream-marker.md)(userId: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), description: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?): [StreamMarkerHelixResponse](../../helix.streams.markers/-stream-marker-helix-response/index.md)  <br><br><br>
| [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)| [jvm]  <br>Content  <br>open operator override fun [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [getStreamKey](get-stream-key.md)| [jvm]  <br>Content  <br>suspend fun [getStreamKey](get-stream-key.md)(broadcasterId: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)): [StreamKeyResponse](../-stream-key-response/index.md)  <br><br><br>
| [getStreams](get-streams.md)| [jvm]  <br>Content  <br>suspend fun [getStreams](get-streams.md)(first: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), gameIds: [Collection](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)<[Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)>?, languages: [Collection](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)<[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)>?, userIds: [Collection](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)<[Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)>?, userLoginNames: [Collection](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)<[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)>?): [StreamsHelixResponse](../-streams-helix-response/index.md)  <br><br><br>
| [getStreamsMetadata](get-streams-metadata.md)| [jvm]  <br>Content  <br>suspend fun [getStreamsMetadata](get-streams-metadata.md)(first: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), gameIds: [Collection](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)<[Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)>?, languages: [Collection](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)<[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)>?, userIds: [Collection](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)<[Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)>?, userLoginNames: [Collection](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)<[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)>?): [StreamsMetadataHelixResponse](../../helix.streams.metadata/-streams-metadata-helix-response/index.md)  <br><br><br>
| [getStreamTags](get-stream-tags.md)| [jvm]  <br>Content  <br>suspend fun [getStreamTags](get-stream-tags.md)(tagIds: [Collection](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)<[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)>?, first: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [StreamTagsHelixResponse](../../helix.streams.tags/-stream-tags-helix-response/index.md)  <br>suspend fun [getStreamTags](get-stream-tags.md)(broadcasterId: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)): [StreamTagsHelixResponse](../../helix.streams.tags/-stream-tags-helix-response/index.md)  <br><br><br>
| [getUserStreamMarkers](get-user-stream-markers.md)| [jvm]  <br>Content  <br>suspend fun [getUserStreamMarkers](get-user-stream-markers.md)(userId: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), first: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [UserStreamMarkersResponse](../../helix.streams.markers/-user-stream-markers-response/index.md)  <br><br><br>
| [getVideoStreamMarkers](get-video-stream-markers.md)| [jvm]  <br>Content  <br>suspend fun [getVideoStreamMarkers](get-video-stream-markers.md)(videoId: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), first: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [UserStreamMarkersResponse](../../helix.streams.markers/-user-stream-markers-response/index.md)  <br><br><br>
| [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)| [jvm]  <br>Content  <br>open override fun [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)| [jvm]  <br>Content  <br>open override fun [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>
| [updateStreamTags](update-stream-tags.md)| [jvm]  <br>Content  <br>suspend fun [updateStreamTags](update-stream-tags.md)(broadcasterId: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), tags: [Collection](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)<[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)>?): [HttpResponse]()  <br><br><br>

