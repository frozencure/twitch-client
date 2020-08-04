---
title: ModeratorEvent - twitch-client
---

[twitch-client](../../index.html) / [helix.moderation.model](../index.html) / [ModeratorEvent](./index.html)

# ModeratorEvent

`data class ModeratorEvent : `[`AbstractResource`](../../helix.http.model/-abstract-resource/index.html)

### Constructors

| [&lt;init&gt;](-init-.html) | `ModeratorEvent(id: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, eventType: `[`ModeratorEventType`](../-moderator-event-type/index.html)`, eventTimestamp: Instant, version: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, eventData: `[`ModerationEventData`](../-moderation-event-data/index.html)`)` |

### Properties

| [eventData](event-data.html) | `val eventData: `[`ModerationEventData`](../-moderation-event-data/index.html) |
| [eventTimestamp](event-timestamp.html) | `val eventTimestamp: Instant` |
| [eventType](event-type.html) | `val eventType: `[`ModeratorEventType`](../-moderator-event-type/index.html) |
| [id](id.html) | `val id: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [version](version.html) | `val version: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

