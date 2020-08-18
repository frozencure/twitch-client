package helix.analytics

import helix.analytics.model.GameReport
import helix.http.model.array.HelixArrayDTO
import helix.http.model.array.ScrollableResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.receive
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.runBlocking

/**
 * A collection response that can contain multiple pages of game reports.
 */
class GameAnalyticsScrollableResponse(httpResponse: HttpResponse, httpClient: HttpClient) :
    ScrollableResponse<GameReport>(httpResponse, httpClient) {
    override val helixArrayDTO: HelixArrayDTO<GameReport> = runBlocking {
        httpResponse.receive<HelixArrayDTO<GameReport>>()
    }

    override suspend fun nextPage(): GameAnalyticsScrollableResponse? =
        nextPageHttpResponse(cursorKey = "after")?.let {
            GameAnalyticsScrollableResponse(
                it, httpClient
            )
        }
}