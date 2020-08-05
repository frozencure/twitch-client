---
title: ChannelService -
---
//[twitch-client](../../index.md)/[helix.channels](../index.md)/[ChannelService](index.md)



# ChannelService  
 [jvm] class [ChannelService](index.md) : [ResourceService](../../helix.http/-resource-service/index.md)   


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
| [getChannels](get-channels.md)| [jvm]  <br>Content  <br>suspend fun [getChannels](get-channels.md)(query: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), liveOnly: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), first: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [ChannelsHelixResponse](../-channels-helix-response/index.md)  <br><br><br>
| [getHypeTrainEvents](get-hype-train-events.md)| [jvm]  <br>Content  <br>suspend fun [getHypeTrainEvents](get-hype-train-events.md)(broadcasterId: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), eventId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, first: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [HypeTrainScrollableResponse](../-hype-train-scrollable-response/index.md)  <br><br><br>
| [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)| [jvm]  <br>Content  <br>open override fun [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [modifyChannelInfo](modify-channel-info.md)| [jvm]  <br>Content  <br>suspend fun [modifyChannelInfo](modify-channel-info.md)(broadcasterId: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), title: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, gameId: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)?, language: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?): [HttpResponse]()  <br><br><br>
| [startCommercial](start-commercial.md)| [jvm]  <br>Content  <br>suspend fun [startCommercial](start-commercial.md)(broadcasterId: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), length: [CommercialLength](../../helix.channels.model.commercial/-commercial-length/index.md)): [CommercialResponse](../-commercial-response/index.md)  <br><br><br>
| [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)| [jvm]  <br>Content  <br>open override fun [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>

