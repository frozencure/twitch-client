---
title: SubscriptionService -
---
//[twitch-client](../../index.md)/[helix.subscriptions](../index.md)/[SubscriptionService](index.md)



# SubscriptionService  
 [jvm] class [SubscriptionService](index.md) : [ResourceService](../../helix.http/-resource-service/index.md)   


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
| [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)| [jvm]  <br>Content  <br>open operator override fun [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [getSubscriptions](get-subscriptions.md)| [jvm]  <br>Content  <br>suspend fun [getSubscriptions](get-subscriptions.md)(broadcasterId: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), userId: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)?): [SubscriptionsHelixResponse](../-subscriptions-helix-response/index.md)  <br><br><br>
| [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)| [jvm]  <br>Content  <br>open override fun [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)| [jvm]  <br>Content  <br>open override fun [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>

