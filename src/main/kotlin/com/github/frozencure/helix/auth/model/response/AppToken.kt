package com.github.frozencure.helix.auth.model.response

import com.github.frozencure.helix.auth.model.AuthScope
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A data transfer object for an OAuth app token.
 * @constructor Creates a new app token object.
 * @param accessToken The OAuth access token.
 * @param refreshToken The OAuth refresh token (can be empty).
 * @param expiresInSeconds The number of seconds the token expires in.
 * @param scopes The list of scopes that have been authorized.
 * @param tokenType The type of token retrieved.
 */
@Serializable
data class AppToken(
    @SerialName("access_token")
    val accessToken: String,
    @SerialName("refresh_token")
    val refreshToken: String? = null,
    @SerialName("expires_in")
    val expiresInSeconds: Int,
    @SerialName("scope")
    val scopes: List<AuthScope>,
    @SerialName("token_type")
    val tokenType: String
)