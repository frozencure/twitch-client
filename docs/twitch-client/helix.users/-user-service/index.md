---
title: UserService - twitch-client
---

[twitch-client](../../index.html) / [helix.users](../index.html) / [UserService](./index.html)

# UserService

`class UserService : `[`ResourceService`](../../helix.http/-resource-service/index.html)

### Constructors

| [&lt;init&gt;](-init-.html) | `UserService(apiSettings: `[`ApiSettings`](../../helix.http.credentials/-api-settings/index.html)`, httpClientEngineConfig: HttpClientEngineConfig)`<br>`UserService(httpClient: HttpClient)` |

### Functions

| [createFollow](create-follow.html) | `suspend fun createFollow(fromId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, toId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, allowNotifications: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false): HttpResponse` |
| [deleteFollow](delete-follow.html) | `suspend fun deleteFollow(fromId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, toId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): HttpResponse` |
| [getUser](get-user.html) | `suspend fun getUser(): `[`UserHelixResponse`](../-user-helix-response/index.html)<br>`suspend fun getUser(userId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`UserHelixResponse`](../-user-helix-response/index.html)<br>`suspend fun getUser(loginName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`UserHelixResponse`](../-user-helix-response/index.html) |
| [getUserExtensions](get-user-extensions.html) | `suspend fun getUserExtensions(): `[`ExtensionsHelixResponse`](../../helix.extensions/-extensions-helix-response/index.html) |
| [getUserFollowers](get-user-followers.html) | `suspend fun getUserFollowers(fromUserId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`? = null, toUserId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`? = null, first: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`? = 100): `[`FollowsHelixResponse`](../-follows-helix-response/index.html) |
| [getUsers](get-users.html) | `suspend fun getUsers(ids: `[`Collection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)`<`[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`>? = null, loginNames: `[`Collection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>? = null): `[`UsersHelixResponse`](../-users-helix-response/index.html) |
| [updateUserDescription](update-user-description.html) | `suspend fun updateUserDescription(description: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`UserHelixResponse`](../-user-helix-response/index.html) |

### Companion Object Properties

| [BASE_URL](-b-a-s-e_-u-r-l.html) | `const val BASE_URL: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

