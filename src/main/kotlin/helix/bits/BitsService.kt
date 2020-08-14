package helix.bits

import helix.auth.model.AuthCredentials
import helix.http.ResourceService
import helix.shared.model.request.Period
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.apache.ApacheEngineConfig
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import java.time.Instant

class BitsService : ResourceService {


    constructor(credentials: AuthCredentials, engineConfig: HttpClientEngineConfig = ApacheEngineConfig())
            : super(credentials, engineConfig)

    constructor(httpClient: HttpClient) : super(httpClient)

    companion object {
        const val BASE_URL = "${ResourceService.BASE_URL}/bits"
    }

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