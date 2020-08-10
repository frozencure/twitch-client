package helix.streams.tags

import helix.http.model.array.HelixArrayDTO
import helix.http.model.array.ScrollableResponse
import helix.streams.tags.model.StreamTag
import io.ktor.client.HttpClient
import io.ktor.client.call.receive
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.runBlocking

class StreamTagsResponse(httpResponse: HttpResponse, httpClient: HttpClient) :
    ScrollableResponse<StreamTag>(httpResponse, httpClient) {
    override val helixArrayDTO: HelixArrayDTO<StreamTag> = runBlocking {
        httpResponse.receive<HelixArrayDTO<StreamTag>>()
    }

    override suspend fun nextPage(): StreamTagsResponse? =
        nextPageHttpResponse("after")?.let {
            StreamTagsResponse(
                it, httpClient
            )
        }
}