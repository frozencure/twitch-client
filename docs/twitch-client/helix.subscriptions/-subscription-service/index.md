---
title: SubscriptionService - twitch-client
---

[twitch-client](../../index.html) / [helix.subscriptions](../index.html) / [SubscriptionService](./index.html)

# SubscriptionService

`class SubscriptionService : `[`ResourceService`](../../helix.http/-resource-service/index.html)

### Constructors

| [&lt;init&gt;](-init-.html) | `SubscriptionService(apiSettings: `[`ApiSettings`](../../helix.http.credentials/-api-settings/index.html)`, httpClientEngineConfig: HttpClientEngineConfig)`<br>`SubscriptionService(httpClient: HttpClient)` |

### Functions

| [getSubscriptions](get-subscriptions.html) | `suspend fun getSubscriptions(broadcasterId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, userId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`? = null): `[`SubscriptionsHelixResponse`](../-subscriptions-helix-response/index.html) |

### Companion Object Properties

| [BASE_URL](-b-a-s-e_-u-r-l.html) | `const val BASE_URL: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

