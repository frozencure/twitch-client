package helix.configuration

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DefaultApiCredentials(
    @SerialName("Client-ID")
    val clientId: String
)