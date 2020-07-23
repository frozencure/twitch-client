package helix.moderation

import helix.http.ResourceService
import helix.http.credentials.ApiSettings
import helix.moderation.model.AutoModMessage
import helix.moderation.model.AutoModRequest
import helix.streams.markers.StreamMarkerHelixResponse
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.http.ContentType
import io.ktor.http.contentType

class ModerationService : ResourceService {

    constructor(apiSettings: ApiSettings, httpClientEngineConfig: HttpClientEngineConfig)
            : super(apiSettings, httpClientEngineConfig)

    constructor(httpClient: HttpClient) : super(httpClient)

    companion object {
        const val BASE_URL = "${ResourceService.BASE_URL}/moderation"
    }

    suspend fun checkMessagesWithAutoMod(broadcasterId: Long, messages: Collection<AutoModMessage>) =
        AutoModHelixResponse(
            httpClient.post("${ModerationService.BASE_URL}/enforcements/status") {
                contentType(ContentType.Application.Json)
                parameter("broadcaster_id", broadcasterId)
                body = AutoModRequest(messages)
            }
        )


}