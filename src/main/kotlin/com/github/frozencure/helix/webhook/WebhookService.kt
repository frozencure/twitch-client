package com.github.frozencure.helix.webhook

import com.github.frozencure.helix.auth.model.AuthCredentials
import com.github.frozencure.helix.http.ResourceService
import com.github.frozencure.helix.webhook.model.Webhook
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * Service class that can be used to access **Webhooks** endpoints:
 * *GET webhook subscriptions*
 */
class WebhookService : ResourceService {

    /**
     * Creates a new webhook service object given some authentication credentials and a HTTP client configuration.
     * @param credentials The authentication credentials: can be OAuth or simple credentials with only a client ID
     */
    constructor(credentials: AuthCredentials) : super(credentials)

    /**
     * Creates a new webhook service object given an HTTP client.
     * @param httpClient The HTTP client.
     */
    constructor(httpClient: HttpClient) : super(httpClient)

    private companion object {
        private const val BASE_URL = "${ResourceService.BASE_URL}/webhooks"
    }

    /**
     * Gets the Webhook subscriptions of a user, in order of expiration.
     * Requires an app access token.
     * For more information visit the [Twitch Developer Reference](https://dev.twitch.tv/docs/api/reference#get-webhook-subscriptions)
     * @param first The number of subscriptions to be returned. Maximum of 100, default of 100.
     * @return A [WebhooksResponse] that holds one or multiple [Webhook] resources as payload (can have multiple pages).
     * @sample samples.getWebhookSubscriptions
     */
    suspend fun getSubscriptions(first: Int = 100) = WebhooksResponse(
        httpClient.get("$BASE_URL/subscriptions") {
            parameter("first", first)
        }, httpClient
    )
}