package com.github.frozencure.helix.auth.model.request

import com.github.frozencure.helix.shared.Mappable
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
) : Mappable {
    override fun toMap(): Map<String, Any?> {
        return mapOf(
            "client_id" to clientId,
            "authToken" to authToken
        )
    }

}
