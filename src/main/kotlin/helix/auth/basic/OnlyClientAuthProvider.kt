package helix.auth.basic

import io.ktor.client.features.auth.Auth
import io.ktor.client.features.auth.AuthProvider
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.http.auth.AuthScheme
import io.ktor.http.auth.HttpAuthHeader

fun Auth.onlyClient(block: OnlyClientAuthConfig.() -> Unit) {
    with(OnlyClientAuthConfig().apply(block)) {
        providers.add(OnlyClientAuthProvider(clientId, clientKey, sendWithoutRequest))
    }
}


class OnlyClientAuthProvider(
    private val clientId: String,
    private val clientKey: String,
    override val sendWithoutRequest: Boolean
) : AuthProvider {
    override fun isApplicable(auth: HttpAuthHeader): Boolean {
        if (auth.authScheme != AuthScheme.Basic) return false

        return true
    }

    override suspend fun addRequestHeaders(request: HttpRequestBuilder) {
        request.headers[clientKey] = clientId
    }
}