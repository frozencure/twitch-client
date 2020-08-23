package channels

import com.github.frozencure.helix.channels.ChannelService
import com.github.frozencure.helix.channels.ChannelsResponse
import com.github.frozencure.helix.channels.CommercialResponse
import com.github.frozencure.helix.channels.HypeTrainEventsResponse
import com.github.frozencure.helix.channels.model.ModifyChannelRequestModel
import com.github.frozencure.helix.channels.model.commercial.CommercialLength
import com.github.frozencure.helix.channels.model.commercial.CommercialRequest
import io.ktor.client.statement.*
import io.ktor.content.*
import io.ktor.http.*
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json.Default.encodeToString
import org.junit.Test
import util.HttpClientMockBuilder

class `Given GET channels is called with query and multiple streams are returned` {

    private val query = "lirik loserfruit"

    private val channelsResponse = runBlocking<ChannelsResponse> {
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

        private val channelsResponse = runBlocking<ChannelsResponse?> {
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

class `Given GET hype train events is called with broadcaster id and event id` {

    private val broadcasterId = 270954519L

    private val eventId = "1b0AsbInCHZW2SQFQkCzqN07Ib2"

    private val hypeTrainResponse = runBlocking<HypeTrainEventsResponse> {
        ChannelService(HttpClientMockBuilder.withJsonContent(ChannelsTestData.HYPE_TRAIN_EVENTS_WITH_PAGINATION))
            .getHypeTrainEvents(broadcasterId, eventId)
    }

    @Test
    fun `then a single hype train event is retrieved`() =
        assert(hypeTrainResponse.resources.size == 1)


    @Test
    fun `then pagination exists`() =
        assert(hypeTrainResponse.pagination != null)

    @Test
    fun `then first is a parameter and is equal to default value`() =
        assert(hypeTrainResponse.httpResponse.request.url.parameters["first"] == "100")

    @Test
    fun `then broadcaster id is a parameter`() =
        assert(hypeTrainResponse.httpResponse.request.url.parameters["broadcaster_id"] == broadcasterId.toString())

    @Test
    fun `then event id is a parameter`() =
        assert(hypeTrainResponse.httpResponse.request.url.parameters["id"] == eventId)

    class `When next page is retrieved` {

        private val broadcasterId = 270954519L

        private val eventId = "1b0AsbInCHZW2SQFQkCzqN07Ib2"

        private val hypeTrainResponse = runBlocking<HypeTrainEventsResponse?> {
            ChannelService(HttpClientMockBuilder.withJsonContent(ChannelsTestData.HYPE_TRAIN_EVENTS_WITH_PAGINATION))
                .getHypeTrainEvents(broadcasterId, eventId).nextPage()
        }


        @Test
        fun `then a single hype train event is retrieved`() =
            assert(hypeTrainResponse?.resources?.size == 1)

        @Test
        fun `then pagination cursor is a parameter`() =
            assert(hypeTrainResponse?.httpResponse?.request?.url?.parameters?.get("cursor") != null)
    }
}

class `Given POST start commercial with broadcaster id and length is called` {

    private val length = CommercialLength.THIRTY

    private val broadcasterId = 123L

    private val commercialResponse = runBlocking<CommercialResponse> {
        ChannelService(HttpClientMockBuilder.withJsonContent(ChannelsTestData.COMMERCIAL))
            .startCommercial(broadcasterId, length)
    }

    @Test
    fun `then request has broadcaster id and length in body`() = assert(
        (commercialResponse.httpResponse.request.content as TextContent).text == encodeToString(
            CommercialRequest.serializer(),
            CommercialRequest(
                broadcasterId,
                30
            )
        )
    )

    @Test
    fun `then one commercial is retrieved`() =
        assert(commercialResponse.resource != null)
}

class `Given PATCH modify channel information is called` {

    private val broadcasterId = 1L
    private val gameId = 123L

    private val title = "new title"

    private val language = "en"

    private val modifyInfoResponse = runBlocking<HttpResponse> {
        ChannelService(HttpClientMockBuilder.withStatusResponse(HttpStatusCode.NoContent))
            .modifyChannelInfo(broadcasterId, title, gameId, language)
    }

    @Test
    fun `then request has broadcaster id, game id, title, language in body`() = assert(
        (modifyInfoResponse.request.content as TextContent).text == encodeToString(
            ModifyChannelRequestModel.serializer(),
            ModifyChannelRequestModel(
                gameId.toString(),
                title,
                language
            )
        )
    )

    @Test
    fun `then request has broadcaster id as parameter`() =
        assert(modifyInfoResponse.request.url.parameters["broadcaster_id"] == broadcasterId.toString())


}