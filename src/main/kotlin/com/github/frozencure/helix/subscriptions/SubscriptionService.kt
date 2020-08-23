package com.github.frozencure.helix.subscriptions

import com.github.frozencure.helix.auth.model.AuthCredentials
import com.github.frozencure.helix.http.ResourceService
import io.ktor.client.*
import io.ktor.client.request.*

class SubscriptionService : ResourceService {

    constructor(credentials: AuthCredentials) : super(credentials)

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