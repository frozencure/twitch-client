package helix.channel

import helix.http.ResourceService
import helix.http.credentials.ApiSettings
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class ChannelService : ResourceService {

    constructor(apiSettings: ApiSettings, httpClientEngineConfig: HttpClientEngineConfig)
            : super(apiSettings, httpClientEngineConfig)

    constructor(httpClient: HttpClient) : super(httpClient)

    suspend fun getChannels(query: String, liveOnly: Boolean = false, first: Int = 100) =
        ChannelsHelixResponse(
            httpClient.get("${ResourceService.BASE_URL}/search/channels") {
                parameter("query", query)
                parameter("live_only", liveOnly)
                parameter("first", first)
            }, httpClient
        )


}