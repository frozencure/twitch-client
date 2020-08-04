---
title: StreamService - twitch-client
---

[twitch-client](../../index.html) / [helix.streams](../index.html) / [StreamService](./index.html)

# StreamService

`class StreamService : `[`ResourceService`](../../helix.http/-resource-service/index.html)

### Constructors

| [&lt;init&gt;](-init-.html) | `StreamService(apiSettings: `[`ApiSettings`](../../helix.http.credentials/-api-settings/index.html)`, httpClientEngineConfig: HttpClientEngineConfig)`<br>`StreamService(httpClient: HttpClient)` |

### Functions

| [createStreamMarker](create-stream-marker.html) | `suspend fun createStreamMarker(userId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, description: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null): `[`StreamMarkerHelixResponse`](../../helix.streams.markers/-stream-marker-helix-response/index.html) |
| [getStreamKey](get-stream-key.html) | `suspend fun getStreamKey(broadcasterId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`StreamKeyResponse`](../-stream-key-response/index.html) |
| [getStreams](get-streams.html) | `suspend fun getStreams(first: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 100, gameIds: `[`Collection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)`<`[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`>? = null, languages: `[`Collection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>? = null, userIds: `[`Collection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)`<`[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`>? = null, userLoginNames: `[`Collection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>? = null): `[`StreamsHelixResponse`](../-streams-helix-response/index.html) |
| [getStreamsMetadata](get-streams-metadata.html) | `suspend fun getStreamsMetadata(first: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 100, gameIds: `[`Collection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)`<`[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`>? = null, languages: `[`Collection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>? = null, userIds: `[`Collection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)`<`[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`>? = null, userLoginNames: `[`Collection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>? = null): `[`StreamsMetadataHelixResponse`](../../helix.streams.metadata/-streams-metadata-helix-response/index.html) |
| [getStreamTags](get-stream-tags.html) | `suspend fun getStreamTags(tagIds: `[`Collection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>? = null, first: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 100): `[`StreamTagsHelixResponse`](../../helix.streams.tags/-stream-tags-helix-response/index.html)<br>`suspend fun getStreamTags(broadcasterId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`StreamTagsHelixResponse`](../../helix.streams.tags/-stream-tags-helix-response/index.html) |
| [getUserStreamMarkers](get-user-stream-markers.html) | `suspend fun getUserStreamMarkers(userId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, first: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 100): `[`UserStreamMarkersResponse`](../../helix.streams.markers/-user-stream-markers-response/index.html) |
| [getVideoStreamMarkers](get-video-stream-markers.html) | `suspend fun getVideoStreamMarkers(videoId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, first: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 100): `[`UserStreamMarkersResponse`](../../helix.streams.markers/-user-stream-markers-response/index.html) |
| [updateStreamTags](update-stream-tags.html) | `suspend fun updateStreamTags(broadcasterId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, tags: `[`Collection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>? = null): HttpResponse` |

### Companion Object Properties

| [BASE_URL](-b-a-s-e_-u-r-l.html) | `const val BASE_URL: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

