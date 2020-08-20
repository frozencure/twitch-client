package helix.channels

import helix.http.model.array.HelixArrayDTO
import helix.http.model.array.ScrollableResponse
import helix.channels.model.Channel
import io.ktor.client.HttpClient
import io.ktor.client.call.receive
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.runBlocking

/**
 * A collection response has one or multiple pages of channels as payload.
 * @constructor Creates a new channels response object.
 */
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