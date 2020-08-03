package helix.users

import helix.exceptions.BadRequestException
import helix.extensions.ExtensionsHelixResponse
import helix.http.ResourceService
import helix.http.credentials.ApiSettings
import helix.users.model.ChangeFollowRequest
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.request.*
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.serialization.UnstableDefault

@UnstableDefault
class UserService : ResourceService {

    constructor(apiSettings: ApiSettings, httpClientEngineConfig: HttpClientEngineConfig)
            : super(apiSettings, httpClientEngineConfig)

    constructor(httpClient: HttpClient) : super(httpClient)

    companion object {
        const val BASE_URL = "${ResourceService.BASE_URL}/users"
    }

    suspend fun getUser(): UserHelixResponse =
        UserHelixResponse(
            httpClient
                .get(BASE_URL)
        )


    suspend fun getUser(userId: Long): UserHelixResponse =
        UserHelixResponse(httpClient
            .get(BASE_URL) {
                parameter("id", userId)
            })


    suspend fun getUser(loginName: String): UserHelixResponse =
        UserHelixResponse(httpClient
            .get(BASE_URL) {
                parameter("login", loginName)
            })


    suspend fun getUsers(ids: Collection<Long>? = null, loginNames: Collection<String>? = null): UsersHelixResponse {
        if (ids.isNullOrEmpty() && loginNames.isNullOrEmpty()) {
            throw BadRequestException("Must provide at least one ID, Login or OAuth Token.")
        }
        return UsersHelixResponse(
            httpClient
                .get(BASE_URL) {
                    ids?.forEach {
                        parameter("id", it)
                    }
                    loginNames?.forEach {
                        parameter("login", it)
                    }
                }, httpClient
        )
    }

    suspend fun getUserFollowers(
        fromUserId: Long? = null,
        toUserId: Long? = null,
        first: Int? = 100
    ): FollowsHelixResponse {
        if (fromUserId == null && toUserId == null) {
            throw BadRequestException("Must provide either a from ID or to ID")
        }
        return FollowsHelixResponse(
            httpClient
                .get("$BASE_URL/follows") {
                    parameter("from_id", fromUserId)
                    parameter("to_id", toUserId)
                    parameter("first", first)
                }, httpClient
        )
    }

    suspend fun createFollow(fromId: Long, toId: Long, allowNotifications: Boolean = false) = httpClient.post<HttpResponse>("${BASE_URL}/follows") {
        contentType(ContentType.Application.Json)
        body = ChangeFollowRequest(fromId, toId, allowNotifications)
    }

    suspend fun deleteFollow(fromId: Long, toId: Long) = httpClient.delete<HttpResponse>("${BASE_URL}/follows") {
        contentType(ContentType.Application.Json)
        body = ChangeFollowRequest(fromId, toId)
    }

    // TODO#29: add user:edit req
    suspend fun updateUserDescription(description: String): UserHelixResponse =
        UserHelixResponse(httpClient.put(BASE_URL) {
            parameter("description", description)
        })

    // TODO#29: add user:read:broadcast req
    suspend fun getUserExtensions(): ExtensionsHelixResponse =
        ExtensionsHelixResponse(httpClient.get("$BASE_URL/extensions/list"))

    // TODO#28 : Get user active extensions (auth = user:read:broadcast or user:edit:broadcast)
    //    suspend fun getUserActiveExtensions(): HelixResponse<Extension> =
    //        httpClient.get("$BASE_URL/extensions")

    // TODO#28: Update user extensions (auth=user:edit:broadcast)

}