package com.github.frozencure.helix.auth.model.response

import com.github.frozencure.helix.auth.model.AuthScope
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * /**
 * A data transfer object for an OAuth user token.
 * @constructor Creates a new user token object.
 * @param clientId The client ID of the Twitch application.
 * @param userLogin The authorized user login information.
 * @param scopes The list of scopes that have been authorized.
 * @param userId The ID of the user the token relates to.
 * @param expiresInSeconds The number of seconds the token expires in.
*/
 */
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
    val expiresInSeconds: Int
)