package helix.moderation

import helix.http.model.array.HelixArrayDTO
import helix.http.model.array.ScrollableResponse
import helix.moderation.model.BannedUser
import io.ktor.client.HttpClient
import io.ktor.client.call.receive
import io.ktor.client.statement.HttpResponse
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