package helix.channels

import helix.channels.model.hypetrain.HypeTrain
import helix.http.model.array.HelixArrayDTO
import helix.http.model.array.ScrollableResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.receive
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.runBlocking

class HypeTrainScrollableResponse(httpResponse: HttpResponse, httpClient: HttpClient) :
    ScrollableResponse<HypeTrain>(httpResponse, httpClient) {
    override val helixArrayDTO: HelixArrayDTO<HypeTrain> = runBlocking {
        httpResponse.receive<HelixArrayDTO<HypeTrain>>()
    }

    override suspend fun nextPage(): HypeTrainScrollableResponse? =
        nextPageHttpResponse()?.let {
            HypeTrainScrollableResponse(it, httpClient)
        }
}