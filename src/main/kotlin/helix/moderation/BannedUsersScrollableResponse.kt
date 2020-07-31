package helix.moderation

import helix.http.model.HelixDTO
import helix.http.model.ScrollableHelixResponse
import helix.moderation.model.BannedUser
import io.ktor.client.HttpClient
import io.ktor.client.call.receive
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.runBlocking

class BannedUsersScrollableResponse(
    httpResponse: HttpResponse,
    httpClient: HttpClient
) :
    ScrollableHelixResponse<BannedUser>(httpResponse, httpClient) {
    override val helixDTO: HelixDTO<BannedUser> = runBlocking {
        httpResponse.receive<HelixDTO<BannedUser>>()
    }

    override suspend fun nextPage(): BannedUsersScrollableResponse? =
        nextPageHttpResponse(cursorKey = "after")?.let {
            BannedUsersScrollableResponse(
                it, httpClient
            )
        }

}