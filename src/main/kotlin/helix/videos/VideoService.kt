package helix.videos

import helix.auth.basic.OnlyClientAuthConfig
import helix.exceptions.BadRequestException
import helix.http.ResourceService
import helix.http.credentials.ApiSettings
import helix.shared.model.request.Period
import helix.videos.model.request.VideoSorting
import helix.videos.model.request.VideoType
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class VideoService : ResourceService {

    constructor(httpClientEngineConfig: HttpClientEngineConfig, authSettings: OnlyClientAuthConfig)
            : super(httpClientEngineConfig, authSettings)

    constructor(httpClient: HttpClient) : super(httpClient)

    companion object {
        const val BASE_URL = "${ResourceService.BASE_URL}/videos"
    }

    suspend fun getVideo(id: Long) =
        VideoResponse(
            httpClient
                .get(BASE_URL) {
                    parameter("id", id)
                }
        )

    suspend fun getVideos(ids: Collection<Long>): VideosResponse {
        if (ids.size > 100) {
            throw BadRequestException("A maximum of 100 IDs can be provided for this request.")
        }
        return VideosResponse(
            httpClient
                .get(BASE_URL) {
                    ids.forEach {
                        parameter("id", it)
                    }
                }
        )
    }

    private suspend fun getVideosByGameOrUser(
        idKey: String, id: Long, videosNumber: Int,
        period: Period, sorting: VideoSorting,
        type: VideoType, language: String?
    ): ScrollableVideosResponse {
        return ScrollableVideosResponse(
            httpClient
                .get(BASE_URL) {
                    parameter(idKey, id)
                    parameter("first", videosNumber)
                    language?.let { parameter("language", it) }
                    parameter("period", period.asString)
                    parameter("sort", sorting.asString)
                    parameter("type", type.asString)
                }, httpClient
        )
    }

    suspend fun getVideosByUser(
        userId: Long, videosNumber: Int = 100,
        period: Period = Period.ALL, sorting: VideoSorting = VideoSorting.TIME,
        type: VideoType = VideoType.ALL, language: String? = null
    ): ScrollableVideosResponse =
        getVideosByGameOrUser("user_id", userId, videosNumber, period, sorting, type, language)

    suspend fun getVideosByGame(
        gameId: Long, videosNumber: Int = 100,
        period: Period = Period.ALL, sorting: VideoSorting = VideoSorting.TIME,
        type: VideoType = VideoType.ALL, language: String? = null
    ): ScrollableVideosResponse =
        getVideosByGameOrUser("game_id", gameId, videosNumber, period, sorting, type, language)


}