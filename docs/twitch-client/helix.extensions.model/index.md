---
title: helix.extensions.model -
---
//[twitch-client](../index.md)/[helix.extensions.model](index.md)



# Package helix.extensions.model  


## Types  
  
|  Name|  Summary| 
|---|---|
| [Cost](-cost/index.md)| [jvm]  <br>Content  <br>data class [Cost](-cost/index.md)(**amount**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html),**type**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))  <br><br><br>
| [Extension](-extension/index.md)| [jvm]  <br>Content  <br>data class [Extension](-extension/index.md)(**id**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html),**version**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html),**name**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html),**canActivate**: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html),**type**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[ExtensionType](-extension-type/index.md)>) : [AbstractResource](../helix.http.model/-abstract-resource/index.md)  <br><br><br>
| [ExtensionTransaction](-extension-transaction/index.md)| [jvm]  <br>Content  <br>data class [ExtensionTransaction](-extension-transaction/index.md)(**id**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html),**timestamp**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html),**broadcasterId**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html),**broadcasterName**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html),**userId**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html),**userName**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html),**productType**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html),**product**: [Product](-product/index.md)) : [AbstractResource](../helix.http.model/-abstract-resource/index.md)  <br><br><br>
| [ExtensionType](-extension-type/index.md)| [jvm]  <br>Content  <br>enum [ExtensionType](-extension-type/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)  <br><br><br>
| [Product](-product/index.md)| [jvm]  <br>Content  <br>data class [Product](-product/index.md)(**productId**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html),**cost**: [Cost](-cost/index.md),**displayName**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html),**isInDevelopment**: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html))  <br><br><br>

