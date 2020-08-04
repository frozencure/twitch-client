---
title: CollectionHelixResponse - twitch-client
---

[twitch-client](../../index.html) / [helix.http.model](../index.html) / [CollectionHelixResponse](./index.html)

# CollectionHelixResponse

`abstract class CollectionHelixResponse<T : `[`AbstractResource`](../-abstract-resource/index.html)`> : `[`HelixResponse`](../-helix-response/index.html)`<T>`

### Constructors

| [&lt;init&gt;](-init-.html) | `CollectionHelixResponse(httpResponse: HttpResponse)` |

### Properties

| [dateRange](date-range.html) | `val dateRange: `[`DateRange`](../-date-range/index.html)`?` |
| [pagination](pagination.html) | `val pagination: `[`Pagination`](../-pagination/index.html)`?` |
| [resources](resources.html) | `val resources: `[`Collection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)`<T>` |
| [total](total.html) | `val total: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`?` |

### Inheritors

| [AutoModHelixResponse](../../helix.moderation/-auto-mod-helix-response/index.html) | `class AutoModHelixResponse : `[`CollectionHelixResponse`](./index.html)`<`[`AutoModMessageStatus`](../../helix.moderation.model/-auto-mod-message-status/index.html)`>` |
| [BitsLeaderboardResponse](../../helix.bits/-bits-leaderboard-response/index.html) | `class BitsLeaderboardResponse : `[`CollectionHelixResponse`](./index.html)`<`[`BitsLeaderboardEntry`](../../helix.bits.model/-bits-leaderboard-entry/index.html)`>` |
| [ClipsHelixResponse](../../helix.clips/-clips-helix-response/index.html) | `class ClipsHelixResponse : `[`CollectionHelixResponse`](./index.html)`<`[`Clip`](../../helix.clips.model/-clip/index.html)`>` |
| [ExtensionsHelixResponse](../../helix.extensions/-extensions-helix-response/index.html) | `class ExtensionsHelixResponse : `[`CollectionHelixResponse`](./index.html)`<`[`Extension`](../../helix.extensions.model/-extension/index.html)`>` |
| [GamesHelixResponse](../../helix.games/-games-helix-response/index.html) | `class GamesHelixResponse : `[`CollectionHelixResponse`](./index.html)`<`[`Game`](../../helix.games.model/-game/index.html)`>` |
| [ScrollableHelixResponse](../-scrollable-helix-response/index.html) | `abstract class ScrollableHelixResponse<T : `[`AbstractResource`](../-abstract-resource/index.html)`> : `[`CollectionHelixResponse`](./index.html)`<T>` |
| [VideosHelixResponse](../../helix.videos/-videos-helix-response/index.html) | `class VideosHelixResponse : `[`CollectionHelixResponse`](./index.html)`<`[`Video`](../../helix.videos.model/-video/index.html)`>` |

