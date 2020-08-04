---
title: AuthService - twitch-client
---

[twitch-client](../../index.html) / [helix.auth](../index.html) / [AuthService](./index.html)

# AuthService

`class AuthService`

### Constructors

| [&lt;init&gt;](-init-.html) | `AuthService(httpClientConfig: HttpClientEngineConfig)` |

### Functions

| [authorizeAppForUser](authorize-app-for-user.html) | `suspend fun authorizeAppForUser(requestModel: `[`OauthAuthorizeRequestModel`](../../helix.auth.model.request/-oauth-authorize-request-model/index.html)`): HttpResponse` |
| [revokeToken](revoke-token.html) | `suspend fun revokeToken(revokeModel: `[`OauthRevokeRequestModel`](../../helix.auth.model.request/-oauth-revoke-request-model/index.html)`): HttpResponse` |
| [validateUser](validate-user.html) | `suspend fun validateUser(token: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`TokenValidation`](../../helix.auth.model.response/-token-validation/index.html) |

