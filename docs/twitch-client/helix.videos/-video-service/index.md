---
title: VideoService - twitch-client
---

[twitch-client](../../index.html) / [helix.videos](../index.html) / [VideoService](./index.html)

# VideoService

`class VideoService : `[`ResourceService`](../../helix.http/-resource-service/index.html)

### Constructors

| [&lt;init&gt;](-init-.html) | `VideoService(apiSettings: `[`ApiSettings`](../../helix.http.credentials/-api-settings/index.html)`, httpClientEngineConfig: HttpClientEngineConfig)`<br>`VideoService(httpClient: HttpClient)` |

### Functions

| [getVideo](get-video.html) | `suspend fun getVideo(id: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`VideoHelixResponse`](../-video-helix-response/index.html) |
| [getVideos](get-videos.html) | `suspend fun getVideos(ids: `[`Collection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)`<`[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`>): `[`VideosHelixResponse`](../-videos-helix-response/index.html) |
| [getVideosByGame](get-videos-by-game.html) | `suspend fun getVideosByGame(gameId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, videosNumber: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 100, period: `[`Period`](../../helix.shared.model.request/-period/index.html)` = Period.ALL, sorting: `[`VideoSorting`](../../helix.videos.model.request/-video-sorting/index.html)` = VideoSorting.TIME, type: `[`VideoType`](../../helix.videos.model.request/-video-type/index.html)` = VideoType.ALL, language: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null): `[`ScrollableVideosResponse`](../-scrollable-videos-response/index.html) |
| [getVideosByUser](get-videos-by-user.html) | `suspend fun getVideosByUser(userId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, videosNumber: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 100, period: `[`Period`](../../helix.shared.model.request/-period/index.html)` = Period.ALL, sorting: `[`VideoSorting`](../../helix.videos.model.request/-video-sorting/index.html)` = VideoSorting.TIME, type: `[`VideoType`](../../helix.videos.model.request/-video-type/index.html)` = VideoType.ALL, language: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null): `[`ScrollableVideosResponse`](../-scrollable-videos-response/index.html) |

### Companion Object Properties

| [BASE_URL](-b-a-s-e_-u-r-l.html) | `const val BASE_URL: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

