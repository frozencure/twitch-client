package helix.webhook

import helix.http.ResourceService
import helix.http.credentials.ApiSettings
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class WebhookService : ResourceService {


    constructor(apiSettings: ApiSettings, httpClientEngineConfig: HttpClientEngineConfig)
            : super(apiSettings, httpClientEngineConfig)

    constructor(httpClient: HttpClient) : super(httpClient)

    companion object {
        const val BASE_URL = "${ResourceService.BASE_URL}/webhooks"
    }

    suspend fun getSubscriptions(first: Int = 100) = WebhooksHelixResponse(
        httpClient.get("$BASE_URL/subscriptions") {
            parameter("first", first)
        }, httpClient
    )
}