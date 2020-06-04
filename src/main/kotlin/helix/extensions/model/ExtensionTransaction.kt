package helix.extensions.model


import helix.http.model.AbstractResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ExtensionTransaction(
    @SerialName("id")
    val id: String,
    @SerialName("timestamp")
    val timestamp: String,
    @SerialName("broadcaster_id")
    val broadcasterId: String,
    @SerialName("broadcaster_name")
    val broadcasterName: String,
    @SerialName("user_id")
    val userId: String,
    @SerialName("user_name")
    val userName: String,
    @SerialName("product_type")
    val productType: String,
    @SerialName("product_data")
    val product: Product
) : AbstractResource()