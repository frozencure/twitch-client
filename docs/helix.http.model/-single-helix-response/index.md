---
title: SingleHelixResponse - twitch-client
---

[twitch-client](../../index.html) / [helix.http.model](../index.html) / [SingleHelixResponse](./index.html)

# SingleHelixResponse

`abstract class SingleHelixResponse<T : `[`AbstractResource`](../-abstract-resource/index.html)`> : `[`HelixResponse`](../-helix-response/index.html)`<T>`

### Constructors

| [&lt;init&gt;](-init-.html) | `SingleHelixResponse(httpResponse: HttpResponse)` |

### Properties

| [resource](resource.html) | `val resource: T?` |

### Inheritors

| [ClipCreationHelixResponse](../../helix.clips/-clip-creation-helix-response/index.html) | `class ClipCreationHelixResponse : `[`SingleHelixResponse`](./index.html)`<`[`ClipCreation`](../../helix.clips.model/-clip-creation/index.html)`>` |
| [ClipHelixResponse](../../helix.clips/-clip-helix-response/index.html) | `class ClipHelixResponse : `[`SingleHelixResponse`](./index.html)`<`[`Clip`](../../helix.clips.model/-clip/index.html)`>` |
| [CommercialResponse](../../helix.channels/-commercial-response/index.html) | `class CommercialResponse : `[`SingleHelixResponse`](./index.html)`<`[`Commercial`](../../helix.channels.model.commercial/-commercial/index.html)`>` |
| [ExtensionHelixResponse](../../helix.extensions/-extension-helix-response/index.html) | `class ExtensionHelixResponse : `[`SingleHelixResponse`](./index.html)`<`[`Extension`](../../helix.extensions.model/-extension/index.html)`>` |
| [FollowHelixResponse](../../helix.users/-follow-helix-response/index.html) | `class FollowHelixResponse : `[`SingleHelixResponse`](./index.html)`<`[`FollowEvent`](../../helix.users.model/-follow-event/index.html)`>` |
| [GameHelixResponse](../../helix.games/-game-helix-response/index.html) | `class GameHelixResponse : `[`SingleHelixResponse`](./index.html)`<`[`Game`](../../helix.games.model/-game/index.html)`>` |
| [StreamKeyResponse](../../helix.streams/-stream-key-response/index.html) | `class StreamKeyResponse : `[`SingleHelixResponse`](./index.html)`<`[`StreamKey`](../../helix.streams.key/-stream-key/index.html)`>` |
| [StreamMarkerHelixResponse](../../helix.streams.markers/-stream-marker-helix-response/index.html) | `class StreamMarkerHelixResponse : `[`SingleHelixResponse`](./index.html)`<`[`StreamMarker`](../../helix.streams.markers.model/-stream-marker/index.html)`>` |
| [UserHelixResponse](../../helix.users/-user-helix-response/index.html) | `class UserHelixResponse : `[`SingleHelixResponse`](./index.html)`<`[`User`](../../helix.users.model/-user/index.html)`>` |
| [VideoHelixResponse](../../helix.videos/-video-helix-response/index.html) | `class VideoHelixResponse : `[`SingleHelixResponse`](./index.html)`<`[`Video`](../../helix.videos.model/-video/index.html)`>` |

