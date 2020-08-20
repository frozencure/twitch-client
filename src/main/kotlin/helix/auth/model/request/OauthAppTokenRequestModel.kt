package helix.auth.model.request

import helix.auth.model.AuthScope
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Model used as payload to make the OAuth app token request.
 * @constructor Creates a new OAuth token request model.
 * @param clientId The client ID of the Twitch application. Can be found in the Twitch Developer console.
 * @param clientSecret The client secret of the Twitch application. Can be found in the Twitch Developer console.
 * @param scopes The list of scopes that will be authorized.
 * @param grantType The grant type, will always be *client_credentials*.
 */
@Serializable
data class OauthAppTokenRequestModel(
    @SerialName("client_id")
    val clientId: String,
    @SerialName("client_secret")
    val clientSecret: String,
    @Serializable(with = AuthScopeListSerializer::class)
    @SerialName("scope")
    val scopes: List<AuthScope>? = null,
    @SerialName("grant_type")
    val grantType: String = "client_credentials"
)