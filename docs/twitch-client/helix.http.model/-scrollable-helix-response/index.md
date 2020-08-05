---
title: ScrollableHelixResponse -
---
//[twitch-client](../../index.md)/[helix.http.model](../index.md)/[ScrollableHelixResponse](index.md)



# ScrollableHelixResponse  
 [jvm] abstract class [ScrollableHelixResponse](index.md)<[T](index.md) : [AbstractResource](../-abstract-resource/index.md)> (**httpResponse**: [HttpResponse](),**httpClient**: [HttpClient]()) : [CollectionHelixResponse](../-collection-helix-response/index.md)   


## Functions  
  
|  Name|  Summary| 
|---|---|
| [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)| [jvm]  <br>Content  <br>open operator override fun [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)| [jvm]  <br>Content  <br>open override fun [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [nextPage](next-page.md)| [jvm]  <br>Content  <br>abstract suspend fun [nextPage](next-page.md)(): [CollectionHelixResponse](../-collection-helix-response/index.md)<[T](index.md)>?  <br><br><br>
| [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)| [jvm]  <br>Content  <br>open override fun [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| [dateRange](index.md#helix.http.model/ScrollableHelixResponse/dateRange/#/PointingToDeclaration/)|  [jvm] override val [dateRange](index.md#helix.http.model/ScrollableHelixResponse/dateRange/#/PointingToDeclaration/): [DateRange](../-date-range/index.md)?   <br>
| [httpResponse](index.md#helix.http.model/ScrollableHelixResponse/httpResponse/#/PointingToDeclaration/)|  [jvm] override val [httpResponse](index.md#helix.http.model/ScrollableHelixResponse/httpResponse/#/PointingToDeclaration/): [HttpResponse]()   <br>
| [pagination](index.md#helix.http.model/ScrollableHelixResponse/pagination/#/PointingToDeclaration/)|  [jvm] override val [pagination](index.md#helix.http.model/ScrollableHelixResponse/pagination/#/PointingToDeclaration/): [Pagination](../-pagination/index.md)?   <br>
| [resources](index.md#helix.http.model/ScrollableHelixResponse/resources/#/PointingToDeclaration/)|  [jvm] override val [resources](index.md#helix.http.model/ScrollableHelixResponse/resources/#/PointingToDeclaration/): [Collection](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)<[T](index.md)>   <br>
| [total](index.md#helix.http.model/ScrollableHelixResponse/total/#/PointingToDeclaration/)|  [jvm] override val [total](index.md#helix.http.model/ScrollableHelixResponse/total/#/PointingToDeclaration/): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)?   <br>


## Inheritors  
  
|  Name| 
|---|
| [ChannelsHelixResponse](../../helix.channels/-channels-helix-response/index.md)
| [HypeTrainScrollableResponse](../../helix.channels/-hype-train-scrollable-response/index.md)
| [ScrollableClipsResponse](../../helix.clips/-scrollable-clips-response/index.md)
| [TransactionsHelixResponse](../../helix.extensions/-transactions-helix-response/index.md)
| [ScrollableGamesResponse](../../helix.games/-scrollable-games-response/index.md)
| [BanEventsScrollableResponse](../../helix.moderation/-ban-events-scrollable-response/index.md)
| [BannedUsersScrollableResponse](../../helix.moderation/-banned-users-scrollable-response/index.md)
| [ModeratorEventsScrollableResponse](../../helix.moderation/-moderator-events-scrollable-response/index.md)
| [ModeratorsScrollableHelixResponse](../../helix.moderation/-moderators-scrollable-helix-response/index.md)
| [StreamsHelixResponse](../../helix.streams/-streams-helix-response/index.md)
| [UserStreamMarkersResponse](../../helix.streams.markers/-user-stream-markers-response/index.md)
| [StreamsMetadataHelixResponse](../../helix.streams.metadata/-streams-metadata-helix-response/index.md)
| [StreamTagsHelixResponse](../../helix.streams.tags/-stream-tags-helix-response/index.md)
| [SubscriptionsHelixResponse](../../helix.subscriptions/-subscriptions-helix-response/index.md)
| [FollowsHelixResponse](../../helix.users/-follows-helix-response/index.md)
| [UsersHelixResponse](../../helix.users/-users-helix-response/index.md)
| [ScrollableVideosResponse](../../helix.videos/-scrollable-videos-response/index.md)
| [WebhooksHelixResponse](../../helix.webhook/-webhooks-helix-response/index.md)

