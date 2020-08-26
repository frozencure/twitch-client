package com.github.frozencure.helix.entitlements

import com.github.frozencure.helix.entitlements.model.Entitlement
import com.github.frozencure.helix.http.model.array.HelixArrayDTO
import com.github.frozencure.helix.http.model.array.ScrollableResponse
import com.github.frozencure.helix.http.model.array.SingleResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.statement.*
import kotlinx.coroutines.runBlocking

/**
 * A collection response that can contain one entitlement object.
 * @constructor Creates a new entitlement response object.
 */
class EntitlementResponse(httpResponse: HttpResponse) : SingleResponse<Entitlement>(httpResponse) {
    override val helixArrayDTO: HelixArrayDTO<Entitlement> = runBlocking {
        httpResponse.receive<HelixArrayDTO<Entitlement>>()
    }
}

/**
 * A collection response that holds one or multiple entitlements as payload.
 * The resource collection can be split into multiple pages.
 * @constructor Creates a new entitlements response object.
 */
class EntitlementsResponse(httpResponse: HttpResponse, httpClient: HttpClient) :
    ScrollableResponse<Entitlement>(httpResponse, httpClient) {

    override val helixArrayDTO: HelixArrayDTO<Entitlement> = runBlocking {
        httpResponse.receive<HelixArrayDTO<Entitlement>>()
    }

    override suspend fun nextPage(): EntitlementsResponse? =
        nextPageHttpResponse(cursorKey = "after")?.let {
            EntitlementsResponse(
                it, httpClient
            )
        }
}