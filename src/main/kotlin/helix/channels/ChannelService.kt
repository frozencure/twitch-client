package helix.channels

import helix.channels.model.commercial.CommercialLength
import helix.channels.model.commercial.CommercialRequest
import helix.http.ResourceService
import helix.http.credentials.ApiSettings
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.http.ContentType
import io.ktor.http.contentType

class ChannelService : ResourceService {

    constructor(apiSettings: ApiSettings, httpClientEngineConfig: HttpClientEngineConfig)
            : super(apiSettings, httpClientEngineConfig)

    constructor(httpClient: HttpClient) : super(httpClient)

    companion object {
        const val BASE_URL = "${ResourceService.BASE_URL}/channels"
    }

    suspend fun getChannels(query: String, liveOnly: Boolean = false, first: Int = 100) =
        ChannelsHelixResponse(
            httpClient.get("${ResourceService.BASE_URL}/search/channels") {
                parameter("query", query)
                parameter("live_only", liveOnly)
                parameter("first", first)
            }, httpClient
        )

    suspend fun getHypeTrainEvents(broadcasterId: Long, eventId: String? = null, first: Int = 100) =
        HypeTrainScrollableResponse(
            httpClient.get("${ResourceService.BASE_URL}/hypetrain/events") {
                parameter("broadcaster_id", broadcasterId)
                parameter("first", first)
                eventId?.let { parameter("id", eventId) }
            }, httpClient
        )

    suspend fun startCommercial(broadcasterId: Long, length: CommercialLength) =
        CommercialResponse(
            httpClient.post("$BASE_URL/commercial") {
                contentType(ContentType.Application.Json)
                body = CommercialRequest(broadcasterId, length.length)
            }
        )


}