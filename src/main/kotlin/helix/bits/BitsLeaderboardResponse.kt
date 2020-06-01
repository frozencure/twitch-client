package helix.bits

import helix.bits.model.BitsLeaderboardEntry
import helix.http.model.CollectionHelixResponse
import helix.http.model.HelixDTO
import io.ktor.client.call.receive
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.runBlocking


class BitsLeaderboardResponse(httpResponse: HttpResponse) :
    CollectionHelixResponse<BitsLeaderboardEntry>(httpResponse) {
    override val helixDTO: HelixDTO<BitsLeaderboardEntry> = runBlocking {
        httpResponse.receive<HelixDTO<BitsLeaderboardEntry>>()
    }
}