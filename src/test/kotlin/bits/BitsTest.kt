package bits

import helix.bits.BitsLeaderboardResponse
import helix.bits.BitsService
import io.ktor.client.statement.request
import kotlinx.coroutines.runBlocking
import org.junit.Test
import util.HttpClientMockBuilder
import java.time.Instant

class `Given GET bits leaderboard is called` {

    private val userId: Long = 158010205

    private val startedAt = Instant.now()

    private val leaderboardResponse = runBlocking<BitsLeaderboardResponse> {
        BitsService(HttpClientMockBuilder.withJsonContent(BitsTestData.MULTIPLE_BITS_ENTRIES))
            .getBitsLeaderboard(userId = userId, startedAt = startedAt)
    }

    @Test
    fun `then request has user id as parameter`() =
        assert(leaderboardResponse.httpResponse.request.url.parameters["user_id"] == userId.toString())


    @Test
    fun `then request has started at instant as parameter`() =
        assert(
            leaderboardResponse.httpResponse.request.url.parameters["started_at"] ==
                    startedAt.toString()
        )

    @Test
    fun `then bits leaderboard is returned`() =
        assert(leaderboardResponse.resources.size == 2)


    @Test
    fun `then total is returned`() =
        assert(leaderboardResponse.total == 2L)

    @Test
    fun `then date range is returned`() =
        assert(leaderboardResponse.dateRange != null)
}