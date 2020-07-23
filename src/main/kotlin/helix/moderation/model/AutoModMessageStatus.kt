package helix.moderation.model


import helix.http.model.AbstractResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AutoModMessageStatus(
    @SerialName("msg_id")
    val messageId: String,
    @SerialName("is_permitted")
    val isPermitted: Boolean
): AbstractResource()