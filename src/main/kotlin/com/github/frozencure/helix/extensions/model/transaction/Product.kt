package com.github.frozencure.helix.extensions.model.transaction


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * An object that represents a product, a subject of an extension transaction.
 * @constructor Creates a new product.
 * @param productId The identifier of the product.
 * @param cost The cost of the product.
 * @param displayName The name of the product.
 * @param isInDevelopment Whether the product is still in development or not.
 */
@Serializable
data class Product(
    @SerialName("sku")
    val productId: String,
    @SerialName("cost")
    val cost: Cost,
    @SerialName("displayName")
    val displayName: String,
    @SerialName("inDevelopment")
    val isInDevelopment: Boolean
)