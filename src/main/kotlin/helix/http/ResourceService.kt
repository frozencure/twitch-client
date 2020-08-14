package helix.http

import helix.auth.basic.default
import helix.auth.model.AuthCredentials
import helix.auth.model.OAuthCredentials
import helix.auth.oauth.oauth
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.apache.ApacheEngineConfig
import io.ktor.client.features.auth.Auth
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer

abstract class ResourceService(
    protected val httpClient: HttpClient
) {
    constructor(
        credentials: AuthCredentials,
        httpClientEngineConfig: HttpClientEngineConfig = ApacheEngineConfig()
    )
            : this(HttpClient {
        engine { httpClientEngineConfig }
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
        install(Auth) {
            if (credentials is OAuthCredentials) {
                oauth {
                    clientId = credentials.clientId
                    clientKey = credentials.clientKey
                    token = credentials.token
                }
            } else {
                default {
                    clientId = credentials.clientId
                    clientKey = credentials.clientKey
                }
            }
        }
    })

    companion object {
        const val BASE_URL = "https://api.twitch.tv/helix"
    }

}