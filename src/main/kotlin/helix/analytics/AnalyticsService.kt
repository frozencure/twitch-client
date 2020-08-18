package helix.analytics

import helix.auth.model.AuthCredentials
import helix.auth.model.AuthScope
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

/**
 * Service class that encapsulates the *Analytics* endpoints:
 * *GET game analytics* and *GET extension analytics*.
 */
class AnalyticsService : ResourceService {


    /**
     * Creates a new analytics service object given some authentication credentials and a HTTP client configuration.
     * @param credentials The authentication credentials: can be OAuth or simple credentials with only a client ID
     * @param engineConfig Engine configuration for the HTTP client. Apache engine is used as default.
     */
    constructor(credentials: AuthCredentials, engineConfig: HttpClientEngineConfig = ApacheEngineConfig())
            : super(credentials, engineConfig)

    /**
     * Creates a new analytics service object given an HTTP client.
     */
    constructor(httpClient: HttpClient) : super(httpClient)

    private companion object {
        private const val BASE_URL = "${ResourceService.BASE_URL}/analytics"
    }


    /**
     * Gets a URL that game developers can use to download analytics reports (CSV files) for their games.
     * The URL is valid for 5 minutes.
     * Requires [AuthScope.ANALYTICS_READ_GAMES].
     * For more information see the [Twitch developer reference](https://dev.twitch.tv/docs/api/reference#get-game-analytics)
     *
     * @param gameId If this is specified, the returned URL points to an analytics report for just the specified game. If this is not specified, the response includes multiple URLs (paginated), pointing to separate analytics reports for each of the authenticated user’s games.
     * @param startedAt Starting date/time for returned reports. If this is provided, [endedAt] also must be specified. If [startedAt] is earlier than the default start date, the default date is used.
     * @param endedAt Ending date/time for returned reports. If this is provided, [startedAt] also must be specified. If [endedAt] is later than the default end date, the default date is used.
     * @param first Maximum number of objects to return. Maximum: 100, Default: 100
     * @param type Type of analytics report that is returned. Valid values: "overview_v1", "overview_v2". Default: all report types for the authenticated user’s games.
     * @return A collection of game reports that can have multiple, scrollable pages.
     * @sample samples.getGameAnalytics
     */
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


    /**
     * Gets a URL that extension developers can use to download analytics reports (CSV files) for their extensions.
     * The URL is valid for 5 minutes.
     * Requires [AuthScope.ANALYTICS_READ_EXTENSIONS].
     * For more information see the [Twitch developer reference](https://dev.twitch.tv/docs/api/reference#get-extension-analytics)
     *
     * @param extensionId If this is specified, the returned URL points to an analytics report for just the specified extension. If this is not specified, the response includes multiple URLs (paginated), pointing to separate analytics reports for each of the authenticated user’s extensions.
     * @param startedAt Starting date/time for returned reports. If this is provided, [endedAt] also must be specified. If [startedAt] is earlier than the default start date, the default date is used.
     * @param endedAt Ending date/time for returned reports. If this is provided, [startedAt] also must be specified. If [endedAt] is later than the default end date, the default date is used.
     * @param first Maximum number of objects to return. Maximum: 100, Default: 100
     * @param type Type of analytics report that is returned. Valid values: "overview_v1", "overview_v2". Default: all report types for the authenticated user’s games.
     * @return A collection of game reports that can have multiple, scrollable pages.
     * @sample samples.getExtensionAnalytics
     */
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