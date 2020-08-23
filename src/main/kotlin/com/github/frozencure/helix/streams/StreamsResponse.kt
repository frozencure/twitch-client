package com.github.frozencure.helix.streams

import com.github.frozencure.helix.http.model.array.HelixArrayDTO
import com.github.frozencure.helix.http.model.array.ScrollableResponse
import com.github.frozencure.helix.streams.model.Stream
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.statement.*
import kotlinx.coroutines.runBlocking


class StreamsResponse(httpResponse: HttpResponse, httpClient: HttpClient) :
    ScrollableResponse<Stream>(httpResponse = httpResponse, httpClient = httpClient) {
    override val helixArrayDTO: HelixArrayDTO<Stream> = runBlocking {
        httpResponse.receive<HelixArrayDTO<Stream>>()
    }

    override suspend fun nextPage(): StreamsResponse? =
        nextPageHttpResponse("after")?.let {
            StreamsResponse(
                it, httpClient
            )
        }
}