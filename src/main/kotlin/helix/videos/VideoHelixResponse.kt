package helix.videos

import helix.http.model.CollectionHelixResponse
import helix.http.model.HelixDTO
import helix.http.model.ScrollableHelixResponse
import helix.http.model.SingleHelixResponse
import helix.videos.model.Video
import io.ktor.client.HttpClient
import io.ktor.client.call.receive
import io.ktor.client.request.headers
import io.ktor.client.request.parameter
import io.ktor.client.request.request
import io.ktor.client.request.url
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.request
import kotlinx.coroutines.runBlocking


class VideoHelixResponse(httpResponse: HttpResponse) : SingleHelixResponse<Video>(httpResponse) {
    override val helixDTO: HelixDTO<Video> = runBlocking {
        httpResponse.receive<HelixDTO<Video>>()
    }
}

class VideosHelixResponse(httpResponse: HttpResponse) : CollectionHelixResponse<Video>(httpResponse) {
    override val helixDTO: HelixDTO<Video> = runBlocking {
        httpResponse.receive<HelixDTO<Video>>()
    }
}

class ScrollableVideosResponse(
    httpResponse: HttpResponse,
    httpClient: HttpClient,
    private val previousCursor: String? = null
) :
    ScrollableHelixResponse<Video>(httpResponse, httpClient) {
    override val helixDTO: HelixDTO<Video> = runBlocking {
        httpResponse.receive<HelixDTO<Video>>()
    }

    override suspend fun nextPage(): ScrollableVideosResponse? =
        pagination?.let {
            ScrollableVideosResponse(httpClient.request<HttpResponse> {
                url(httpResponse.request.url)
                parameter("after", it.asPair().second)
                headers { httpResponse.request.headers }
                method = httpResponse.request.method
            }, httpClient, it.cursor)
        }

}

