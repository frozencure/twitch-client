package helix.channels

import helix.channels.model.commercial.Commercial
import helix.http.model.HelixDTO
import helix.http.model.SingleHelixResponse
import io.ktor.client.call.receive
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.runBlocking

class CommercialResponse(httpResponse: HttpResponse) : SingleHelixResponse<Commercial>(httpResponse) {
    override val helixDTO: HelixDTO<Commercial> = runBlocking {
        httpResponse.receive<HelixDTO<Commercial>>()
    }
}