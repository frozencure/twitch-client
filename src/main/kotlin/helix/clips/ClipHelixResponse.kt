package helix.clips

import helix.clips.model.Clip
import helix.clips.model.ClipCreation
import helix.http.model.CollectionHelixResponse
import helix.http.model.HelixDTO
import helix.http.model.ScrollableHelixResponse
import helix.http.model.SingleHelixResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.receive
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.runBlocking


class ClipHelixResponse(httpResponse: HttpResponse) : SingleHelixResponse<Clip>(httpResponse) {
    override val helixDTO: HelixDTO<Clip> = runBlocking {
        httpResponse.receive<HelixDTO<Clip>>()
    }
}

class ClipCreationHelixResponse(httpResponse: HttpResponse) : SingleHelixResponse<ClipCreation>(httpResponse) {
    override val helixDTO: HelixDTO<ClipCreation> = runBlocking {
        httpResponse.receive<HelixDTO<ClipCreation>>()
    }
}


class ClipsHelixResponse(httpResponse: HttpResponse) :
    CollectionHelixResponse<Clip>(httpResponse) {
    override val helixDTO: HelixDTO<Clip> = runBlocking {
        httpResponse.receive<HelixDTO<Clip>>()
    }
}


class ScrollableClipsResponse(httpResponse: HttpResponse, httpClient: HttpClient) :
    ScrollableHelixResponse<Clip>(httpResponse, httpClient) {
    override val helixDTO: HelixDTO<Clip> = runBlocking {
        httpResponse.receive<HelixDTO<Clip>>()
    }

    override suspend fun nextPage(): ScrollableClipsResponse? =
        nextPageHttpResponse("after")?.let {
            ScrollableClipsResponse(
                it, httpClient
            )
        }
}