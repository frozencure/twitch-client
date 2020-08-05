---
title: helix.channels.model.hypetrain -
---
//[twitch-client](../index.md)/[helix.channels.model.hypetrain](index.md)



# Package helix.channels.model.hypetrain  


## Types  
  
|  Name|  Summary| 
|---|---|
| [Contribution](-contribution/index.md)| [jvm]  <br>Content  <br>data class [Contribution](-contribution/index.md)(**total**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html),**type**: [ContributionType](-contribution-type/index.md),**userId**: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html))  <br><br><br>
| [ContributionType](-contribution-type/index.md)| [jvm]  <br>Content  <br>enum [ContributionType](-contribution-type/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)  <br><br><br>
| [HypeTrain](-hype-train/index.md)| [jvm]  <br>Content  <br>data class [HypeTrain](-hype-train/index.md)(**id**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html),**eventType**: [HypeTrainType](-hype-train-type/index.md),**eventTimestamp**: [Instant](https://docs.oracle.com/javase/8/docs/api/java/time/Instant.html),**version**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html),**eventData**: [HypeTrainData](-hype-train-data/index.md)) : [AbstractResource](../helix.http.model/-abstract-resource/index.md)  <br><br><br>
| [HypeTrainData](-hype-train-data/index.md)| [jvm]  <br>Content  <br>data class [HypeTrainData](-hype-train-data/index.md)(**broadcasterId**: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html),**cooldownEndTime**: [Instant](https://docs.oracle.com/javase/8/docs/api/java/time/Instant.html),**expiresAt**: [Instant](https://docs.oracle.com/javase/8/docs/api/java/time/Instant.html),**goal**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html),**id**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html),**lastContribution**: [Contribution](-contribution/index.md),**level**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html),**startedAt**: [Instant](https://docs.oracle.com/javase/8/docs/api/java/time/Instant.html),**topContributions**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Contribution](-contribution/index.md)>,**total**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html))  <br><br><br>
| [HypeTrainType](-hype-train-type/index.md)| [jvm]  <br>Content  <br>enum [HypeTrainType](-hype-train-type/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)  <br><br><br>

