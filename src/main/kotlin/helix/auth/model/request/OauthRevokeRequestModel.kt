package helix.auth.model.request

import kotlinx.serialization.SerialName

/**
 * Model used as payload for revoking an user access token.
 * @constructor Creates a new revoke token request model.
 * @param clientId The client ID of the Twitch application.
 * @param authToken The authentication token that will be revoked.
 */
data class OauthRevokeRequestModel(
    @SerialName("client_id")
    val clientId: String,
    @SerialName("token")
    val authToken: String
)
