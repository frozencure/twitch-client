package streams

import helix.streams.StreamService
import helix.streams.StreamsHelixResponse
import io.ktor.client.statement.request
import kotlinx.coroutines.runBlocking
import org.junit.Test
import util.HttpClientMockBuilder

class `Given GET streams is called and multiple streams are retrieved` {

    private val userIds = listOf<Long>(1234, 12345)

    private val streamsResponse = runBlocking<StreamsHelixResponse> {
        StreamService(HttpClientMockBuilder.withJsonContent(StreamsTestData.MULTIPLE_STREAMS_WITH_PAGINATION))
            .getStreams(userIds = userIds)
    }


    @Test
    fun `then a multiple stream objects are retrieved`() =
        assert(streamsResponse.resources.size == 2)


    @Test
    fun `then pagination exists`() =
        assert(streamsResponse.pagination != null)

    @Test
    fun `then user ids are parameters`() =
        assert(streamsResponse.httpResponse.request.url.parameters
            .getAll("user_id") == userIds.map { it.toString() })


    class `And next page is retreived` {

        private val streamsResponse = runBlocking<StreamsHelixResponse?> {
            StreamService(HttpClientMockBuilder.withJsonContent(StreamsTestData.MULTIPLE_STREAMS_WITH_PAGINATION))
                .getStreams().nextPage()
        }

        @Test
        fun `then a multiple stream metadata objects are retrieved`() =
            assert(streamsResponse?.resources?.size == 2)

        @Test
        fun `then pagination cursor is a parameter`() =
            assert(streamsResponse?.httpResponse?.request?.url?.parameters?.get("after") != null)

    }
}