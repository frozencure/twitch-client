---
title: UserService -
---
//[twitch-client](../../index.md)/[helix.users](../index.md)/[UserService](index.md)



# UserService  
 [jvm] class [UserService](index.md) : [ResourceService](../../helix.http/-resource-service/index.md)   


## Constructors  
  
|  Name|  Summary| 
|---|---|
| [<init>](-init-.md)|  [jvm] fun [<init>](-init-.md)(apiSettings: [ApiSettings](../../helix.http.credentials/-api-settings/index.md), httpClientEngineConfig: [HttpClientEngineConfig]())   <br>
| [<init>](-init-.md)|  [jvm] fun [<init>](-init-.md)(httpClient: [HttpClient]())   <br>


## Types  
  
|  Name|  Summary| 
|---|---|
| [Companion](-companion/index.md)| [jvm]  <br>Content  <br>object [Companion](-companion/index.md)  <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| [createFollow](create-follow.md)| [jvm]  <br>Content  <br>suspend fun [createFollow](create-follow.md)(fromId: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), toId: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), allowNotifications: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): [HttpResponse]()  <br><br><br>
| [deleteFollow](delete-follow.md)| [jvm]  <br>Content  <br>suspend fun [deleteFollow](delete-follow.md)(fromId: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), toId: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)): [HttpResponse]()  <br><br><br>
| [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)| [jvm]  <br>Content  <br>open operator override fun [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [getUser](get-user.md)| [jvm]  <br>Content  <br>suspend fun [getUser](get-user.md)(): [UserHelixResponse](../-user-helix-response/index.md)  <br>suspend fun [getUser](get-user.md)(userId: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)): [UserHelixResponse](../-user-helix-response/index.md)  <br>suspend fun [getUser](get-user.md)(loginName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [UserHelixResponse](../-user-helix-response/index.md)  <br><br><br>
| [getUserExtensions](get-user-extensions.md)| [jvm]  <br>Content  <br>suspend fun [getUserExtensions](get-user-extensions.md)(): [ExtensionsHelixResponse](../../helix.extensions/-extensions-helix-response/index.md)  <br><br><br>
| [getUserFollowers](get-user-followers.md)| [jvm]  <br>Content  <br>suspend fun [getUserFollowers](get-user-followers.md)(fromUserId: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)?, toUserId: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)?, first: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)?): [FollowsHelixResponse](../-follows-helix-response/index.md)  <br><br><br>
| [getUsers](get-users.md)| [jvm]  <br>Content  <br>suspend fun [getUsers](get-users.md)(ids: [Collection](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)<[Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)>?, loginNames: [Collection](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)<[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)>?): [UsersHelixResponse](../-users-helix-response/index.md)  <br><br><br>
| [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)| [jvm]  <br>Content  <br>open override fun [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)| [jvm]  <br>Content  <br>open override fun [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>
| [updateUserDescription](update-user-description.md)| [jvm]  <br>Content  <br>suspend fun [updateUserDescription](update-user-description.md)(description: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [UserHelixResponse](../-user-helix-response/index.md)  <br><br><br>

