package helix.http

import helix.http.credentials.ApiSettings
import helix.http.extensions.headersOfSerializableObject
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.features.defaultRequest
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer

abstract class ResourceService(
    protected val httpClient: HttpClient
) {
    constructor(apiSettings: ApiSettings, httpClientEngineConfig: HttpClientEngineConfig)
            : this(HttpClient {
        engine { httpClientEngineConfig }
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
        defaultRequest {
            headersOfSerializableObject(apiSettings.credentials)
        }
    })

    companion object {
        const val BASE_URL = "https://api.twitch.tv/helix"
    }

}