package helix.auth.model.response

import helix.auth.model.AuthScope
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserToken(
    @SerialName("client_id")
    val clientId: String,
    @SerialName("login")
    val userLogin: String,
    @SerialName("scopes")
    val scopes: List<AuthScope>,
    @SerialName("user_id")
    val userId: String,
    @SerialName("expires_in")
    val expirationTime: Long
)