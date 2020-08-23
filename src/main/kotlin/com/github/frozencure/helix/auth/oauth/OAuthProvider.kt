package com.github.frozencure.helix.auth.oauth

import io.ktor.client.features.auth.Auth
import io.ktor.client.features.auth.AuthProvider
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.http.HttpHeaders
import io.ktor.http.auth.AuthScheme
import io.ktor.http.auth.HttpAuthHeader

/**
 * The OAuth Twitch Helix authentication, where a client ID as well as a OAuth token are used.
 * Can be used with both user- and app access tokens.
 */
fun Auth.oauth(block: OAuthConfig.() -> Unit) {
    with(OAuthConfig().apply(block)) {
        providers.add(OAuthProvider(clientId, clientKey, token, sendWithoutRequest))
    }
}



internal class OAuthProvider(
    private val clientId: String,
    private val clientKey: String,
    private val token: String,
    override val sendWithoutRequest: Boolean
) : AuthProvider {

    override fun isApplicable(auth: HttpAuthHeader): Boolean {
        if (auth.authScheme != AuthScheme.OAuth) return false

        return true
    }

    override suspend fun addRequestHeaders(request: HttpRequestBuilder) {
        request.headers[HttpHeaders.Authorization] = "Bearer $token"
        request.headers[clientKey] = clientId
    }
}