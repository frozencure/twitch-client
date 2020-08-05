---
title: helix.users.model -
---
//[twitch-client](../index.md)/[helix.users.model](index.md)



# Package helix.users.model  


## Types  
  
|  Name|  Summary| 
|---|---|
| [BroadcasterType](-broadcaster-type/index.md)| [jvm]  <br>Content  <br>enum [BroadcasterType](-broadcaster-type/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)  <br><br><br>
| [ChangeFollowRequest](-change-follow-request/index.md)| [jvm]  <br>Content  <br>data class [ChangeFollowRequest](-change-follow-request/index.md)(**fromId**: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html),**toId**: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html),**allowNotifications**: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)?)  <br><br><br>
| [FollowEvent](-follow-event/index.md)| [jvm]  <br>Content  <br>data class [FollowEvent](-follow-event/index.md)(**fromUserId**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html),**fromUserName**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html),**toUserId**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html),**toUserName**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html),**followedAt**: [Instant](https://docs.oracle.com/javase/8/docs/api/java/time/Instant.html)) : [AbstractResource](../helix.http.model/-abstract-resource/index.md)  <br><br><br>
| [User](-user/index.md)| [jvm]  <br>Content  <br>data class [User](-user/index.md)(**id**: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html),**login**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html),**displayName**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html),**type**: [UserType](-user-type/index.md),**broadcasterType**: [BroadcasterType](-broadcaster-type/index.md),**description**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?,**profileImageUrl**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html),**offlineImageUrl**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?,**viewCount**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html),**email**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?) : [AbstractResource](../helix.http.model/-abstract-resource/index.md)  <br><br><br>
| [UserType](-user-type/index.md)| [jvm]  <br>Content  <br>enum [UserType](-user-type/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)  <br><br><br>

