package com.github.frozencure.helix.moderation

import com.github.frozencure.helix.http.model.array.HelixArrayDTO
import com.github.frozencure.helix.http.model.array.ScrollableResponse
import com.github.frozencure.helix.moderation.model.ModeratorEvent
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.statement.*
import kotlinx.coroutines.runBlocking


class ModeratorEventsScrollableResponse(
    httpResponse: HttpResponse,
    httpClient: HttpClient
) :
    ScrollableResponse<ModeratorEvent>(httpResponse, httpClient) {
    override val helixArrayDTO: HelixArrayDTO<ModeratorEvent> = runBlocking {
        httpResponse.receive<HelixArrayDTO<ModeratorEvent>>()
    }

    override suspend fun nextPage(): ModeratorEventsScrollableResponse? =
        nextPageHttpResponse(cursorKey = "after")?.let {
            ModeratorEventsScrollableResponse(
                it, httpClient
            )
        }

}