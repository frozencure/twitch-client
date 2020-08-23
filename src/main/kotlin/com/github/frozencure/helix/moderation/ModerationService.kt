package com.github.frozencure.helix.moderation

import com.github.frozencure.helix.auth.model.AuthCredentials
import com.github.frozencure.helix.exceptions.BadRequestException
import com.github.frozencure.helix.http.ResourceService
import com.github.frozencure.helix.moderation.model.AutoModMessage
import com.github.frozencure.helix.moderation.model.AutoModRequest
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*

class ModerationService : ResourceService {

    constructor(credentials: AuthCredentials) : super(credentials)

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