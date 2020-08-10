package helix.clips

import helix.clips.model.Clip
import helix.clips.model.ClipCreation
import helix.http.model.array.CollectionResponse
import helix.http.model.array.HelixArrayDTO
import helix.http.model.array.ScrollableResponse
import helix.http.model.array.SingleResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.receive
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.runBlocking


class ClipResponse(httpResponse: HttpResponse) : SingleResponse<Clip>(httpResponse) {
    override val helixArrayDTO: HelixArrayDTO<Clip> = runBlocking {
        httpResponse.receive<HelixArrayDTO<Clip>>()
    }
}

class ClipCreationResponse(httpResponse: HttpResponse) : SingleResponse<ClipCreation>(httpResponse) {
    override val helixArrayDTO: HelixArrayDTO<ClipCreation> = runBlocking {
        httpResponse.receive<HelixArrayDTO<ClipCreation>>()
    }
}


class ClipsResponse(httpResponse: HttpResponse) :
    CollectionResponse<Clip>(httpResponse) {
    override val helixArrayDTO: HelixArrayDTO<Clip> = runBlocking {
        httpResponse.receive<HelixArrayDTO<Clip>>()
    }
}


class ScrollableClipsResponse(httpResponse: HttpResponse, httpClient: HttpClient) :
    ScrollableResponse<Clip>(httpResponse, httpClient) {
    override val helixArrayDTO: HelixArrayDTO<Clip> = runBlocking {
        httpResponse.receive<HelixArrayDTO<Clip>>()
    }

    override suspend fun nextPage(): ScrollableClipsResponse? =
        nextPageHttpResponse("after")?.let {
            ScrollableClipsResponse(
                it, httpClient
            )
        }
}