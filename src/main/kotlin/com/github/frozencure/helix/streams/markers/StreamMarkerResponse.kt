package com.github.frozencure.helix.streams.markers

import com.github.frozencure.helix.http.model.array.HelixArrayDTO
import com.github.frozencure.helix.http.model.array.ScrollableResponse
import com.github.frozencure.helix.http.model.array.SingleResponse
import com.github.frozencure.helix.streams.markers.model.StreamMarker
import com.github.frozencure.helix.streams.markers.model.UserStreamMarkers
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.statement.*
import kotlinx.coroutines.runBlocking


/**
 * A collection response that can contain a single stream marker object as payload.
 * @constructor Creates a new stream marker response object.
 */
class StreamMarkerResponse(httpResponse: HttpResponse) : SingleResponse<StreamMarker>(httpResponse) {
    override val helixArrayDTO: HelixArrayDTO<StreamMarker> = runBlocking {
        httpResponse.receive<HelixArrayDTO<StreamMarker>>()
    }
}

/**
 * A collection response that holds one or multiple stream marker resources as payload.
 * The resource collection can be split into multiple pages.
 * @constructor Creates a new user stream marker response object.
 */
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