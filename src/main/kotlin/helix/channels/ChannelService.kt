package helix.channels

import helix.auth.model.AuthCredentials
import helix.auth.model.AuthScope
import helix.channels.model.Channel
import helix.channels.model.ModifyChannelRequestModel
import helix.channels.model.commercial.Commercial
import helix.channels.model.commercial.CommercialLength
import helix.channels.model.commercial.CommercialRequest
import helix.channels.model.hypetrain.HypeTrain
import helix.http.ResourceService
import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.engine.apache.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

/**
 * Service class that can be used to access **Channels** endpoints:
 * *GET search channels*, *GET hype train events*, *POST start commercial* and *POST modify channel information*
 */
class ChannelService : ResourceService {

    /**
     * Creates a new channel service object given some authentication credentials and a HTTP client configuration.
     * @param credentials The authentication credentials: can be OAuth or simple credentials with only a client ID
     * @param engineConfig Engine configuration for the HTTP client. Apache engine is used as default.
     */
    constructor(credentials: AuthCredentials, engineConfig: HttpClientEngineConfig = ApacheEngineConfig())
            : super(credentials, engineConfig)

    /**
     * Creates a new channel service object given an HTTP client.
     * @param httpClient The HTTP client.
     */
    constructor(httpClient: HttpClient) : super(httpClient)

    private companion object {
        private const val BASE_URL = "${ResourceService.BASE_URL}/channels"
    }

    /**
     * Returns a list of channels (users who have streamed within the past 6 months)
     * that match the query via channel name or description either entirely or partially.
     * Results include both live and offline channels.
     * Requires an OAuth or App Access token.
     * For more information see the [Twitch Developer Reference](https://dev.twitch.tv/docs/api/reference#search-channels)
     * @param query The query that will be compared to both the channel name or description.
     * @param liveOnly Filter results for live streams only, default is false.
     * @param first Maximum number of objects to return. Maximum: 100, Default: 100.
     * @return A [ChannelsResponse] that holds a collection of [Channel] resources (can have multiple pages).
     * @sample samples.searchChannels
     */
    suspend fun getChannels(query: String, liveOnly: Boolean = false, first: Int = 100) =
        ChannelsResponse(
            httpClient.get("${ResourceService.BASE_URL}/search/channels") {
                parameter("query", query)
                parameter("live_only", liveOnly)
                parameter("first", first)
            }, httpClient
        )

    /**
     * Gets the information of the most recent Hype Train of the given channel ID.
     * When there is currently an active Hype Train, it returns information about that Hype Train.
     * When there is currently no active Hype Train, it returns information about the most recent Hype Train.
     * Requires [AuthScope.CHANNEL_READ_HYPE_TRAIN]
     * For more information see the [Twitch Developer Reference](https://dev.twitch.tv/docs/api/reference#get-hype-train-events)
     * @param broadcasterId User ID of the broadcaster. Must match the User ID in the Bearer token if User Token is used.
     * @param eventId The id of the wanted event, if known.
     * @param first Maximum number of objects to return. Maximum: 100, Default: 100.
     * @return A [HypeTrainEventsResponse] that holds a collection of [HypeTrain] resources (can have multiple pages).
     * @sample samples.getHypeTrainEvents
     */
    suspend fun getHypeTrainEvents(broadcasterId: Long, eventId: String? = null, first: Int = 100) =
        HypeTrainEventsResponse(
            httpClient.get("${ResourceService.BASE_URL}/hypetrain/events") {
                parameter("broadcaster_id", broadcasterId)
                parameter("first", first)
                eventId?.let { parameter("id", eventId) }
            }, httpClient
        )

    /**
     * Starts a commercial on a specified channel.
     * Requires [AuthScope.CHANNEL_EDIT_COMMERCIAL]
     * For more information see the [Twitch Developer Reference](https://dev.twitch.tv/docs/api/reference#start-commercial)
     * @param broadcasterId ID of the channel requesting a commercial.
     * @param length Desired length of the commercial in seconds.
     * @return A [CommercialResponse] that holds a single [Commercial] resource.
     * @sample samples.startCommercial
     */
    suspend fun startCommercial(broadcasterId: Long, length: CommercialLength) =
        CommercialResponse(
            httpClient.post("$BASE_URL/commercial") {
                contentType(ContentType.Application.Json)
                body = CommercialRequest(broadcasterId, length.length)
            }
        )

    /**
     * Modifies channel information for users.
     * All parameters are optional except the [broadcasterId] are optional, but at least one other parameter must be provided.
     * Requires [AuthScope.USER_EDIT_BROADCAST]
     * For more information see the [Twitch Developer Reference](https://dev.twitch.tv/docs/api/reference#modify-channel-information)
     * @param broadcasterId ID of the channel to be updated.
     * @param title The title of the stream.
     * @param gameId The current game ID played on the channel.
     * @param language The language of the channel.
     * @return A HTTP response object.
     * @sample samples.modifyChannelInfo
     */
    suspend fun modifyChannelInfo(
        broadcasterId: Long,
        title: String? = null,
        gameId: Long? = null,
        language: String? = null
    ) = httpClient.patch<HttpResponse>(BASE_URL) {
        contentType(ContentType.Application.Json)
        parameter("broadcaster_id", broadcasterId)
        body = ModifyChannelRequestModel(gameId.toString(), title, language)
    }

}