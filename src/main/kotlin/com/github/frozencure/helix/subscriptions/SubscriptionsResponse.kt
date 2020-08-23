package com.github.frozencure.helix.subscriptions

import com.github.frozencure.helix.http.model.array.HelixArrayDTO
import com.github.frozencure.helix.http.model.array.ScrollableResponse
import com.github.frozencure.helix.subscriptions.model.Subscription
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.statement.*
import kotlinx.coroutines.runBlocking

class SubscriptionsResponse(httpResponse: HttpResponse, httpClient: HttpClient) :
    ScrollableResponse<Subscription>(httpResponse, httpClient) {
    override val helixArrayDTO: HelixArrayDTO<Subscription> = runBlocking {
        httpResponse.receive<HelixArrayDTO<Subscription>>()
    }

    override suspend fun nextPage(): SubscriptionsResponse? =
        nextPageHttpResponse()?.let {
            SubscriptionsResponse(
                it, httpClient
            )
        }
}