package helix.streams

import helix.exceptions.BadRequestException
import helix.http.ResourceService
import helix.http.credentials.ApiSettings
import helix.streams.markers.StreamMarkerHelixResponse
import helix.streams.markers.UserStreamMarkersResponse
import helix.streams.markers.model.StreamMarkerRequest
import helix.streams.metadata.StreamsMetadataHelixResponse
import helix.streams.tags.StreamTagsHelixResponse
import helix.streams.tags.model.ReplaceTagsRequest
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType

class StreamService : ResourceService {

    constructor(apiSettings: ApiSettings, httpClientEngineConfig: HttpClientEngineConfig)
            : super(apiSettings, httpClientEngineConfig)

    constructor(httpClient: HttpClient) : super(httpClient)

    companion object {
        const val BASE_URL = "${ResourceService.BASE_URL}/streams"
    }

    suspend fun getStreams(
        first: Int = 100, gameIds: Collection<Long>? = null,
        languages: Collection<String>? = null,
        userIds: Collection<Long>? = null,
        userLoginNames: Collection<String>? = null
    ): StreamsHelixResponse {
        checkForBadRequest(gameIds, languages, userIds, userLoginNames)
        return StreamsHelixResponse(
            httpGetWithNullables(BASE_URL, first, gameIds, languages, userIds, userLoginNames),
            httpClient
        )
    }

    suspend fun createStreamMarker(userId: Long, description: String? = null) =
        StreamMarkerHelixResponse(
            httpClient.post("$BASE_URL/markers") {
                contentType(ContentType.Application.Json)
                body = StreamMarkerRequest(userId, description)
            }
        )

    suspend fun getUserStreamMarkers(userId: Long, first: Int = 100) =
        getStreamMarkersByUserOrVideo("user_id", userId, first)

    suspend fun getVideoStreamMarkers(videoId: Long, first: Int = 100) =
        getStreamMarkersByUserOrVideo("video_id", videoId, first)

    suspend fun getStreamsMetadata(
        first: Int = 100, gameIds: Collection<Long>? = null,
        languages: Collection<String>? = null,
        userIds: Collection<Long>? = null,
        userLoginNames: Collection<String>? = null
    ): StreamsMetadataHelixResponse {
        checkForBadRequest(gameIds, languages, userIds, userLoginNames)
        return StreamsMetadataHelixResponse(
            httpGetWithNullables("$BASE_URL/metadata", first, gameIds, languages, userIds, userLoginNames),
            httpClient
        )
    }

    suspend fun getStreamTags(
        tagIds: Collection<String>? = null, first: Int = 100
    ): StreamTagsHelixResponse {
        tagIds?.let {
            if (it.size > 100) {
                throw BadRequestException("A maximum of 100 tag IDs can be specified.")
            }
        }
        return StreamTagsHelixResponse(
            httpClient.get("${ResourceService.BASE_URL}/tags/streams") {
                parameter("first", first)
                tagIds?.forEach {
                    parameter("tag_id", it)
                }
            }, httpClient
        )
    }

    suspend fun getStreamTags(broadcasterId: Long) = StreamTagsHelixResponse(
        httpClient.get("$BASE_URL/tags") {
            parameter("broadcaster_id", broadcasterId)
        }, httpClient
    )

    suspend fun updateStreamTags(broadcasterId: Long, tags: Collection<String>? = null) =
        httpClient.put<HttpResponse>("$BASE_URL/tags") {
            parameter("broadcaster_id", broadcasterId)
            tags?.let {
                contentType(ContentType.Application.Json)
                body = ReplaceTagsRequest(tags)
            }
        }

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