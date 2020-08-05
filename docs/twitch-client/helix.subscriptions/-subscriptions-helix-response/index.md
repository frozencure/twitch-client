---
title: SubscriptionsHelixResponse -
---
//[twitch-client](../../index.md)/[helix.subscriptions](../index.md)/[SubscriptionsHelixResponse](index.md)



# SubscriptionsHelixResponse  
 [jvm] class [SubscriptionsHelixResponse](index.md)(**httpResponse**: [HttpResponse](),**httpClient**: [HttpClient]()) : [ScrollableHelixResponse](../../helix.http.model/-scrollable-helix-response/index.md)   


## Functions  
  
|  Name|  Summary| 
|---|---|
| [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)| [jvm]  <br>Content  <br>open operator override fun [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)| [jvm]  <br>Content  <br>open override fun [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [nextPage](next-page.md)| [jvm]  <br>Content  <br>open suspend override fun [nextPage](next-page.md)(): [SubscriptionsHelixResponse](index.md)?  <br><br><br>
| [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)| [jvm]  <br>Content  <br>open override fun [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| [dateRange](index.md#helix.subscriptions/SubscriptionsHelixResponse/dateRange/#/PointingToDeclaration/)|  [jvm] override val [dateRange](index.md#helix.subscriptions/SubscriptionsHelixResponse/dateRange/#/PointingToDeclaration/): [DateRange](../../helix.http.model/-date-range/index.md)?   <br>
| [httpResponse](index.md#helix.subscriptions/SubscriptionsHelixResponse/httpResponse/#/PointingToDeclaration/)|  [jvm] override val [httpResponse](index.md#helix.subscriptions/SubscriptionsHelixResponse/httpResponse/#/PointingToDeclaration/): [HttpResponse]()   <br>
| [pagination](index.md#helix.subscriptions/SubscriptionsHelixResponse/pagination/#/PointingToDeclaration/)|  [jvm] override val [pagination](index.md#helix.subscriptions/SubscriptionsHelixResponse/pagination/#/PointingToDeclaration/): [Pagination](../../helix.http.model/-pagination/index.md)?   <br>
| [resources](index.md#helix.subscriptions/SubscriptionsHelixResponse/resources/#/PointingToDeclaration/)|  [jvm] override val [resources](index.md#helix.subscriptions/SubscriptionsHelixResponse/resources/#/PointingToDeclaration/): [Collection](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)<[Subscription](../../helix.subscriptions.model/-subscription/index.md)>   <br>
| [total](index.md#helix.subscriptions/SubscriptionsHelixResponse/total/#/PointingToDeclaration/)|  [jvm] override val [total](index.md#helix.subscriptions/SubscriptionsHelixResponse/total/#/PointingToDeclaration/): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)?   <br>

