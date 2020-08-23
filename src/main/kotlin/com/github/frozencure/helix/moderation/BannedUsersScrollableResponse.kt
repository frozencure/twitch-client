package com.github.frozencure.helix.moderation

import com.github.frozencure.helix.http.model.array.HelixArrayDTO
import com.github.frozencure.helix.http.model.array.ScrollableResponse
import com.github.frozencure.helix.moderation.model.BannedUser
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.statement.*
import kotlinx.coroutines.runBlocking


class BannedUsersScrollableResponse(
    httpResponse: HttpResponse,
    httpClient: HttpClient
) :
    ScrollableResponse<BannedUser>(httpResponse, httpClient) {
    override val helixArrayDTO: HelixArrayDTO<BannedUser> = runBlocking {
        httpResponse.receive<HelixArrayDTO<BannedUser>>()
    }

    override suspend fun nextPage(): BannedUsersScrollableResponse? =
        nextPageHttpResponse(cursorKey = "after")?.let {
            BannedUsersScrollableResponse(
                it, httpClient
            )
        }

}