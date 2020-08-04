package helix.streams

import helix.http.model.HelixDTO
import helix.http.model.SingleHelixResponse
import helix.streams.key.StreamKey
import io.ktor.client.call.receive
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.runBlocking

class StreamKeyResponse(httpResponse: HttpResponse) : SingleHelixResponse<StreamKey>(httpResponse) {
    override val helixDTO: HelixDTO<StreamKey> = runBlocking {
        httpResponse.receive<HelixDTO<StreamKey>>()
    }
}