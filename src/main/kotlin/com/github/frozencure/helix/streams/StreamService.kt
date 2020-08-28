package com.github.frozencure.helix.streams

import com.github.frozencure.helix.auth.model.AuthCredentials
import com.github.frozencure.helix.auth.model.AuthScope
import com.github.frozencure.helix.exceptions.BadRequestException
import com.github.frozencure.helix.http.ResourceService
import com.github.frozencure.helix.streams.key.StreamKey
import com.github.frozencure.helix.streams.markers.StreamMarkerResponse
import com.github.frozencure.helix.streams.markers.UserStreamMarkersResponse
import com.github.frozencure.helix.streams.markers.model.StreamMarker
import com.github.frozencure.helix.streams.markers.model.StreamMarkerRequestModel
import com.github.frozencure.helix.streams.markers.model.VideoMarkers
import com.github.frozencure.helix.streams.model.Stream
import com.github.frozencure.helix.streams.tags.StreamTagsResponse
import com.github.frozencure.helix.streams.tags.model.ReplaceTagsRequestModel
import com.github.frozencure.helix.streams.tags.model.StreamTag
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

/**
 * Service class that can be used to access **Streams** endpoints:
 * *GET streams*, *POST create stream marker*, *GET user stream markers*,
 * *GET stream tags*, *GET stream key* and *POST update stream tags*
 */
class StreamService : ResourceService {

    /**
     * Creates a new stream service object given some authentication credentials and a HTTP client configuration.
     * @param credentials The authentication credentials: can be OAuth or simple credentials with only a client ID
     */
    constructor(credentials: AuthCredentials) : super(credentials)

    /**
     * Creates a new stream service object given an HTTP client.
     * @param httpClient The HTTP client.
     */
    constructor(httpClient: HttpClient) : super(httpClient)

    private companion object {
        private const val BASE_URL = "${ResourceService.BASE_URL}/streams"
    }

    /**
     * Gets information about active streams. Streams are returned sorted by number of current viewers, in descending order.
     * Requires app or user access token.
     * For more information visit the [Twitch Developer Reference](https://dev.twitch.tv/docs/api/reference#get-streams)
     * @param first Maximum number of streams to return. Maximum: 100. Default: 100.
     * @param gameIds A collection of game IDs for which to return the active streams.
     * @param languages A collection of languages for which to return the active streams.
     * @param userIds If specified, will return the streams for the given user IDs.
     * @param userLoginNames If specified, will return the streams for the given user login names.
     * @throws BadRequestException Exception will be thrown if more than the specified number of languages, user IDs, game IDs, user login names are specified. Please see the exception message.
     * @return A [StreamsResponse] that holds one or multiple [Stream] resources as payload (can have multiple pages).
     * @sample samples.getStreams
     */
    suspend fun getStreams(
        first: Int = 100, gameIds: Collection<Long>? = null,
        languages: Collection<String>? = null,
        userIds: Collection<Long>? = null,
        userLoginNames: Collection<String>? = null
    ): StreamsResponse {
        checkForBadRequest(gameIds, languages, userIds, userLoginNames)
        return StreamsResponse(
            httpGetWithNullables(BASE_URL, first, gameIds, languages, userIds, userLoginNames),
            httpClient
        )
    }

    /**
     * Creates a marker in the stream of a user specified by a user ID. A marker is an arbitrary point in
     * a stream that the broadcaster wants to mark; e.g., to easily return to later.
     * The marker is created at the current timestamp in the live broadcast when the request is processed.
     * Requires the [AuthScope.USER_EDIT_BROADCAST] scope.
     * For more information visit the [Twitch Developer Reference](https://dev.twitch.tv/docs/api/reference#create-stream-marker)
     * @param userId The identifier of the user who is streaming.
     * @param description A description for the marker.
     * @return A [StreamMarkerResponse] that has a single [StreamMarker] resource as payload.
     * @sample samples.createStreamMarker
     */
    suspend fun createStreamMarker(userId: Long, description: String? = null) =
        StreamMarkerResponse(
            httpClient.post("$BASE_URL/markers") {
                contentType(ContentType.Application.Json)
                body = StreamMarkerRequestModel(userId, description)
            }
        )

    /**
     * Gets a list of markers for either a specified user’s most recent stream or a specified VOD/video (stream), ordered by recency.
     * Requires the [AuthScope.USER_READ_BROADCAST] scope.
     * For more information visit the [Twitch Developer Reference](https://dev.twitch.tv/docs/api/reference#get-stream-markers)
     * @param userId ID of the broadcaster from whose stream markers are returned.
     * @param first Number of stream markers to be returned. Maximum 100, Default 100.
     * @return A [StreamMarkerResponse] that holds one or multiple [VideoMarkers] resources (can have multiple pages).
     * @sample samples.getUserStreamMarkers
     */
    suspend fun getUserStreamMarkers(userId: Long, first: Int = 100) =
        getStreamMarkersByUserOrVideo("user_id", userId, first)

    /**
     * Gets a list of markers for either a specified user’s most recent stream or a specified VOD/video (stream), ordered by recency.
     * Requires the [AuthScope.USER_READ_BROADCAST] scope.
     * For more information visit the [Twitch Developer Reference](https://dev.twitch.tv/docs/api/reference#get-stream-markers)
     * @param videoId ID of the VOD/video whose stream markers are returned.
     * @param first Number of stream markers to be returned. Maximum 100, Default 100.
     * @return A [StreamMarkerResponse] that holds one or multiple [VideoMarkers] resources (can have multiple pages).
     * @sample samples.getVideoStreamMarkers
     */
    suspend fun getVideoStreamMarkers(videoId: Long, first: Int = 100) =
        getStreamMarkersByUserOrVideo("video_id", videoId, first)

