package helix.channels

import helix.channels.model.hypetrain.HypeTrain
import helix.http.model.HelixDTO
import helix.http.model.ScrollableHelixResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.receive
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.runBlocking

class HypeTrainScrollableResponse(httpResponse: HttpResponse, httpClient: HttpClient) :
    ScrollableHelixResponse<HypeTrain>(httpResponse, httpClient) {
    override val helixDTO: HelixDTO<HypeTrain> = runBlocking {
        httpResponse.receive<HelixDTO<HypeTrain>>()
    }

    override suspend fun nextPage(): HypeTrainScrollableResponse? =
        nextPageHttpResponse()?.let {
            HypeTrainScrollableResponse(it, httpClient)
        }
}