---
title: helix.streams.markers.model -
---
//[twitch-client](../index.md)/[helix.streams.markers.model](index.md)



# Package helix.streams.markers.model  


## Types  
  
|  Name|  Summary| 
|---|---|
| [StreamMarker](-stream-marker/index.md)| [jvm]  <br>Content  <br>data class [StreamMarker](-stream-marker/index.md)(**id**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html),**createdAt**: [Instant](https://docs.oracle.com/javase/8/docs/api/java/time/Instant.html),**description**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html),**positionSeconds**: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html),**url**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?) : [AbstractResource](../helix.http.model/-abstract-resource/index.md)  <br><br><br>
| [StreamMarkerRequest](-stream-marker-request/index.md)| [jvm]  <br>Content  <br>data class [StreamMarkerRequest](-stream-marker-request/index.md)(**userId**: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html),**description**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?)  <br><br><br>
| [UserStreamMarkers](-user-stream-markers/index.md)| [jvm]  <br>Content  <br>data class [UserStreamMarkers](-user-stream-markers/index.md)(**userId**: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html),**userLoginName**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html),**videosMarkers**: [Collection](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)<[VideoMarkers](-video-markers/index.md)>) : [AbstractResource](../helix.http.model/-abstract-resource/index.md)  <br><br><br>
| [VideoMarkers](-video-markers/index.md)| [jvm]  <br>Content  <br>data class [VideoMarkers](-video-markers/index.md)(**videoId**: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html),**markers**: [Collection](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)<[StreamMarker](-stream-marker/index.md)>)  <br><br><br>

