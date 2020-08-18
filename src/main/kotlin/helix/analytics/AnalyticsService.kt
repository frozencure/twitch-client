package helix.analytics

import helix.auth.model.AuthCredentials
import helix.http.ResourceService
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.apache.ApacheEngineConfig
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import java.time.Instant
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

class AnalyticsService : ResourceService {


    constructor(credentials: AuthCredentials, engineConfig: HttpClientEngineConfig = ApacheEngineConfig())
            : super(credentials, engineConfig)

    constructor(httpClient: HttpClient) : super(httpClient)

    companion object {
        const val BASE_URL = "${ResourceService.BASE_URL}/analytics"
    }


    suspend fun getGameAnalytics(
        gameId: Long? = null,
        startedAt: Instant? = null,
        endedAt: Instant? = null,
        first: Int = 100,
        type: String? = null
    ) =
        GameAnalyticsScrollableResponse(
            httpClient.get("$BASE_URL/games") {
                gameId?.let {
                    parameter("game_id", gameId)
                }
                addAnalyticsParameters(startedAt, endedAt, first, type)
            }, httpClient
        )


    suspend fun getExtensionAnalytics(
        extensionId: Long? = null,
        startedAt: Instant? = null,
        endedAt: Instant? = null,
        first: Int = 100,
        type: String? = null
    ) = ExtensionAnalyticsScrollableResponse(
        httpClient.get("$BASE_URL/extensions") {
            extensionId?.let {
                parameter("extension_id", extensionId)
            }
            addAnalyticsParameters(startedAt, endedAt, first, type)
        }, httpClient
    )

    private fun HttpRequestBuilder.addAnalyticsParameters(
        startedAt: Instant? = null,
        endedAt: Instant? = null,
        first: Int = 100,
        type: String? = null
    ) {
        startedAt?.let {
            parameter(
                "started_at",
                DateTimeFormatter.ISO_INSTANT.format(startedAt.truncatedTo(ChronoUnit.SECONDS))
            )
        }
        endedAt?.let {
            parameter(
                "ended_at",
                DateTimeFormatter.ISO_INSTANT.format(endedAt.truncatedTo(ChronoUnit.SECONDS))
            )
        }
        parameter("first", first)
        type?.let { parameter("type", type) }
    }


}