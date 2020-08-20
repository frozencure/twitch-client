package helix.clips

import helix.auth.model.AuthCredentials
import helix.clips.model.Clip
import helix.clips.model.ClipCreation
import helix.exceptions.BadRequestException
import helix.http.ResourceService
import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.engine.apache.*
import io.ktor.client.request.*
import java.time.Instant
import helix.auth.model.AuthScope

/**
 * Service class that can be used to access **Clips** endpoints:
 * *GET clips* and *POST create clip*
 */
class ClipService : ResourceService {

    /**
     * Creates a new clip service object given some authentication credentials and a HTTP client configuration.
     * @param credentials The authentication credentials: can be OAuth or simple credentials with only a client ID
     * @param engineConfig Engine configuration for the HTTP client. Apache engine is used as default.
     */
    constructor(credentials: AuthCredentials, engineConfig: HttpClientEngineConfig = ApacheEngineConfig())
            : super(credentials, engineConfig)

    /**
     * Creates a new clip service object given an HTTP client.
     * @param httpClient The HTTP client.
     */
    constructor(httpClient: HttpClient) : super(httpClient)

    private companion object {
        private const val BASE_URL = "${ResourceService.BASE_URL}/clips"
    }

    /**
     * Gets the information about a single clip given the clip ID.
     * Requires no authentication.
     * For more information visit the [Twitch Developer Reference](https://dev.twitch.tv/docs/api/reference#get-clips)
     * @param id The ID of the clip.
     * @return A [ClipResponse] that holds a single [Clip] resource.
     * @sample samples.getSingleClip
     */
    suspend fun getClip(id: String) = ClipResponse(
        httpClient.get(BASE_URL) {
            parameter("id", id)
        }
    )

    /**
     * Gets the information about a multiple clips given a collection of clip IDs.
     * Requires no authentication.
     * For more information visit the [Twitch Developer Reference](https://dev.twitch.tv/docs/api/reference#get-clips)
     * @param ids The ID of the clip.
     * @return A [ClipsResponse] that holds a collection of [Clip] resources.
     * @sample samples.getMultipleClips
     * @throws BadRequestException Exception is thrown if more than 100 clip IDs are specified.
     */
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

    /**
     * Gets the information about a multiple clips given a broadcaster ID.
     * If [startedAt] is specified, [endedAt] has to be also specified,
     * otherwise a default value of one week later than [startedAt] will be used.
     * Requires no authentication.
     * For more information visit the [Twitch Developer Reference](https://dev.twitch.tv/docs/api/reference#get-clips)
     * @param broadcasterId The ID of the user that owns the broadcast from which the clip was created.
     * @param startedAt If specified, only clips created at later timestamp than this will be retrieved.
     * @param endedAt If specified, only clips created before this timestamp will be retrieved.
     * @return A [ScrollableClipsResponse] that holds a collection of [Clip] resources as payload. (can have multiple pages)
     * @sample samples.getClipsByBroadcaster
     */
    suspend fun getClipsByBroadcaster(broadcasterId: Long, startedAt: Instant? = null, endedAt: Instant? = null) =
        getClipsByGameOrBroadcaster("broadcaster_id", broadcasterId, startedAt, endedAt)

    /**
     * Gets the information about a multiple clips given a game ID.
     * If [startedAt] is specified, [endedAt] has to be also specified,
     * otherwise a default value of one week later than [startedAt] will be used.
     * Requires no authentication.
     * For more information visit the [Twitch Developer Reference](https://dev.twitch.tv/docs/api/reference#get-clips)
     * @param gameId The ID of the game that was being played when the clip was created.
     * @param startedAt If specified, only clips created at later timestamp than this will be retrieved.
     * @param endedAt If specified, only clips created before this timestamp will be retrieved.
     * @return A [ScrollableClipsResponse] that holds a collection of [Clip] resources as payload. (can have multiple pages)
     * @sample samples.getClipsByGame
     */
    suspend fun getClipsByGame(gameId: Long, startedAt: Instant? = null, endedAt: Instant? = null) =
        getClipsByGameOrBroadcaster("game_id", gameId, startedAt, endedAt)


    /**
     * Creates a clip programmatically.
     * Requires [AuthScope.EDIT_CLIPS]
     * @param broadcasterId The ID of the user that owns the broadcast from which the clip will be created.
     * @param hasDelay If false, the clip is captured from the live stream when the API is called. Otherwise a short delay is added.
     * @return A [ClipCreationResponse] that holds a single [ClipCreation] resource as payload.
     * @sample samples.createClip
     */
    suspend fun createClip(broadcasterId: Long, hasDelay: Boolean = false) = ClipCreationResponse(
        httpClient.post(BASE_URL) {
            parameter("broadcaster_id", broadcasterId)
            parameter("has_delay", hasDelay)
        }
    )


}