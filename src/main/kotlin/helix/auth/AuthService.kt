package helix.auth

import helix.auth.model.request.OauthAppTokenRequestModel
import helix.auth.model.request.OauthRevokeRequestModel
import helix.auth.model.request.OauthUserTokenRequestModel
import helix.auth.model.response.AppToken
import helix.auth.model.response.UserToken
import helix.http.extensions.headersOfSerializableObject
import helix.http.extensions.parametersOfSerializableObject
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.apache.*
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.statement.HttpResponse
import kotlinx.serialization.ImplicitReflectionSerializer
import kotlinx.serialization.Properties

/**
 * Service class that can be used to perform different authentication actions for the Twitch Helix API,
 * like requesting access tokens, revoking tokens and validationg users.
 * @constructor Creates a new authentication service instance, given a HTTP client engine configuration.
 * @param httpClientConfig The HTTP client engine configuration. An Apache engine is used by default.
 */
class AuthService(
    private val httpClientConfig: HttpClientEngineConfig = ApacheEngineConfig()
) {
    private val httpClient: HttpClient = HttpClient {
        engine { httpClientConfig }
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
    }

    /**
     * Triggers an OAuth implicit code flow, at the end of which a user access token will be retrieved.
     * For more information visit the [Twitch Authentication Guide](https://dev.twitch.tv/docs/authentication/getting-tokens-oauth#oauth-implicit-code-flow).
     * @param requestModel The user token request model, that holds information about the current app and the app scopes that will be authorized.
     * @sample samples.authenticateUser
     * @return @return A HTTP response object.
     */
    @ImplicitReflectionSerializer
    suspend fun requestUserToken(requestModel: OauthUserTokenRequestModel): HttpResponse {
        return httpClient.get("https://id.twitch.tv/oauth2/authorize") {
            parametersOfSerializableObject(requestModel)
        }
    }

    /**
     * Retrieves an OAuth app access token. Performs an OAuth client credentials flow.
     * For more information visit the [Twitch Authentication Guide](https://dev.twitch.tv/docs/authentication/getting-tokens-oauth#oauth-client-credentials-flow)
     * @param requestModel The user token request model, that holds information about the current app and the app scopes that will be authorized.
     * @return An app token object that holds information about the authorized scopes and the expiration time of the token.
     * @sample samples.authenticateApp
     */
    @ImplicitReflectionSerializer
    suspend fun requestAppToken(requestModel: OauthAppTokenRequestModel): AppToken {
        return httpClient.post("https://id.twitch.tv/oauth2/token") {
            parametersOfSerializableObject(requestModel)
        }
    }


    /**
     * Used to clean up previously obtained access tokens.
     * For more information visit the [Twitch Authentication Guide](https://dev.twitch.tv/docs/authentication#revoking-access-tokens)
     * @param revokeModel The revoke request model, that holds information about the current app and the token that will be revoked.
     * @return A HTTP response object.
     */
    @ImplicitReflectionSerializer
    suspend fun revokeToken(revokeModel: OauthRevokeRequestModel): HttpResponse {
        return httpClient.post("https://id.twitch.tv/oauth2/revoke") {
            headersOfSerializableObject(Properties.store(revokeModel))
        }
    }

    /**
     * If you use Twitch authentication for login purposes only,
     * access tokens should be validated on a recurring interval.
     * Periodic validation of previously issued OAuth tokens ensures that
     * users who authorized your application have not decided to disconnect the integration.
     * For more information visit the [Twitch Authentication Guide](https://dev.twitch.tv/docs/authentication#validating-requests)
     * @param token The token that will be validated.
     * @return A user token object that contains information about the authorized scopes and the expiration time of the token.
     */
    suspend fun validateUser(token: String): UserToken {
        return httpClient.get("https://id.twitch.tv/oauth2/validate") {
            header("Authorization", "OAuth $token")
        }
    }


}