    /**
     * Gets the list of all stream tags defined by Twitch, optionally filtered by tag ID(s).
     * For more information visit the [Twitch Developer Reference](https://dev.twitch.tv/docs/api/reference#get-all-stream-tags)
     * @param tagIds If specified, only these tags will be returned.
     * @param first Number of tags to be returned. Maximum 100, Default 100.
     * @return A [StreamTagsResponse] that holds one or multiple [StreamTag] resources (can have multiple pages).
     * @throws BadRequestException Exception is thrown if more than 100 tag IDs are specified.
     * @sample samples.getAllStreamTags
     */
    suspend fun getAllStreamTags(
        tagIds: Collection<String>? = null, first: Int = 100
    ): StreamTagsResponse {
        tagIds?.let {
            if (it.size > 100) {
                throw BadRequestException("A maximum of 100 tag IDs can be specified.")
            }
        }
        return StreamTagsResponse(
            httpClient.get("${ResourceService.BASE_URL}/tags/streams") {
                parameter("first", first)
                tagIds?.forEach {
                    parameter("tag_id", it)
                }
            }, httpClient
        )
    }

    /**
     * Gets the list of tags for a specified stream (channel).
     * Requires an app access token.
     * For more information visit the [Twitch Developer Reference](https://dev.twitch.tv/docs/api/reference#get-stream-tags)
     * @param broadcasterId The identifier of the user who owns the stream.
     * @return A [StreamTagsResponse] that holds one or multiple [StreamTag] resources.
     * @sample samples.getStreamTags
     */
    suspend fun getStreamTags(broadcasterId: Long) = StreamTagsResponse(
        httpClient.get("$BASE_URL/tags") {
            parameter("broadcaster_id", broadcasterId)
        }, httpClient
    )

    /**
     * Applies specified tags to a specified stream, overwriting any existing tags applied to that stream.
     * If no tags are specified, all tags previously applied to the stream are removed.
     * Requires an [AuthScope.USER_EDIT_BROADCAST] scope.
     * For more information visit the [Twitch Developer Reference](https://dev.twitch.tv/docs/api/reference#replace-stream-tags)
     * @param broadcasterId The identifier of the user who owns the stream.
     * @param tags The IDs of the tags to be applied to the stream.
     * @return An [HttpResponse] that holds information about the update, if it was successful.
     * @sample samples.updateStreamTags
     */
    suspend fun updateStreamTags(broadcasterId: Long, tags: Collection<String>? = null) =
        httpClient.put<HttpResponse>("$BASE_URL/tags") {
            parameter("broadcaster_id", broadcasterId)
            tags?.let {
                contentType(ContentType.Application.Json)
                body = ReplaceTagsRequestModel(tags)
            }
        }

    /**
     * Gets the channel stream key for a user.
     * Requires an [AuthScope.CHANNEL_READ_STREAM_KEY] scope.
     * For more information visit the [Twitch Developer Reference](https://dev.twitch.tv/docs/api/reference#get-stream-key)
     * @param broadcasterId The identifier of the broadcaster.
     * @return A [StreamKeyResponse] that has a single [StreamKey] resource as payload.
     * @sample samples.getStreamKey
     */
    suspend fun getStreamKey(broadcasterId: Long) = StreamKeyResponse(
        httpClient.get("$BASE_URL/key") {
            parameter("broadcaster_id", broadcasterId)
        }
    )

    private suspend fun getStreamMarkersByUserOrVideo(idKey: String, id: Long, first: Int) =
        UserStreamMarkersResponse(
            httpClient.post("$BASE_URL/markers") {
                parameter(idKey, id)
                parameter("first", first)
            }, httpClient
        )

    private fun checkForBadRequest(
        gameIds: Collection<Long>? = null,
        languages: Collection<String>? = null,
        userIds: Collection<Long>? = null,
        userLoginNames: Collection<String>? = null
    ) {
        gameIds?.let {
            if (it.size > 10) {
                throw BadRequestException("A maximum of 10 game IDs can be specified.")
            }
        }
        languages?.let {
            if (it.size > 100) {
                throw BadRequestException("A maximum of 100 languages can be specified.")
            }
        }
        userIds?.let {
            if (it.size > 100) {
                throw BadRequestException("A maximum of 100 user IDs can be specified.")
            }
        }
        userLoginNames?.let {
            if (it.size > 100) {
                throw BadRequestException("A maximum of 100 user login names can be specified.")
            }
        }
    }

    private suspend inline fun <reified T> httpGetWithNullables(
        url: String,
        first: Int, gameIds: Collection<Long>? = null,
        languages: Collection<String>? = null,
        userIds: Collection<Long>? = null,
        userLoginNames: Collection<String>? = null
    ) = httpClient
        .get<T>(url) {
            parameter("first", first)
            gameIds?.forEach {
                parameter("game_id", it)
            }
            languages?.forEach {
                parameter("language", it)
            }
            userIds?.forEach {
                parameter("user_id", it)
            }
            userLoginNames?.forEach {
                parameter("user_login", it)
            }
        }
}