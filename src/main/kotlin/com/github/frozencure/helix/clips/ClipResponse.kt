package com.github.frozencure.helix.clips

import com.github.frozencure.helix.clips.model.Clip
import com.github.frozencure.helix.clips.model.ClipCreation
import com.github.frozencure.helix.http.model.array.CollectionResponse
import com.github.frozencure.helix.http.model.array.HelixArrayDTO
import com.github.frozencure.helix.http.model.array.ScrollableResponse
import com.github.frozencure.helix.http.model.array.SingleResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.statement.*
import kotlinx.coroutines.runBlocking


/**
 * A collection response that holds a single clip resource.
 * @constructor Creates a new clip response object.
 */

class ClipResponse(httpResponse: HttpResponse) : SingleResponse<Clip>(httpResponse) {

    override val helixArrayDTO: HelixArrayDTO<Clip> = runBlocking {
        httpResponse.receive<HelixArrayDTO<Clip>>()
    }
}

/**
 * A collection response that holds a single clip creation resource.
 * @constructor Creates a new clip creation response object.
 */
class ClipCreationResponse(httpResponse: HttpResponse) : SingleResponse<ClipCreation>(httpResponse) {

    override val helixArrayDTO: HelixArrayDTO<ClipCreation> = runBlocking {
        httpResponse.receive<HelixArrayDTO<ClipCreation>>()
    }
}

/**
 * A collection response that holds one or multiple clip resources.
 * @constructor Creates a new clips response object.
 */

class ClipsResponse(httpResponse: HttpResponse) :
    CollectionResponse<Clip>(httpResponse) {
    override val helixArrayDTO: HelixArrayDTO<Clip> = runBlocking {
        httpResponse.receive<HelixArrayDTO<Clip>>()
    }
}

/**
 * A collection response that holds one or multiple clip resources as payload.
 * The resource collection can be split into multiple pages.
 * @constructor Creates a new clips response object.
 */
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