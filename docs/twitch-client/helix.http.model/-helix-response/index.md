---
title: HelixResponse - twitch-client
---

[twitch-client](../../index.html) / [helix.http.model](../index.html) / [HelixResponse](./index.html)

# HelixResponse

`abstract class HelixResponse<T : `[`AbstractResource`](../-abstract-resource/index.html)`>`

### Constructors

| [&lt;init&gt;](-init-.html) | `HelixResponse(httpResponse: HttpResponse)` |

### Properties

| [helixDTO](helix-d-t-o.html) | `abstract val helixDTO: `[`HelixDTO`](../-helix-d-t-o/index.html)`<T>` |
| [httpResponse](http-response.html) | `val httpResponse: HttpResponse` |

### Inheritors

| [CollectionHelixResponse](../-collection-helix-response/index.html) | `abstract class CollectionHelixResponse<T : `[`AbstractResource`](../-abstract-resource/index.html)`> : `[`HelixResponse`](./index.html)`<T>` |
| [SingleHelixResponse](../-single-helix-response/index.html) | `abstract class SingleHelixResponse<T : `[`AbstractResource`](../-abstract-resource/index.html)`> : `[`HelixResponse`](./index.html)`<T>` |

