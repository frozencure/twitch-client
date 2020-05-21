package helix.subscriptions.model


import helix.http.model.AbstractResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Subscription(
    @SerialName("broadcaster_id")
    val broadcasterId: String,
    @SerialName("broadcaster_name")
    val broadcasterName: String,
    @SerialName("is_gift")
    val isGift: Boolean,
    @SerialName("gifter_id")
    val gifterId: String? = null,
    @SerialName("gifter_name")
    val gifterName: String? = null,
    @SerialName("tier")
    val tier: String,
    @SerialName("plan_name")
    val planName: String,
    @SerialName("user_id")
    val userId: String,
    @SerialName("user_name")
    val userName: String
) : AbstractResource()