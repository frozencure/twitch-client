---
title: CollectionHelixResponse -
---
//[twitch-client](../../index.md)/[helix.http.model](../index.md)/[CollectionHelixResponse](index.md)



# CollectionHelixResponse  
 [jvm] abstract class [CollectionHelixResponse](index.md)<[T](index.md) : [AbstractResource](../-abstract-resource/index.md)> (**httpResponse**: [HttpResponse]()) : [HelixResponse](../-helix-response/index.md)   


## Functions  
  
|  Name|  Summary| 
|---|---|
| [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)| [jvm]  <br>Content  <br>open operator override fun [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)| [jvm]  <br>Content  <br>open override fun [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)| [jvm]  <br>Content  <br>open override fun [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| [dateRange](index.md#helix.http.model/CollectionHelixResponse/dateRange/#/PointingToDeclaration/)|  [jvm] val [dateRange](index.md#helix.http.model/CollectionHelixResponse/dateRange/#/PointingToDeclaration/): [DateRange](../-date-range/index.md)?   <br>
| [httpResponse](index.md#helix.http.model/CollectionHelixResponse/httpResponse/#/PointingToDeclaration/)|  [jvm] override val [httpResponse](index.md#helix.http.model/CollectionHelixResponse/httpResponse/#/PointingToDeclaration/): [HttpResponse]()   <br>
| [pagination](index.md#helix.http.model/CollectionHelixResponse/pagination/#/PointingToDeclaration/)|  [jvm] val [pagination](index.md#helix.http.model/CollectionHelixResponse/pagination/#/PointingToDeclaration/): [Pagination](../-pagination/index.md)?   <br>
| [resources](index.md#helix.http.model/CollectionHelixResponse/resources/#/PointingToDeclaration/)|  [jvm] val [resources](index.md#helix.http.model/CollectionHelixResponse/resources/#/PointingToDeclaration/): [Collection](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)<[T](index.md)>   <br>
| [total](index.md#helix.http.model/CollectionHelixResponse/total/#/PointingToDeclaration/)|  [jvm] val [total](index.md#helix.http.model/CollectionHelixResponse/total/#/PointingToDeclaration/): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)?   <br>


## Inheritors  
  
|  Name| 
|---|
| [BitsLeaderboardResponse](../../helix.bits/-bits-leaderboard-response/index.md)
| [ClipsHelixResponse](../../helix.clips/-clips-helix-response/index.md)
| [ExtensionsHelixResponse](../../helix.extensions/-extensions-helix-response/index.md)
| [GamesHelixResponse](../../helix.games/-games-helix-response/index.md)
| [ScrollableHelixResponse](../-scrollable-helix-response/index.md)
| [AutoModHelixResponse](../../helix.moderation/-auto-mod-helix-response/index.md)
| [VideosHelixResponse](../../helix.videos/-videos-helix-response/index.md)

