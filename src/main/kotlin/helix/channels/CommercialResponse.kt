package helix.channels

import helix.channels.model.commercial.Commercial
import helix.http.model.array.HelixArrayDTO
import helix.http.model.array.SingleResponse
import io.ktor.client.call.receive
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.runBlocking

class CommercialResponse(httpResponse: HttpResponse) : SingleResponse<Commercial>(httpResponse) {
    override val helixArrayDTO: HelixArrayDTO<Commercial> = runBlocking {
        httpResponse.receive<HelixArrayDTO<Commercial>>()
    }
}