package helix.auth

import helix.auth.model.request.OauthAuthorizeRequestModel
import helix.auth.model.request.OauthRevokeRequestModel
import helix.auth.model.response.TokenValidation
import helix.extension.headersOfSerializableObject
import helix.extension.parametersOfSerializableObject
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.statement.HttpResponse
import kotlinx.serialization.ImplicitReflectionSerializer
import kotlinx.serialization.Properties

class AuthService(
    private val httpClientConfig: HttpClientEngineConfig
) {
    private val httpClient: HttpClient = HttpClient {
        engine { httpClientConfig }
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
    }

    @ImplicitReflectionSerializer
    suspend fun authorizeApplicationForUser(requestModel: OauthAuthorizeRequestModel): HttpResponse {
        return httpClient.get("https://id.twitch.tv/oauth2/authorize") {
            parametersOfSerializableObject(requestModel)
        }
    }


    @ImplicitReflectionSerializer
    suspend fun revokeToken(revokeModel: OauthRevokeRequestModel): HttpResponse {
        return httpClient.post("https://id.twitch.tv/oauth2/revoke") {
            headersOfSerializableObject(Properties.store(revokeModel))
        }
    }


    @ImplicitReflectionSerializer
    suspend fun validateUser(token: String): TokenValidation {
        return httpClient.get("https://id.twitch.tv/oauth2/validate") {
            header("Authorization", "OAuth $token")
        }
    }


}