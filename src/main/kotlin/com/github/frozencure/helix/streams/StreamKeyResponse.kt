package com.github.frozencure.helix.streams

import com.github.frozencure.helix.http.model.array.HelixArrayDTO
import com.github.frozencure.helix.http.model.array.SingleResponse
import com.github.frozencure.helix.streams.key.StreamKey
import io.ktor.client.call.*
import io.ktor.client.statement.*
import kotlinx.coroutines.runBlocking

/**
 * A collection response that can contain a single stream key object as payload.
 * @constructor Creates a new stream key response object.
 */
class StreamKeyResponse(httpResponse: HttpResponse) : SingleResponse<StreamKey>(httpResponse) {
    override val helixArrayDTO: HelixArrayDTO<StreamKey> = runBlocking {
        httpResponse.receive<HelixArrayDTO<StreamKey>>()
    }
}