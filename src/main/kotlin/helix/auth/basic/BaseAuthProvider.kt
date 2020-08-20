package helix.auth.basic

import io.ktor.client.features.auth.Auth
import io.ktor.client.features.auth.AuthProvider
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.http.auth.HttpAuthHeader

/**
 * The default Twitch Helix authentication, where only a client ID is used and no token. Works only for some endpoints.
 */
fun Auth.default(block: BaseAuthConfig.() -> Unit) {
    with(BaseAuthConfig().apply(block)) {
        providers.add(BaseAuthProvider(clientId, clientKey, sendWithoutRequest))
    }
}


internal class BaseAuthProvider(
    private val clientId: String,
    private val clientKey: String,
    override val sendWithoutRequest: Boolean
) : AuthProvider {
    override fun isApplicable(auth: HttpAuthHeader): Boolean {
        return true
    }

    override suspend fun addRequestHeaders(request: HttpRequestBuilder) {
        request.headers[clientKey] = clientId
    }
}