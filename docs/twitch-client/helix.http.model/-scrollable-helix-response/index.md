---
title: ScrollableHelixResponse - twitch-client
---

[twitch-client](../../index.html) / [helix.http.model](../index.html) / [ScrollableHelixResponse](./index.html)

# ScrollableHelixResponse

`abstract class ScrollableHelixResponse<T : `[`AbstractResource`](../-abstract-resource/index.html)`> : `[`CollectionHelixResponse`](../-collection-helix-response/index.html)`<T>`

### Constructors

| [&lt;init&gt;](-init-.html) | `ScrollableHelixResponse(httpResponse: HttpResponse, httpClient: HttpClient)` |

### Properties

| [httpClient](http-client.html) | `val httpClient: HttpClient` |

### Functions

| [nextPage](next-page.html) | `abstract suspend fun nextPage(): `[`CollectionHelixResponse`](../-collection-helix-response/index.html)`<T>?` |
| [nextPageHttpResponse](next-page-http-response.html) | `suspend fun nextPageHttpResponse(cursorKey: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null): HttpResponse?` |

### Inheritors

| [BanEventsScrollableResponse](../../helix.moderation/-ban-events-scrollable-response/index.html) | `class BanEventsScrollableResponse : `[`ScrollableHelixResponse`](./index.html)`<`[`BanEvent`](../../helix.moderation.model/-ban-event/index.html)`>` |
| [BannedUsersScrollableResponse](../../helix.moderation/-banned-users-scrollable-response/index.html) | `class BannedUsersScrollableResponse : `[`ScrollableHelixResponse`](./index.html)`<`[`BannedUser`](../../helix.moderation.model/-banned-user/index.html)`>` |
| [ChannelsHelixResponse](../../helix.channels/-channels-helix-response/index.html) | `class ChannelsHelixResponse : `[`ScrollableHelixResponse`](./index.html)`<`[`Channel`](../../helix.channels.model/-channel/index.html)`>` |
| [FollowsHelixResponse](../../helix.users/-follows-helix-response/index.html) | `class FollowsHelixResponse : `[`ScrollableHelixResponse`](./index.html)`<`[`FollowEvent`](../../helix.users.model/-follow-event/index.html)`>` |
| [HypeTrainScrollableResponse](../../helix.channels/-hype-train-scrollable-response/index.html) | `class HypeTrainScrollableResponse : `[`ScrollableHelixResponse`](./index.html)`<`[`HypeTrain`](../../helix.channels.model.hypetrain/-hype-train/index.html)`>` |
| [ModeratorEventsScrollableResponse](../../helix.moderation/-moderator-events-scrollable-response/index.html) | `class ModeratorEventsScrollableResponse : `[`ScrollableHelixResponse`](./index.html)`<`[`ModeratorEvent`](../../helix.moderation.model/-moderator-event/index.html)`>` |
| [ModeratorsScrollableHelixResponse](../../helix.moderation/-moderators-scrollable-helix-response/index.html) | `class ModeratorsScrollableHelixResponse : `[`ScrollableHelixResponse`](./index.html)`<`[`Moderator`](../../helix.moderation.model/-moderator/index.html)`>` |
| [ScrollableClipsResponse](../../helix.clips/-scrollable-clips-response/index.html) | `class ScrollableClipsResponse : `[`ScrollableHelixResponse`](./index.html)`<`[`Clip`](../../helix.clips.model/-clip/index.html)`>` |
| [ScrollableGamesResponse](../../helix.games/-scrollable-games-response/index.html) | `class ScrollableGamesResponse : `[`ScrollableHelixResponse`](./index.html)`<`[`Game`](../../helix.games.model/-game/index.html)`>` |
| [ScrollableVideosResponse](../../helix.videos/-scrollable-videos-response/index.html) | `class ScrollableVideosResponse : `[`ScrollableHelixResponse`](./index.html)`<`[`Video`](../../helix.videos.model/-video/index.html)`>` |
| [StreamsHelixResponse](../../helix.streams/-streams-helix-response/index.html) | `class StreamsHelixResponse : `[`ScrollableHelixResponse`](./index.html)`<`[`Stream`](../../helix.streams.model/-stream/index.html)`>` |
| [StreamsMetadataHelixResponse](../../helix.streams.metadata/-streams-metadata-helix-response/index.html) | `class StreamsMetadataHelixResponse : `[`ScrollableHelixResponse`](./index.html)`<`[`StreamMetadata`](../../helix.streams.metadata.model/-stream-metadata/index.html)`>` |
| [StreamTagsHelixResponse](../../helix.streams.tags/-stream-tags-helix-response/index.html) | `class StreamTagsHelixResponse : `[`ScrollableHelixResponse`](./index.html)`<`[`StreamTag`](../../helix.streams.tags.model/-stream-tag/index.html)`>` |
| [SubscriptionsHelixResponse](../../helix.subscriptions/-subscriptions-helix-response/index.html) | `class SubscriptionsHelixResponse : `[`ScrollableHelixResponse`](./index.html)`<`[`Subscription`](../../helix.subscriptions.model/-subscription/index.html)`>` |
| [TransactionsHelixResponse](../../helix.extensions/-transactions-helix-response/index.html) | `class TransactionsHelixResponse : `[`ScrollableHelixResponse`](./index.html)`<`[`ExtensionTransaction`](../../helix.extensions.model/-extension-transaction/index.html)`>` |
| [UsersHelixResponse](../../helix.users/-users-helix-response/index.html) | `class UsersHelixResponse : `[`ScrollableHelixResponse`](./index.html)`<`[`User`](../../helix.users.model/-user/index.html)`>` |
| [UserStreamMarkersResponse](../../helix.streams.markers/-user-stream-markers-response/index.html) | `class UserStreamMarkersResponse : `[`ScrollableHelixResponse`](./index.html)`<`[`UserStreamMarkers`](../../helix.streams.markers.model/-user-stream-markers/index.html)`>` |
| [WebhooksHelixResponse](../../helix.webhook/-webhooks-helix-response/index.html) | `class WebhooksHelixResponse : `[`ScrollableHelixResponse`](./index.html)`<`[`Webhook`](../../helix.webhook.model/-webhook/index.html)`>` |

