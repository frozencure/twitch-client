package helix.streams.metadata

import helix.http.model.array.HelixArrayDTO
import helix.http.model.array.ScrollableResponse
import helix.streams.metadata.model.StreamMetadata
import io.ktor.client.HttpClient
import io.ktor.client.call.receive
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.runBlocking

class StreamsMetadataResponse(httpResponse: HttpResponse, httpClient: HttpClient) :
    ScrollableResponse<StreamMetadata>(httpResponse, httpClient) {
    override val helixArrayDTO: HelixArrayDTO<StreamMetadata> = runBlocking {
        httpResponse.receive<HelixArrayDTO<StreamMetadata>>()
    }

    override suspend fun nextPage(): StreamsMetadataResponse? =
        nextPageHttpResponse("after")?.let {
            StreamsMetadataResponse(
                it, httpClient
            )
        }
}