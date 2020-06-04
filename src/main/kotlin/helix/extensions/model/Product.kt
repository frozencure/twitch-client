package helix.extensions.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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