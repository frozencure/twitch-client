package com.github.frozencure.helix.videos

import com.github.frozencure.helix.auth.model.AuthCredentials
import com.github.frozencure.helix.exceptions.BadRequestException
import com.github.frozencure.helix.http.ResourceService
import com.github.frozencure.helix.shared.model.request.Period
import com.github.frozencure.helix.videos.model.VideoType
import com.github.frozencure.helix.videos.model.request.VideoSorting
import io.ktor.client.*
import io.ktor.client.request.*

class VideoService : ResourceService {

    constructor(credentials: AuthCredentials) : super(credentials)

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
                    parameter("type", type)
                }, httpClient
        )
    }

    suspend fun getVideosByUser(
        userId: Long, videosNumber: Int = 100,
        period: Period = Period.ALL, sorting: VideoSorting = VideoSorting.TIME,
        type: VideoType = VideoType.UPLOAD, language: String? = null
    ): ScrollableVideosResponse =
        getVideosByGameOrUser("user_id", userId, videosNumber, period, sorting, type, language)

    suspend fun getVideosByGame(
        gameId: Long, videosNumber: Int = 100,
        period: Period = Period.ALL, sorting: VideoSorting = VideoSorting.TIME,
        type: VideoType = VideoType.ALL, language: String? = null
    ): ScrollableVideosResponse =
        getVideosByGameOrUser("game_id", gameId, videosNumber, period, sorting, type, language)


}