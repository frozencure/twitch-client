package analytics

import helix.analytics.AnalyticsService
import helix.analytics.ExtensionAnalyticsScrollableResponse
import helix.analytics.GameAnalyticsScrollableResponse
import helix.games.model.Game
import io.ktor.client.statement.request
import kotlinx.coroutines.runBlocking
import org.junit.Test
import util.HttpClientMockBuilder
import java.time.Instant

class `Given GET extension analytics with extension ID and started at and ended at date is called` {

    private val extensionId = 12345L

    private val startedAt = "2018-03-01T00:00:00Z"

    private val endedAt = "2018-06-01T00:00:00Z"

    private val extensionAnalyticsResponse = runBlocking<ExtensionAnalyticsScrollableResponse> {
        AnalyticsService(HttpClientMockBuilder.withJsonContent(AnalyticsTestData.EXTENSION_ANALYTICS))
            .getExtensionAnalytics(extensionId, Instant.parse(startedAt), Instant.parse(endedAt))
    }

    @Test
    fun `then extension ID is a parameter`() =
        assert(extensionAnalyticsResponse.httpResponse.request.url.parameters["extension_id"] == extensionId.toString())

    @Test
    fun `then started at is a parameter`() =
        assert(extensionAnalyticsResponse.httpResponse.request.url.parameters["started_at"] == startedAt)

    @Test
    fun `then ended at is a parameter`() =
        assert(extensionAnalyticsResponse.httpResponse.request.url.parameters["ended_at"] == endedAt)


    @Test
    fun `then two extension reports are returned`() =
        assert(extensionAnalyticsResponse.resources.size == 2)


    @Test
    fun `then response has multiple pages`() =
        assert(extensionAnalyticsResponse.pagination != null)


    class `When next page is retrieved` {

        private val extensionId = 12345L

        private val startedAt = "2018-03-01T00:00:00Z"

        private val endedAt = "2018-06-01T00:00:00Z"

        private val extensionAnalyticsResponse = runBlocking<ExtensionAnalyticsScrollableResponse?> {
            AnalyticsService(HttpClientMockBuilder.withJsonContent(AnalyticsTestData.EXTENSION_ANALYTICS))
                .getExtensionAnalytics(extensionId, Instant.parse(startedAt), Instant.parse(endedAt)).nextPage()
        }


        @Test
        fun `then two extension reports are returned`() =
            assert(extensionAnalyticsResponse?.resources?.size == 2)


        @Test
        fun `then after is a parameter`() =
            assert(extensionAnalyticsResponse?.httpResponse?.request?.url?.parameters?.get("after") != null)
    }
}



class `Given GET game analytics with game ID and started at and ended at date is called` {
    private val gameId = 12345L

    private val startedAt = "2018-03-01T00:00:00Z"

    private val endedAt = "2018-06-01T00:00:00Z"

    private val gameAnalyticsResponse = runBlocking<GameAnalyticsScrollableResponse> {
        AnalyticsService(HttpClientMockBuilder.withJsonContent(AnalyticsTestData.GAME_ANALYTICS))
            .getGameAnalytics(gameId, Instant.parse(startedAt), Instant.parse(endedAt))
    }


    @Test
    fun `then game ID is a parameter`() =
        assert(gameAnalyticsResponse.httpResponse.request.url.parameters["game_id"] == gameId.toString())

    @Test
    fun `then started at is a parameter`() =
        assert(gameAnalyticsResponse.httpResponse.request.url.parameters["started_at"] == startedAt)

    @Test
    fun `then ended at is a parameter`() =
        assert(gameAnalyticsResponse.httpResponse.request.url.parameters["ended_at"] == endedAt)


    @Test
    fun `then one game report is returned`() =
        assert(gameAnalyticsResponse.resources.size == 1)


    @Test
    fun `then response has multiple pages`() =
        assert(gameAnalyticsResponse.pagination != null)


    class `When next page is retrieved` {

        private val gameId = 12345L

        private val startedAt = "2018-03-01T00:00:00Z"

        private val endedAt = "2018-06-01T00:00:00Z"

        private val gameAnalyticsResponse = runBlocking<GameAnalyticsScrollableResponse?> {
            AnalyticsService(HttpClientMockBuilder.withJsonContent(AnalyticsTestData.GAME_ANALYTICS))
                .getGameAnalytics(gameId, Instant.parse(startedAt), Instant.parse(endedAt)).nextPage()
        }


        @Test
        fun `then one game report is returned`() =
            assert(gameAnalyticsResponse?.resources?.size == 1)


        @Test
        fun `then after is a parameter`() =
            assert(gameAnalyticsResponse?.httpResponse?.request?.url?.parameters?.get("after") != null)
    }
}