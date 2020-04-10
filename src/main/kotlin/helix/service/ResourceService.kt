package helix.service

import helix.configuration.IApiSettings
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.apache.Apache
import io.ktor.client.engine.apache.ApacheEngineConfig
import io.ktor.client.features.defaultRequest
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.JsonSerializer
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.header

abstract class ResourceService(
    private val apiSettings: IApiSettings,
    private val httpClientConfig: HttpClientEngineConfig,
    private val jsonSerializer: JsonSerializer
) {
    var httpClient: HttpClient = HttpClient {
        engine { httpClientConfig }
        install(JsonFeature) {
            serializer = jsonSerializer
        }
        defaultRequest {
            header(apiSettings.clientId.first, apiSettings.clientId.second)
        }
    }

}