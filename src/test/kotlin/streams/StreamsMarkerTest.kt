package streams

import helix.streams.StreamService
import helix.streams.markers.StreamMarkerResponse
import helix.streams.markers.UserStreamMarkersResponse
import helix.streams.markers.model.StreamMarkerRequest
import io.ktor.client.statement.request
import io.ktor.content.TextContent
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.ImplicitReflectionSerializer
import kotlinx.serialization.UnstableDefault
import kotlinx.serialization.json.Json
import org.junit.Test
import util.HttpClientMockBuilder

class `Given POST create stream marker is called` {

    private val userId: Long = 123;
    private val description = "test description"

    private val streamMarkerResponse = runBlocking<StreamMarkerResponse> {
        StreamService(HttpClientMockBuilder.withJsonContent(StreamsTestData.SINGLE_STREAM_MARKER))
            .createStreamMarker(userId, description)
    }

    @OptIn(UnstableDefault::class)
    @ImplicitReflectionSerializer
    @Test
    fun `then request has user ID and description as body`() =
        assert(
            (streamMarkerResponse.httpResponse.request.content as TextContent).text == Json.toJson(
                StreamMarkerRequest(
                    userId,
                    description
                )
            ).toString()
        )

    @Test
    fun `then stream marker is created`() =
        assert(streamMarkerResponse.resource != null)


}

class `Given GET stream markers is called` {

    private val userId: Long = 123;

    private val userStreamMarkers = runBlocking<UserStreamMarkersResponse> {
        StreamService(HttpClientMockBuilder.withJsonContent(StreamsTestData.USER_STREAM_MARKERS_WITH_PAGINATION))
            .getUserStreamMarkers(userId)
    }

    @Test
    fun `then user stream markers are retrieved`() =
        assert(userStreamMarkers.resources.size == 1)

    @Test
    fun `then user video is retrieved`() =
        assert(userStreamMarkers.resources.first().videosMarkers.size == 1)

    @Test
    fun `then user markers are retrived`() =
        assert(userStreamMarkers.resources.first().videosMarkers.first().markers.size == 2)

    @Test
    fun `then pagination exists`() =
        assert(userStreamMarkers.pagination != null)

    @Test
    fun `then request has user ID as parameter`() =
        assert(userStreamMarkers.httpResponse.request.url.parameters["user_id"] == userId.toString())


    class `And next page is retrieved` {
        private val userId: Long = 123;

        private val userStreamMarkers = runBlocking<UserStreamMarkersResponse?> {
            StreamService(HttpClientMockBuilder.withJsonContent(StreamsTestData.USER_STREAM_MARKERS_WITH_PAGINATION))
                .getUserStreamMarkers(userId).nextPage()
        }

        @Test
        fun `then user stream markers are retrieved`() =
            assert(userStreamMarkers?.resources?.size == 1)

        @Test
        fun `then request has pagination cursor as parameter`() =
            assert(userStreamMarkers?.httpResponse?.request?.url?.parameters?.get("after") != null)
    }


}