package helix.webhook.model


import helix.http.model.AbstractResource
import helix.util.DateSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.util.*

@Serializable
data class Webhook(
    @SerialName("topic")
    val topic: String,
    @SerialName("callback")
    val callback: String,
    @SerialName("expires_at")
    @Serializable(with = DateSerializer::class)
    val expiresAt: Date
) : AbstractResource()