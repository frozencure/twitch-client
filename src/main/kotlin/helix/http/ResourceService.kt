package helix.http

import helix.auth.basic.OnlyClientAuthConfig
import helix.auth.basic.onlyClient
import helix.auth.oauth.OAuthConfig
import helix.auth.oauth.oauth
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.features.auth.Auth
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer

abstract class ResourceService(
    protected val httpClient: HttpClient
) {
    constructor(httpClientEngineConfig: HttpClientEngineConfig, authSettings: OnlyClientAuthConfig)
            : this(HttpClient {
        engine { httpClientEngineConfig }
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
//        install(Auth) {
//            if(authSettings is OAuthConfig) {
//                oauth {
//                    clientId = authSettings.clientId
//                    clientKey = authSettings.clientKey
//                    token = authSettings.token
//                }
//            } else {
//                onlyClient {
//                    clientId = authSettings.clientId
//                    clientKey = authSettings.clientKey
//                }
//            }
//        }
//        defaultRequest {
//            headersOfSerializableObject(apiSettings.credentials)
//        }
    })

    companion object {
        const val BASE_URL = "https://api.twitch.tv/helix"
    }

}