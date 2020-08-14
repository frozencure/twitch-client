package helix.clips

import helix.auth.model.AuthCredentials
import helix.exceptions.BadRequestException
import helix.http.ResourceService
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.apache.ApacheEngineConfig
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import java.time.Instant

class ClipService : ResourceService {

    constructor(credentials: AuthCredentials, engineConfig: HttpClientEngineConfig = ApacheEngineConfig())
            : super(credentials, engineConfig)

    constructor(httpClient: HttpClient) : super(httpClient)

    companion object {
        const val BASE_URL = "${ResourceService.BASE_URL}/clips"
    }

    suspend fun getClip(id: String) = ClipResponse(
        httpClient.get(BASE_URL) {
            parameter("id", id)
        }
    )

    suspend fun getClips(ids: Collection<String>): ClipsResponse {
        if (ids.size > 100) {
            throw BadRequestException("The maximum number of clips that can be retrieved cannot exceed 100")
        }
        return ClipsResponse(
            httpClient.get(BASE_URL)
            {
                ids.forEach {
                    parameter("id", it)
                }
            }
        )
    }

    private suspend fun getClipsByGameOrBroadcaster(
        idKey: String,
        id: Long,
        startedAt: Instant?,
        endedAt: Instant?
    ) =
        ScrollableClipsResponse(
            httpClient.get(BASE_URL)
            {
                parameter(idKey, id)
                startedAt?.let { parameter("started_at", it) }
                endedAt?.let { parameter("ended_at", it) }
            }, httpClient
        )

    suspend fun getClipsByBroadcaster(broadcasterId: Long, startedAt: Instant? = null, endedAt: Instant? = null) =
        getClipsByGameOrBroadcaster("broadcaster_id", broadcasterId, startedAt, endedAt)

    suspend fun getClipsByGame(gameId: Long, startedAt: Instant? = null, endedAt: Instant? = null) =
        getClipsByGameOrBroadcaster("game_id", gameId, startedAt, endedAt)


    suspend fun createClip(broadcasterId: Long, hasDelay: Boolean = false) = ClipCreationResponse(
        httpClient.post(BASE_URL) {
            parameter("broadcaster_id", broadcasterId)
            parameter("has_delay", hasDelay)
        }
    )


}