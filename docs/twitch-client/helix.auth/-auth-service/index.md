---
title: AuthService -
---
//[twitch-client](../../index.md)/[helix.auth](../index.md)/[AuthService](index.md)



# AuthService  
 [jvm] class [AuthService](index.md)(**httpClientConfig**: [HttpClientEngineConfig]())   


## Functions  
  
|  Name|  Summary| 
|---|---|
| [authorizeAppForUser](authorize-app-for-user.md)| [jvm]  <br>Content  <br>suspend fun [authorizeAppForUser](authorize-app-for-user.md)(requestModel: [OauthAuthorizeRequestModel](../../helix.auth.model.request/-oauth-authorize-request-model/index.md)): [HttpResponse]()  <br><br><br>
| [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)| [jvm]  <br>Content  <br>open operator override fun [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)| [jvm]  <br>Content  <br>open override fun [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [revokeToken](revoke-token.md)| [jvm]  <br>Content  <br>suspend fun [revokeToken](revoke-token.md)(revokeModel: [OauthRevokeRequestModel](../../helix.auth.model.request/-oauth-revoke-request-model/index.md)): [HttpResponse]()  <br><br><br>
| [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)| [jvm]  <br>Content  <br>open override fun [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>
| [validateUser](validate-user.md)| [jvm]  <br>Content  <br>suspend fun [validateUser](validate-user.md)(token: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [TokenValidation](../../helix.auth.model.response/-token-validation/index.md)  <br><br><br>

