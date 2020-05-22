package helix.streams.metadata

import helix.http.model.HelixDTO
import helix.http.model.ScrollableHelixResponse
import helix.streams.metadata.model.StreamMetadata
import io.ktor.client.HttpClient
import io.ktor.client.call.receive
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.runBlocking

class StreamsMetadataHelixResponse(httpResponse: HttpResponse, httpClient: HttpClient) :
    ScrollableHelixResponse<StreamMetadata>(httpResponse, httpClient) {
    override val helixDTO: HelixDTO<StreamMetadata> = runBlocking {
        httpResponse.receive<HelixDTO<StreamMetadata>>()
    }

    override suspend fun nextPage(): StreamsMetadataHelixResponse? =
        nextPageHttpResponse("after")?.let {
            StreamsMetadataHelixResponse(
                it, httpClient
            )
        }
}