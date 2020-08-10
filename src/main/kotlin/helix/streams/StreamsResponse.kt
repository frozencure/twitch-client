package helix.streams

import helix.http.model.array.HelixArrayDTO
import helix.http.model.array.ScrollableResponse
import helix.streams.model.Stream
import io.ktor.client.HttpClient
import io.ktor.client.call.receive
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.runBlocking

class StreamsResponse(httpResponse: HttpResponse, httpClient: HttpClient) :
    ScrollableResponse<Stream>(httpResponse, httpClient) {
    override val helixArrayDTO: HelixArrayDTO<Stream> = runBlocking {
        httpResponse.receive<HelixArrayDTO<Stream>>()
    }

    override suspend fun nextPage(): StreamsResponse? =
        nextPageHttpResponse("after")?.let {
            StreamsResponse(
                it, httpClient
            )
        }
}