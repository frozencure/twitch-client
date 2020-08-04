---
title: ChannelService - twitch-client
---

[twitch-client](../../index.html) / [helix.channels](../index.html) / [ChannelService](./index.html)

# ChannelService

`class ChannelService : `[`ResourceService`](../../helix.http/-resource-service/index.html)

### Constructors

| [&lt;init&gt;](-init-.html) | `ChannelService(apiSettings: `[`ApiSettings`](../../helix.http.credentials/-api-settings/index.html)`, httpClientEngineConfig: HttpClientEngineConfig)`<br>`ChannelService(httpClient: HttpClient)` |

### Functions

| [getChannels](get-channels.html) | `suspend fun getChannels(query: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, liveOnly: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false, first: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 100): `[`ChannelsHelixResponse`](../-channels-helix-response/index.html) |
| [getHypeTrainEvents](get-hype-train-events.html) | `suspend fun getHypeTrainEvents(broadcasterId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, eventId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, first: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 100): `[`HypeTrainScrollableResponse`](../-hype-train-scrollable-response/index.html) |
| [modifyChannelInfo](modify-channel-info.html) | `suspend fun modifyChannelInfo(broadcasterId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, title: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, gameId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`? = null, language: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null): HttpResponse` |
| [startCommercial](start-commercial.html) | `suspend fun startCommercial(broadcasterId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, length: `[`CommercialLength`](../../helix.channels.model.commercial/-commercial-length/index.html)`): `[`CommercialResponse`](../-commercial-response/index.html) |

### Companion Object Properties

| [BASE_URL](-b-a-s-e_-u-r-l.html) | `const val BASE_URL: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

