package helix.streams.markers

import helix.http.model.array.HelixArrayDTO
import helix.http.model.array.ScrollableResponse
import helix.http.model.array.SingleResponse
import helix.streams.markers.model.StreamMarker
import helix.streams.markers.model.UserStreamMarkers
import io.ktor.client.HttpClient
import io.ktor.client.call.receive
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.runBlocking

class StreamMarkerResponse(httpResponse: HttpResponse) : SingleResponse<StreamMarker>(httpResponse) {
    override val helixArrayDTO: HelixArrayDTO<StreamMarker> = runBlocking {
        httpResponse.receive<HelixArrayDTO<StreamMarker>>()
    }
}


class UserStreamMarkersResponse(httpResponse: HttpResponse, httpClient: HttpClient) :
    ScrollableResponse<UserStreamMarkers>(httpResponse, httpClient) {
    override val helixArrayDTO: HelixArrayDTO<UserStreamMarkers> = runBlocking {
        httpResponse.receive<HelixArrayDTO<UserStreamMarkers>>()
    }

    override suspend fun nextPage(): UserStreamMarkersResponse? =
        nextPageHttpResponse("after")?.let {
            UserStreamMarkersResponse(
                it, httpClient
            )
        }
}