package com.github.frozencure.helix.streams.metadata

import com.github.frozencure.helix.http.model.array.HelixArrayDTO
import com.github.frozencure.helix.http.model.array.ScrollableResponse
import com.github.frozencure.helix.streams.metadata.model.StreamMetadata
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.statement.*
import kotlinx.coroutines.runBlocking

class StreamsMetadataResponse(httpResponse: HttpResponse, httpClient: HttpClient) :
    ScrollableResponse<StreamMetadata>(httpResponse, httpClient) {
    override val helixArrayDTO: HelixArrayDTO<StreamMetadata> = runBlocking {
        httpResponse.receive<HelixArrayDTO<StreamMetadata>>()
    }

    override suspend fun nextPage(): StreamsMetadataResponse? =
        nextPageHttpResponse("after")?.let {
            StreamsMetadataResponse(
                it, httpClient
            )
        }
}