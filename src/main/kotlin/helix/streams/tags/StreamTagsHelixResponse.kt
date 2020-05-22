package helix.streams.tags

import helix.http.model.HelixDTO
import helix.http.model.ScrollableHelixResponse
import helix.streams.tags.model.StreamTag
import io.ktor.client.HttpClient
import io.ktor.client.call.receive
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.runBlocking

class StreamTagsHelixResponse(httpResponse: HttpResponse, httpClient: HttpClient) :
    ScrollableHelixResponse<StreamTag>(httpResponse, httpClient) {
    override val helixDTO: HelixDTO<StreamTag> = runBlocking {
        httpResponse.receive<HelixDTO<StreamTag>>()
    }

    override suspend fun nextPage(): StreamTagsHelixResponse? =
        nextPageHttpResponse("after")?.let {
            StreamTagsHelixResponse(
                it, httpClient
            )
        }
}