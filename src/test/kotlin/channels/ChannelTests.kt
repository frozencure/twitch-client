package channels

import helix.channels.ChannelService
import helix.channels.ChannelsHelixResponse
import io.ktor.client.statement.request
import kotlinx.coroutines.runBlocking
import org.junit.Test
import util.HttpClientMockBuilder

class `Given GET channels is called with query and multiple streams are returned` {

    private val query = "lirik loserfruit"

    private val channelsResponse = runBlocking<ChannelsHelixResponse> {
        ChannelService(HttpClientMockBuilder.withJsonContent(ChannelsTestData.MULTIPLE_CHANNELS_WITH_PAGINATION))
            .getChannels(query)
    }

    @Test
    fun `then a multiple stream objects are retrieved`() =
        assert(channelsResponse.resources.size == 2)


    @Test
    fun `then pagination exists`() =
        assert(channelsResponse.pagination != null)

    @Test
    fun `then first is a parameter and is equal to default value`() =
        assert(channelsResponse.httpResponse.request.url.parameters["first"] == "100")

    @Test
    fun `then the query is a parameter`() =
        assert(channelsResponse.httpResponse.request.url.parameters["query"] == query)


    @Test
    fun `then live_only is a parameter and has default value`() =
        assert(channelsResponse.httpResponse.request.url.parameters["live_only"] == "false")

    class `And next page is retreived` {

        private val query = "lirik loserfruit"

        private val channelsResponse = runBlocking<ChannelsHelixResponse?> {
            ChannelService(HttpClientMockBuilder.withJsonContent(ChannelsTestData.MULTIPLE_CHANNELS_WITH_PAGINATION))
                .getChannels(query).nextPage()
        }

        @Test
        fun `then multiple channels are retrieved`() =
            assert(channelsResponse?.resources?.size == 2)

        @Test
        fun `then pagination cursor is a parameter`() =
            assert(channelsResponse?.httpResponse?.request?.url?.parameters?.get("after") != null)
    }
}