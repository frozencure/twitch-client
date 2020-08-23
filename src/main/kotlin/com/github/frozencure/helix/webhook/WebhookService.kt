package com.github.frozencure.helix.webhook

import com.github.frozencure.helix.auth.model.AuthCredentials
import com.github.frozencure.helix.http.ResourceService
import io.ktor.client.*
import io.ktor.client.request.*

class WebhookService : ResourceService {


    constructor(credentials: AuthCredentials) : super(credentials)

    constructor(httpClient: HttpClient) : super(httpClient)

    companion object {
        const val BASE_URL = "${ResourceService.BASE_URL}/webhooks"
    }

    suspend fun getSubscriptions(first: Int = 100) = WebhooksResponse(
        httpClient.get("$BASE_URL/subscriptions") {
            parameter("first", first)
        }, httpClient
    )
}