package com.github.frozencure.helix.extensions.model.transaction


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * An object that represents the cost to acquire an extension product.
 * @constructor Creates a new cost object.
 * @param amount The amount that needs to be payed using the [type] currency.
 * @param type The type of currency, for example Bits.
 */
@Serializable
data class Cost(
    @SerialName("amount")
    val amount: Int,
    @SerialName("type")
    val type: String
)