package com.github.frozencure.helix.videos

import com.github.frozencure.helix.http.model.array.CollectionResponse
import com.github.frozencure.helix.http.model.array.HelixArrayDTO
import com.github.frozencure.helix.http.model.array.ScrollableResponse
import com.github.frozencure.helix.http.model.array.SingleResponse
import com.github.frozencure.helix.videos.model.Video
import io.ktor.client.HttpClient
import io.ktor.client.call.receive
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.runBlocking




class VideoResponse(httpResponse: HttpResponse) : SingleResponse<Video>(httpResponse) {
    override val helixArrayDTO: HelixArrayDTO<Video> = runBlocking {
        httpResponse.receive<HelixArrayDTO<Video>>()
    }
}


class VideosResponse(httpResponse: HttpResponse) : CollectionResponse<Video>(httpResponse) {
    override val helixArrayDTO: HelixArrayDTO<Video> = runBlocking {
        httpResponse.receive<HelixArrayDTO<Video>>()
    }
}


class ScrollableVideosResponse(
    httpResponse: HttpResponse,
    httpClient: HttpClient
) :
    ScrollableResponse<Video>(httpResponse, httpClient) {
    override val helixArrayDTO: HelixArrayDTO<Video> = runBlocking {
        httpResponse.receive<HelixArrayDTO<Video>>()
    }

    override suspend fun nextPage(): ScrollableVideosResponse? =
        nextPageHttpResponse(cursorKey = "after")?.let {
            ScrollableVideosResponse(
                it, httpClient
            )
        }

}

