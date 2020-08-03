package helix.channels.model.commercial


import helix.http.model.AbstractResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Commercial(
    @SerialName("length")
    val length: Int,
    @SerialName("message")
    val message: String,
    @SerialName("retry_after")
    val retryAfter: Int
) : AbstractResource()