package helix.entitlements

import helix.entitlements.model.Entitlement
import helix.http.model.array.HelixArrayDTO
import helix.http.model.array.ScrollableResponse
import helix.http.model.array.SingleResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.statement.*
import kotlinx.coroutines.runBlocking

class EntitlementResponse(httpResponse: HttpResponse) : SingleResponse<Entitlement>(httpResponse) {
    override val helixArrayDTO: HelixArrayDTO<Entitlement> = runBlocking {
        httpResponse.receive<HelixArrayDTO<Entitlement>>()
    }
}

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