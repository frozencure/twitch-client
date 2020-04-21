package helix.http

import helix.http.credentials.ApiSettings
import helix.http.extensions.headersOfSerializableObject
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.features.defaultRequest
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer

abstract class ResourceService(
    private val apiSettings: ApiSettings,
    private val httpClientConfig: HttpClientEngineConfig
) {
     var httpClient: HttpClient = HttpClient {
        engine { httpClientConfig }
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
        defaultRequest {
            headersOfSerializableObject(apiSettings.credentials)
        }
    }

    companion object {
        const val BASE_URL = "https://api.twitch.tv/helix"
    }

}