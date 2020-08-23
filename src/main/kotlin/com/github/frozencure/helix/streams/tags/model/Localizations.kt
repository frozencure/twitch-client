package com.github.frozencure.helix.streams.tags.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Localizations(
    @SerialName("bg-bg")
    val bulgarian: String? = null,
    @SerialName("cs-cz")
    val czech: String? = null,
    @SerialName("da-dk")
    val danish: String? = null,
    @SerialName("de-de")
    val german: String? = null,
    @SerialName("el-gr")
    val greek: String? = null,
    @SerialName("en-us")
    val english: String? = null,
    @SerialName("es-es")
    val spanish: String? = null,
    @SerialName("es-mx")
    val spanishMexico: String? = null,
    @SerialName("fi-fi")
    val finish: String? = null,
    @SerialName("fr-fr")
    val french: String? = null,
    @SerialName("hu-hu")
    val hungarian: String? = null,
    @SerialName("it-it")
    val italian: String? = null,
    @SerialName("ja-jp")
    val japanese: String? = null,
    @SerialName("ko-kr")
    val korean: String? = null,
    @SerialName("nl-nl")
    val dutch: String? = null,
    @SerialName("no-no")
    val norwegian: String? = null,
    @SerialName("pl-pl")
    val polish: String? = null,
    @SerialName("pt-br")
    val portugueseBrazilian: String? = null,
    @SerialName("pt-pt")
    val portuguesePortugal: String? = null,
    @SerialName("ro-ro")
    val romanian: String? = null,
    @SerialName("ru-ru")
    val russian: String? = null,
    @SerialName("sk-sk")
    val slovak: String? = null,
    @SerialName("sv-se")
    val swedish: String? = null,
    @SerialName("th-th")
    val thai: String? = null,
    @SerialName("tr-tr")
    val turkish: String? = null,
    @SerialName("vi-vn")
    val vietnamese: String? = null,
    @SerialName("zh-cn")
    val chineseChina: String? = null,
    @SerialName("zh-tw")
    val chineseTaiwan: String? = null
)