package com.github.frozencure.helix.extensions.model.transaction


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Cost(
    @SerialName("amount")
    val amount: Int,
    @SerialName("type")
    val type: String
)