package helix.channels

import helix.http.model.array.HelixArrayDTO
import helix.http.model.array.ScrollableResponse
import helix.channels.model.Channel
import io.ktor.client.HttpClient
import io.ktor.client.call.receive
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.runBlocking

class ChannelsResponse(httpResponse: HttpResponse, httpClient: HttpClient) :
    ScrollableResponse<Channel>(httpResponse, httpClient) {
    override val helixArrayDTO: HelixArrayDTO<Channel> = runBlocking {
        httpResponse.receive<HelixArrayDTO<Channel>>()
    }

    override suspend fun nextPage(): ChannelsResponse? =
        nextPageHttpResponse("after")?.let {
            ChannelsResponse(
                it, httpClient
            )
        }
}