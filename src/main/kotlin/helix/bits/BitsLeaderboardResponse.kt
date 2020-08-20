package helix.bits

import helix.bits.model.BitsLeaderboardEntry
import helix.http.model.array.CollectionResponse
import helix.http.model.array.HelixArrayDTO
import io.ktor.client.call.receive
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.runBlocking


/**
 * A collection response that contains one or multiple bits leaderboard entries.
 * @constructor Creates a new bits leaderboard response object.
 */
class BitsLeaderboardResponse(httpResponse: HttpResponse) :
    CollectionResponse<BitsLeaderboardEntry>(httpResponse) {
    override val helixArrayDTO: HelixArrayDTO<BitsLeaderboardEntry> = runBlocking {
        httpResponse.receive<HelixArrayDTO<BitsLeaderboardEntry>>()
    }
}