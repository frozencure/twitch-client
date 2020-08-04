---
title: BitsService - twitch-client
---

[twitch-client](../../index.html) / [helix.bits](../index.html) / [BitsService](./index.html)

# BitsService

`class BitsService : `[`ResourceService`](../../helix.http/-resource-service/index.html)

### Constructors

| [&lt;init&gt;](-init-.html) | `BitsService(apiSettings: `[`ApiSettings`](../../helix.http.credentials/-api-settings/index.html)`, httpClientEngineConfig: HttpClientEngineConfig)`<br>`BitsService(httpClient: HttpClient)` |

### Functions

| [getBitsLeaderboard](get-bits-leaderboard.html) | `suspend fun getBitsLeaderboard(count: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 100, period: `[`Period`](../../helix.shared.model.request/-period/index.html)` = Period.ALL, userId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`? = null, startedAt: Instant? = null): `[`BitsLeaderboardResponse`](../-bits-leaderboard-response/index.html) |

### Companion Object Properties

| [BASE_URL](-b-a-s-e_-u-r-l.html) | `const val BASE_URL: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

