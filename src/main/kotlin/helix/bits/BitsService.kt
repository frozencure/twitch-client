package helix.bits

import helix.auth.model.AuthCredentials
import helix.http.ResourceService
import helix.shared.model.request.Period
import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.engine.apache.*
import io.ktor.client.request.*
import java.time.Instant
import helix.bits.model.BitsLeaderboardEntry
import helix.auth.model.AuthScope

/**
 * Service class that can be used to access *Bits* endpoints:
 * *GET bits leaderboard*
 */
class BitsService : ResourceService {

    /**
     * Creates a new bits service object given some authentication credentials and a HTTP client configuration.
     * @param credentials The authentication credentials: can be OAuth or simple credentials with only a client ID
     * @param engineConfig Engine configuration for the HTTP client. Apache engine is used as default.
     */
    constructor(credentials: AuthCredentials, engineConfig: HttpClientEngineConfig = ApacheEngineConfig())
            : super(credentials, engineConfig)

    /**
     * Creates a new bits service object given an HTTP client.
     * @param httpClient The HTTP client.
     */
    constructor(httpClient: HttpClient) : super(httpClient)

    private companion object {
        private const val BASE_URL = "${ResourceService.BASE_URL}/bits"
    }

    /**
     * Gets a ranked list of Bits leaderboard information for an authorized broadcaster.
     * Requires [AuthScope.BITS_READ]
     * For more information see the [Twitch Developer Reference](https://dev.twitch.tv/docs/api/reference#get-bits-leaderboard)
     * @param count Number of results to be returned. Maximum: 100. Default: 100.
     * @param period Time period over which data is aggregated. This parameter interacts with [startedAt].
     * @param startedAt Timestamp for the period over which the returned data is aggregated.
     * @param userId ID of the user whose results are returned; i.e., the person who paid for the Bits.
     * @return A [BitsLeaderboardResponse] that holds a collection of [BitsLeaderboardEntry] resources.
     * @sample samples.getBitsLeaderboard
     */
    suspend fun getBitsLeaderboard(
        count: Int = 100,
        period: Period = Period.ALL,
        userId: Long? = null,
        startedAt: Instant? = null
    ) = BitsLeaderboardResponse(httpClient.get("$BASE_URL/leaderboard") {
        parameter("count", count)
        parameter("period", period.asString)
        parameter("user_id", userId)
        parameter("started_at", startedAt)
    })
}