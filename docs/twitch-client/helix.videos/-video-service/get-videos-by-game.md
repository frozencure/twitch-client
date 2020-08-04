---
title: VideoService.getVideosByGame - twitch-client
---

[twitch-client](../../index.html) / [helix.videos](../index.html) / [VideoService](index.html) / [getVideosByGame](./get-videos-by-game.html)

# getVideosByGame

`suspend fun getVideosByGame(gameId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, videosNumber: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 100, period: `[`Period`](../../helix.shared.model.request/-period/index.html)` = Period.ALL, sorting: `[`VideoSorting`](../../helix.videos.model.request/-video-sorting/index.html)` = VideoSorting.TIME, type: `[`VideoType`](../../helix.videos.model.request/-video-type/index.html)` = VideoType.ALL, language: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null): `[`ScrollableVideosResponse`](../-scrollable-videos-response/index.html)