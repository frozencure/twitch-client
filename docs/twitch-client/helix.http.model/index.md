---
title: helix.http.model -
---
//[twitch-client](../index.md)/[helix.http.model](index.md)



# Package helix.http.model  


## Types  
  
|  Name|  Summary| 
|---|---|
| [AbstractResource](-abstract-resource/index.md)| [jvm]  <br>Content  <br>abstract class [AbstractResource](-abstract-resource/index.md)  <br><br><br>
| [CollectionHelixResponse](-collection-helix-response/index.md)| [jvm]  <br>Content  <br>abstract class [CollectionHelixResponse](-collection-helix-response/index.md)<[T](-collection-helix-response/index.md) : [AbstractResource](-abstract-resource/index.md)> (**httpResponse**: [HttpResponse]()) : [HelixResponse](-helix-response/index.md)  <br><br><br>
| [DateRange](-date-range/index.md)| [jvm]  <br>Content  <br>data class [DateRange](-date-range/index.md)(**startedAt**: [Instant](https://docs.oracle.com/javase/8/docs/api/java/time/Instant.html)?,**endedAt**: [Instant](https://docs.oracle.com/javase/8/docs/api/java/time/Instant.html)?)  <br><br><br>
| [HelixDTO](-helix-d-t-o/index.md)| [jvm]  <br>Content  <br>data class [HelixDTO](-helix-d-t-o/index.md)<[T](-helix-d-t-o/index.md) : [AbstractResource](-abstract-resource/index.md)> (**resources**: [Collection](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)<[T](-helix-d-t-o/index.md)>?,**pagination**: [Pagination](-pagination/index.md)?,**total**: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)?,**dateRange**: [DateRange](-date-range/index.md)?)  <br><br><br>
| [HelixResponse](-helix-response/index.md)| [jvm]  <br>Content  <br>abstract class [HelixResponse](-helix-response/index.md)<[T](-helix-response/index.md) : [AbstractResource](-abstract-resource/index.md)> (**httpResponse**: [HttpResponse]())  <br><br><br>
| [Pagination](-pagination/index.md)| [jvm]  <br>Content  <br>data class [Pagination](-pagination/index.md)(**cursor**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?)  <br><br><br>
| [ScrollableHelixResponse](-scrollable-helix-response/index.md)| [jvm]  <br>Content  <br>abstract class [ScrollableHelixResponse](-scrollable-helix-response/index.md)<[T](-scrollable-helix-response/index.md) : [AbstractResource](-abstract-resource/index.md)> (**httpResponse**: [HttpResponse](),**httpClient**: [HttpClient]()) : [CollectionHelixResponse](-collection-helix-response/index.md)  <br><br><br>
| [SingleHelixResponse](-single-helix-response/index.md)| [jvm]  <br>Content  <br>abstract class [SingleHelixResponse](-single-helix-response/index.md)<[T](-single-helix-response/index.md) : [AbstractResource](-abstract-resource/index.md)> (**httpResponse**: [HttpResponse]()) : [HelixResponse](-helix-response/index.md)  <br><br><br>

