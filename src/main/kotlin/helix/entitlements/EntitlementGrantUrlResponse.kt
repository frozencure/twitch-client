package helix.entitlements

import helix.entitlements.model.EntitlementUrl
import helix.http.model.array.HelixArrayDTO
import helix.http.model.array.SingleResponse
import io.ktor.client.call.receive
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.runBlocking

class EntitlementGrantUrlResponse(httpResponse: HttpResponse) : SingleResponse<EntitlementUrl>(httpResponse) {
    override val helixArrayDTO: HelixArrayDTO<EntitlementUrl> = runBlocking {
        httpResponse.receive<HelixArrayDTO<EntitlementUrl>>()
    }
}