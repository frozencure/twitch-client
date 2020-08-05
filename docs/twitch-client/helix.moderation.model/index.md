---
title: helix.moderation.model -
---
//[twitch-client](../index.md)/[helix.moderation.model](index.md)



# Package helix.moderation.model  


## Types  
  
|  Name|  Summary| 
|---|---|
| [AutoModMessage](-auto-mod-message/index.md)| [jvm]  <br>Content  <br>data class [AutoModMessage](-auto-mod-message/index.md)(**messageId**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html),**messageText**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html),**userId**: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html))  <br><br><br>
| [AutoModMessageStatus](-auto-mod-message-status/index.md)| [jvm]  <br>Content  <br>data class [AutoModMessageStatus](-auto-mod-message-status/index.md)(**messageId**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html),**isPermitted**: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) : [AbstractResource](../helix.http.model/-abstract-resource/index.md)  <br><br><br>
| [AutoModRequest](-auto-mod-request/index.md)| [jvm]  <br>Content  <br>data class [AutoModRequest](-auto-mod-request/index.md)(**data**: [Collection](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)<[AutoModMessage](-auto-mod-message/index.md)>)  <br><br><br>
| [BanEvent](-ban-event/index.md)| [jvm]  <br>Content  <br>data class [BanEvent](-ban-event/index.md)(**id**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html),**eventType**: [BanEventType](-ban-event-type/index.md),**eventTimestamp**: [Instant](https://docs.oracle.com/javase/8/docs/api/java/time/Instant.html),**version**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html),**eventData**: [ModerationEventData](-moderation-event-data/index.md)) : [AbstractResource](../helix.http.model/-abstract-resource/index.md)  <br><br><br>
| [BanEventType](-ban-event-type/index.md)| [jvm]  <br>Content  <br>enum [BanEventType](-ban-event-type/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)  <br><br><br>
| [BannedUser](-banned-user/index.md)| [jvm]  <br>Content  <br>data class [BannedUser](-banned-user/index.md)(**userId**: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html),**userName**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html),**expiresAt**: [Instant](https://docs.oracle.com/javase/8/docs/api/java/time/Instant.html)?) : [AbstractResource](../helix.http.model/-abstract-resource/index.md)  <br><br><br>
| [ModerationEventData](-moderation-event-data/index.md)| [jvm]  <br>Content  <br>data class [ModerationEventData](-moderation-event-data/index.md)(**broadcasterId**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html),**broadcasterName**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html),**userId**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html),**userName**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html),**expiresAt**: [Instant](https://docs.oracle.com/javase/8/docs/api/java/time/Instant.html)?)  <br><br><br>
| [Moderator](-moderator/index.md)| [jvm]  <br>Content  <br>data class [Moderator](-moderator/index.md)(**userId**: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html),**userName**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [AbstractResource](../helix.http.model/-abstract-resource/index.md)  <br><br><br>
| [ModeratorEvent](-moderator-event/index.md)| [jvm]  <br>Content  <br>data class [ModeratorEvent](-moderator-event/index.md)(**id**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html),**eventType**: [ModeratorEventType](-moderator-event-type/index.md),**eventTimestamp**: [Instant](https://docs.oracle.com/javase/8/docs/api/java/time/Instant.html),**version**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html),**eventData**: [ModerationEventData](-moderation-event-data/index.md)) : [AbstractResource](../helix.http.model/-abstract-resource/index.md)  <br><br><br>
| [ModeratorEventType](-moderator-event-type/index.md)| [jvm]  <br>Content  <br>enum [ModeratorEventType](-moderator-event-type/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)  <br><br><br>

