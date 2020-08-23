package com.github.frozencure.helix.moderation

import com.github.frozencure.helix.http.model.array.HelixArrayDTO
import com.github.frozencure.helix.http.model.array.ScrollableResponse
import com.github.frozencure.helix.moderation.model.Moderator
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.statement.*
import kotlinx.coroutines.runBlocking


class ModeratorsScrollableResponse(
    httpResponse: HttpResponse,
    httpClient: HttpClient
) :
    ScrollableResponse<Moderator>(httpResponse, httpClient) {
    override val helixArrayDTO: HelixArrayDTO<Moderator> = runBlocking {
        httpResponse.receive<HelixArrayDTO<Moderator>>()
    }

    override suspend fun nextPage(): ModeratorsScrollableResponse? =
        nextPageHttpResponse(cursorKey = "after")?.let {
            ModeratorsScrollableResponse(
                it, httpClient
            )
        }

}