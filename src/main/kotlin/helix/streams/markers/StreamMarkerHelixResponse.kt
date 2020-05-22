package helix.streams.markers

import helix.http.model.HelixDTO
import helix.http.model.ScrollableHelixResponse
import helix.http.model.SingleHelixResponse
import helix.streams.markers.model.StreamMarker
import helix.streams.markers.model.UserStreamMarkers
import io.ktor.client.HttpClient
import io.ktor.client.call.receive
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.runBlocking

class StreamMarkerHelixResponse(httpResponse: HttpResponse) : SingleHelixResponse<StreamMarker>(httpResponse) {
    override val helixDTO: HelixDTO<StreamMarker> = runBlocking {
        httpResponse.receive<HelixDTO<StreamMarker>>()
    }
}


class UserStreamMarkersResponse(httpResponse: HttpResponse, httpClient: HttpClient) :
    ScrollableHelixResponse<UserStreamMarkers>(httpResponse, httpClient) {
    override val helixDTO: HelixDTO<UserStreamMarkers> = runBlocking {
        httpResponse.receive<HelixDTO<UserStreamMarkers>>()
    }

    override suspend fun nextPage(): UserStreamMarkersResponse? =
        nextPageHttpResponse("after")?.let {
            UserStreamMarkersResponse(
                it, httpClient
            )
        }
}