package helix.service

import helix.configuration.ApiSettings
import helix.extension.headersOfSerializableObject
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.features.defaultRequest
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.http.auth.HttpAuthHeader

abstract class ResourceService(
    private val apiSettings: ApiSettings,
    private val httpClientConfig: HttpClientEngineConfig
) {
    protected val httpClient: HttpClient = HttpClient {
        engine { httpClientConfig }
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
        defaultRequest {
            headersOfSerializableObject(apiSettings.credentials)
        }
    }

}