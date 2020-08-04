package streams

import helix.streams.StreamKeyResponse
import helix.streams.StreamService
import io.ktor.client.statement.request
import kotlinx.coroutines.runBlocking
import org.junit.Test
import util.HttpClientMockBuilder

class `Given GET stream key with broadcaster id is called` {

    private val broadcasterId = 123L

    private val streamKeyResponse = runBlocking<StreamKeyResponse> {
        StreamService(HttpClientMockBuilder.withJsonContent(StreamsTestData.SINGLE_STREAM_KEY))
            .getStreamKey(broadcasterId)
    }

    @Test
    fun `then broadcaster id is a parameter`() =
        assert(streamKeyResponse.httpResponse.request.url.parameters["broadcaster_id"] == broadcasterId.toString())


    @Test
    fun `then one stream key is returned`() =
        assert(streamKeyResponse.resource != null)


}