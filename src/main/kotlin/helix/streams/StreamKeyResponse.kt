package helix.streams

import helix.http.model.array.HelixArrayDTO
import helix.http.model.array.SingleResponse
import helix.streams.key.StreamKey
import io.ktor.client.call.receive
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.runBlocking

class StreamKeyResponse(httpResponse: HttpResponse) : SingleResponse<StreamKey>(httpResponse) {
    override val helixArrayDTO: HelixArrayDTO<StreamKey> = runBlocking {
        httpResponse.receive<HelixArrayDTO<StreamKey>>()
    }
}