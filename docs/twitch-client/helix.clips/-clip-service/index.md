---
title: ClipService - twitch-client
---

[twitch-client](../../index.html) / [helix.clips](../index.html) / [ClipService](./index.html)

# ClipService

`class ClipService : `[`ResourceService`](../../helix.http/-resource-service/index.html)

### Constructors

| [&lt;init&gt;](-init-.html) | `ClipService(apiSettings: `[`ApiSettings`](../../helix.http.credentials/-api-settings/index.html)`, httpClientEngineConfig: HttpClientEngineConfig)`<br>`ClipService(httpClient: HttpClient)` |

### Functions

| [createClip](create-clip.html) | `suspend fun createClip(broadcasterId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, hasDelay: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false): `[`ClipCreationHelixResponse`](../-clip-creation-helix-response/index.html) |
| [getClip](get-clip.html) | `suspend fun getClip(id: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`ClipHelixResponse`](../-clip-helix-response/index.html) |
| [getClips](get-clips.html) | `suspend fun getClips(ids: `[`Collection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>): `[`ClipsHelixResponse`](../-clips-helix-response/index.html) |
| [getClipsByBroadcaster](get-clips-by-broadcaster.html) | `suspend fun getClipsByBroadcaster(broadcasterId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, startedAt: Instant? = null, endedAt: Instant? = null): `[`ScrollableClipsResponse`](../-scrollable-clips-response/index.html) |
| [getClipsByGame](get-clips-by-game.html) | `suspend fun getClipsByGame(gameId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, startedAt: Instant? = null, endedAt: Instant? = null): `[`ScrollableClipsResponse`](../-scrollable-clips-response/index.html) |

### Companion Object Properties

| [BASE_URL](-b-a-s-e_-u-r-l.html) | `const val BASE_URL: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

