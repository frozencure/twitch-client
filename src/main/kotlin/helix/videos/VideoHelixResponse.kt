package helix.videos

import helix.http.model.CollectionHelixResponse
import helix.http.model.HelixDTO
import helix.http.model.ScrollableHelixResponse
import helix.http.model.SingleHelixResponse
import helix.videos.model.Video
import io.ktor.client.HttpClient
import io.ktor.client.call.receive
import io.ktor.client.statement.HttpResponse
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
    httpClient: HttpClient
) :
    ScrollableHelixResponse<Video>(httpResponse, httpClient) {
    override val helixDTO: HelixDTO<Video> = runBlocking {
        httpResponse.receive<HelixDTO<Video>>()
    }

    override suspend fun nextPage(): ScrollableVideosResponse? =
        nextPageHttpResponse(cursorKey = "after")?.let {
            ScrollableVideosResponse(
                it, httpClient
            )
        }

}

