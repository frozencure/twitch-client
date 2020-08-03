package helix.channels

import helix.http.model.HelixDTO
import helix.http.model.ScrollableHelixResponse
import helix.channels.model.Channel
import io.ktor.client.HttpClient
import io.ktor.client.call.receive
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.runBlocking

class ChannelsHelixResponse(httpResponse: HttpResponse, httpClient: HttpClient) :
    ScrollableHelixResponse<Channel>(httpResponse, httpClient) {
    override val helixDTO: HelixDTO<Channel> = runBlocking {
        httpResponse.receive<HelixDTO<Channel>>()
    }

    override suspend fun nextPage(): ChannelsHelixResponse? =
        nextPageHttpResponse("after")?.let {
            ChannelsHelixResponse(
                it, httpClient
            )
        }
}