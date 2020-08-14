package helix.auth.model.request

import helix.auth.model.AuthScope
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OauthAppTokenRequestModel(
    @SerialName("client_id")
    val clientId: String,
    @SerialName("client_secret")
    val clientSecret: String,
    @Serializable(with = AuthScopeListSerializer::class)
    @SerialName("scope")
    val scope: List<AuthScope>? = null,
    @SerialName("grant_type")
    val grantType: String = "client_credentials"
)