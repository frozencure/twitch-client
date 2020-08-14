package helix.auth.model.response


import helix.auth.model.AuthScope
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AppToken(
    @SerialName("access_token")
    val accessToken: String,
    @SerialName("refresh_token")
    val refreshToken: String? = null,
    @SerialName("expires_in")
    val expiresIn: Int,
    @SerialName("scope")
    val scope: List<AuthScope>,
    @SerialName("token_type")
    val tokenType: String
)