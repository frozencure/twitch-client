---
title: ModerationService -
---
//[twitch-client](../../index.md)/[helix.moderation](../index.md)/[ModerationService](index.md)



# ModerationService  
 [jvm] class [ModerationService](index.md) : [ResourceService](../../helix.http/-resource-service/index.md)   


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
| [checkMessagesWithAutoMod](check-messages-with-auto-mod.md)| [jvm]  <br>Content  <br>suspend fun [checkMessagesWithAutoMod](check-messages-with-auto-mod.md)(broadcasterId: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), messages: [Collection](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)<[AutoModMessage](../../helix.moderation.model/-auto-mod-message/index.md)>): [AutoModHelixResponse](../-auto-mod-helix-response/index.md)  <br><br><br>
| [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)| [jvm]  <br>Content  <br>open operator override fun [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [getBanEvents](get-ban-events.md)| [jvm]  <br>Content  <br>suspend fun [getBanEvents](get-ban-events.md)(broadcasterId: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), userIds: [Collection](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)<[Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)>?, first: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [BanEventsScrollableResponse](../-ban-events-scrollable-response/index.md)  <br><br><br>
| [getBannedUsers](get-banned-users.md)| [jvm]  <br>Content  <br>suspend fun [getBannedUsers](get-banned-users.md)(broadcasterId: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), userIds: [Collection](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)<[Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)>?): [BannedUsersScrollableResponse](../-banned-users-scrollable-response/index.md)  <br><br><br>
| [getModeratorEvents](get-moderator-events.md)| [jvm]  <br>Content  <br>suspend fun [getModeratorEvents](get-moderator-events.md)(broadcasterId: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), userIds: [Collection](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)<[Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)>?): [ModeratorEventsScrollableResponse](../-moderator-events-scrollable-response/index.md)  <br><br><br>
| [getModerators](get-moderators.md)| [jvm]  <br>Content  <br>suspend fun [getModerators](get-moderators.md)(broadcasterId: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), userIds: [Collection](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)<[Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)>?): [ModeratorsScrollableHelixResponse](../-moderators-scrollable-helix-response/index.md)  <br><br><br>
| [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)| [jvm]  <br>Content  <br>open override fun [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)| [jvm]  <br>Content  <br>open override fun [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>

