package helix.subscriptions

import helix.auth.model.AuthCredentials
import helix.http.ResourceService
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.apache.ApacheEngineConfig
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class SubscriptionService : ResourceService {

    constructor(credentials: AuthCredentials, engineConfig: HttpClientEngineConfig = ApacheEngineConfig())
            : super(credentials, engineConfig)

    constructor(httpClient: HttpClient) : super(httpClient)

    companion object {
        const val BASE_URL = "${ResourceService.BASE_URL}/subscriptions"
    }

    suspend fun getSubscriptions(broadcasterId: Long, userId: Long? = null): SubscriptionsResponse =
        SubscriptionsResponse(
            httpClient
                .get(BASE_URL) {
                    parameter("broadcaster_id", broadcasterId)
                    userId?.let { parameter("user_id", it) }
                }, httpClient
        )
}