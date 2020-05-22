package helix.streams

import helix.http.model.HelixDTO
import helix.http.model.ScrollableHelixResponse
import helix.streams.model.Stream
import helix.users.model.User
import io.ktor.client.HttpClient
import io.ktor.client.call.receive
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.runBlocking

class StreamsHelixResponse(httpResponse: HttpResponse, httpClient: HttpClient) :
    ScrollableHelixResponse<Stream>(httpResponse, httpClient) {
    override val helixDTO: HelixDTO<Stream> = runBlocking {
        httpResponse.receive<HelixDTO<Stream>>()
    }

    override suspend fun nextPage(): StreamsHelixResponse? =
        nextPageHttpResponse("after")?.let {
            StreamsHelixResponse(
                it, httpClient
            )
        }
}