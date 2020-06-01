package streams

import helix.streams.StreamService
import helix.streams.metadata.StreamsMetadataHelixResponse
import io.ktor.client.statement.request
import kotlinx.coroutines.runBlocking
import org.junit.Test
import util.HttpClientMockBuilder

class `Given GET streams metadata is called and a Hearthstone stream is retrieved` {

    private val streamMarkerResponse = runBlocking<StreamsMetadataHelixResponse> {
        StreamService(HttpClientMockBuilder.withJsonContent(StreamsTestData.HEARTHSTONE_STREAM_METADATA))
            .getStreamsMetadata()
    }

    @Test
    fun `then a stream metadata object is retrieved`() =
        assert(streamMarkerResponse.resources.size == 1)


    @Test
    fun `then retrieved stream has hearthstone metadata`() =
        assert(streamMarkerResponse.resources.first().hearthstoneMetadata != null)


    @Test
    fun `then retrieved stream has metadata for broadcaster hero`() =
        assert(streamMarkerResponse.resources.first().hearthstoneMetadata?.broadcaster?.hero != null)

    @Test
    fun `then retrieved stream metadata for opponent hero`() =
        assert(streamMarkerResponse.resources.first().hearthstoneMetadata?.opponent?.hero != null)

}


class `Given GET streams metadata is called and an Overwatch stream is retrieved` {

    private val streamMarkerResponse = runBlocking<StreamsMetadataHelixResponse> {
        StreamService(HttpClientMockBuilder.withJsonContent(StreamsTestData.OVERWATCH_STREAM_METADATA))
            .getStreamsMetadata()
    }

    @Test
    fun `then a stream metadata object is retrieved`() =
        assert(streamMarkerResponse.resources.size == 1)


    @Test
    fun `then retrieved stream has Overwatch metadata`() =
        assert(streamMarkerResponse.resources.first().overwatchMetadata != null)


    @Test
    fun `then retrieved stream has metadata for broadcaster hero`() =
        assert(streamMarkerResponse.resources.first().overwatchMetadata?.broadcaster?.hero != null)

}


class `Given GET streams metadata is called and a stream without metadata is retrieved` {

    private val streamMarkerResponse = runBlocking<StreamsMetadataHelixResponse> {
        StreamService(HttpClientMockBuilder.withJsonContent(StreamsTestData.EMPTY_STREAM_METADATA))
            .getStreamsMetadata()
    }

    @Test
    fun `then a stream metadata object is retrieved`() =
        assert(streamMarkerResponse.resources.size == 1)


    @Test
    fun `then retrieved stream has no Overwatch metadata`() =
        assert(streamMarkerResponse.resources.first().overwatchMetadata == null)


    @Test
    fun `then retrieved stream has no Hearthstone metadata`() =
        assert(streamMarkerResponse.resources.first().hearthstoneMetadata == null)

    @Test
    fun `then retrieved stream has no game ID`() =
        assert(streamMarkerResponse.resources.first().gameId == null)
}

class `Given GET streams metadata is called and multiple streams are retrieved` {

    private val userIds = listOf<Long>(1234, 12345)

    private val streamMarkerResponse = runBlocking<StreamsMetadataHelixResponse> {
        StreamService(HttpClientMockBuilder.withJsonContent(StreamsTestData.MULTIPLE_STREAMS_METADATA_WITH_PAGINATION))
            .getStreamsMetadata(userIds = userIds)
    }


    @Test
    fun `then a multiple stream metadata objects are retrieved`() =
        assert(streamMarkerResponse.resources.size == 3)


    @Test
    fun `then pagination exists`() =
        assert(streamMarkerResponse.pagination != null)

    @Test
    fun `then user ids are parameters`() =
        assert(streamMarkerResponse.httpResponse.request.url.parameters
            .getAll("user_id") == userIds.map { it.toString() })


    class `And next page is retreived` {

        private val streamMarkerResponse = runBlocking<StreamsMetadataHelixResponse?> {
            StreamService(HttpClientMockBuilder.withJsonContent(StreamsTestData.MULTIPLE_STREAMS_METADATA_WITH_PAGINATION))
                .getStreamsMetadata().nextPage()
        }

        @Test
        fun `then a multiple stream metadata objects are retrieved`() =
            assert(streamMarkerResponse?.resources?.size == 3)

        @Test
        fun `then pagination cursor is a parameter`() =
            assert(streamMarkerResponse?.httpResponse?.request?.url?.parameters?.get("after") != null)

    }
}