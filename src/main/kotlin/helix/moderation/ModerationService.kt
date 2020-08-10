package helix.moderation

import helix.exceptions.BadRequestException
import helix.http.ResourceService
import helix.http.credentials.ApiSettings
import helix.moderation.model.AutoModMessage
import helix.moderation.model.AutoModRequest
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.request.get
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
        AutoModResponse(
            httpClient.post("${BASE_URL}/enforcements/status") {
                contentType(ContentType.Application.Json)
                parameter("broadcaster_id", broadcasterId)
                body = AutoModRequest(messages)
            }
        )

    suspend fun getBannedUsers(broadcasterId: Long, userIds: Collection<Long>? = null) = BannedUsersScrollableResponse(
        httpClient.get("${BASE_URL}/banned") {
            parameter("broadcaster_id", broadcasterId)
            userIds?.let {
                if (userIds.size > 100) {
                    throw BadRequestException("A maximum of 100 user IDs can be specified.")
                }
                userIds.forEach { parameter("user_id", it) }
            }
        }, httpClient
    )

    suspend fun getModerators(broadcasterId: Long, userIds: Collection<Long>? = null) =
        ModeratorsScrollableResponse(
            httpClient.get("${BASE_URL}/moderators") {
                parameter("broadcaster_id", broadcasterId)
                userIds?.let {
                    if (userIds.size > 100) {
                        throw BadRequestException("A maximum of 100 user IDs can be specified.")
                    }
                    userIds.forEach { parameter("user_id", it) }
                }
            }, httpClient
        )

    suspend fun getBanEvents(broadcasterId: Long, userIds: Collection<Long>? = null, first: Int = 100) =
        BanEventsScrollableResponse(
            httpClient.get("${BASE_URL}/banned/events") {
                parameter("broadcaster_id", broadcasterId)
                parameter("first", first)
                userIds?.let {
                    if (userIds.size > 100) {
                        throw BadRequestException("A maximum of 100 user IDs can be specified.")
                    }
                    userIds.forEach { parameter("user_id", it) }
                }
            }, httpClient
        )

    suspend fun getModeratorEvents(broadcasterId: Long, userIds: Collection<Long>? = null) =
        ModeratorEventsScrollableResponse(
            httpClient.get("${BASE_URL}/moderators/events") {
                parameter("broadcaster_id", broadcasterId)
                userIds?.let {
                    if (userIds.size > 100) {
                        throw BadRequestException("A maximum of 100 user IDs can be specified.")
                    }
                    userIds.forEach { parameter("user_id", it) }
                }
            }, httpClient
        )


}