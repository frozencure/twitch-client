package helix.users

import helix.auth.model.AuthCredentials
import helix.exceptions.BadRequestException
import helix.extensions.ActiveExtensionsResponse
import helix.extensions.ExtensionsResponse
import helix.extensions.model.active.ActiveExtensions
import helix.http.ResourceService
import helix.users.model.ChangeFollowRequest
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.apache.ApacheEngineConfig
import io.ktor.client.request.*
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.serialization.UnstableDefault

@UnstableDefault
class UserService : ResourceService {

    constructor(credentials: AuthCredentials, engineConfig: HttpClientEngineConfig = ApacheEngineConfig())
            : super(credentials, engineConfig)

    constructor(httpClient: HttpClient) : super(httpClient)

    companion object {
        const val BASE_URL = "${ResourceService.BASE_URL}/users"
    }

    suspend fun getUser(): UserResponse =
        UserResponse(
            httpClient
                .get(BASE_URL)
        )


    suspend fun getUser(userId: Long): UserResponse =
        UserResponse(httpClient
            .get(BASE_URL) {
                parameter("id", userId)
            })


    suspend fun getUser(loginName: String): UserResponse =
        UserResponse(httpClient
            .get(BASE_URL) {
                parameter("login", loginName)
            })


    suspend fun getUsers(ids: Collection<Long>? = null, loginNames: Collection<String>? = null): UsersResponse {
        if (ids.isNullOrEmpty() && loginNames.isNullOrEmpty()) {
            throw BadRequestException("Must provide at least one ID, Login or OAuth Token.")
        }
        return UsersResponse(
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
    ): FollowsResponse {
        if (fromUserId == null && toUserId == null) {
            throw BadRequestException("Must provide either a from ID or to ID")
        }
        return FollowsResponse(
            httpClient
                .get("$BASE_URL/follows") {
                    parameter("from_id", fromUserId)
                    parameter("to_id", toUserId)
                    parameter("first", first)
                }, httpClient
        )
    }

    suspend fun createFollow(fromId: Long, toId: Long, allowNotifications: Boolean = false) =
        httpClient.post<HttpResponse>("${BASE_URL}/follows") {
            contentType(ContentType.Application.Json)
            body = ChangeFollowRequest(fromId, toId, allowNotifications)
        }

    suspend fun deleteFollow(fromId: Long, toId: Long) = httpClient.delete<HttpResponse>("${BASE_URL}/follows") {
        contentType(ContentType.Application.Json)
        body = ChangeFollowRequest(fromId, toId)
    }

    suspend fun updateUserDescription(description: String): UserResponse =
        UserResponse(httpClient.put(BASE_URL) {
            parameter("description", description)
        })

    suspend fun getUserExtensions(): ExtensionsResponse =
        ExtensionsResponse(httpClient.get("$BASE_URL/extensions/list"))


    suspend fun getUserActiveExtensions(userId: Long? = null) = ActiveExtensionsResponse(
        httpClient.get("$BASE_URL/extensions") {
            userId?.let { parameter("user_id", userId) }
        }
    )

    suspend fun updateActiveUserExtensions(activeExtensions: ActiveExtensions) = ActiveExtensionsResponse(
        httpClient.put("$BASE_URL/extensions") {
            contentType(ContentType.Application.Json)
            body = activeExtensions
        }
    )
}