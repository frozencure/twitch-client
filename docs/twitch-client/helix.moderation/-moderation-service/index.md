---
title: ModerationService - twitch-client
---

[twitch-client](../../index.html) / [helix.moderation](../index.html) / [ModerationService](./index.html)

# ModerationService

`class ModerationService : `[`ResourceService`](../../helix.http/-resource-service/index.html)

### Constructors

| [&lt;init&gt;](-init-.html) | `ModerationService(apiSettings: `[`ApiSettings`](../../helix.http.credentials/-api-settings/index.html)`, httpClientEngineConfig: HttpClientEngineConfig)`<br>`ModerationService(httpClient: HttpClient)` |

### Functions

| [checkMessagesWithAutoMod](check-messages-with-auto-mod.html) | `suspend fun checkMessagesWithAutoMod(broadcasterId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, messages: `[`Collection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)`<`[`AutoModMessage`](../../helix.moderation.model/-auto-mod-message/index.html)`>): `[`AutoModHelixResponse`](../-auto-mod-helix-response/index.html) |
| [getBanEvents](get-ban-events.html) | `suspend fun getBanEvents(broadcasterId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, userIds: `[`Collection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)`<`[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`>? = null, first: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 100): `[`BanEventsScrollableResponse`](../-ban-events-scrollable-response/index.html) |
| [getBannedUsers](get-banned-users.html) | `suspend fun getBannedUsers(broadcasterId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, userIds: `[`Collection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)`<`[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`>? = null): `[`BannedUsersScrollableResponse`](../-banned-users-scrollable-response/index.html) |
| [getModeratorEvents](get-moderator-events.html) | `suspend fun getModeratorEvents(broadcasterId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, userIds: `[`Collection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)`<`[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`>? = null): `[`ModeratorEventsScrollableResponse`](../-moderator-events-scrollable-response/index.html) |
| [getModerators](get-moderators.html) | `suspend fun getModerators(broadcasterId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, userIds: `[`Collection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)`<`[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`>? = null): `[`ModeratorsScrollableHelixResponse`](../-moderators-scrollable-helix-response/index.html) |

### Companion Object Properties

| [BASE_URL](-b-a-s-e_-u-r-l.html) | `const val BASE_URL: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

