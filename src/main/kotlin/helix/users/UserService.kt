package helix.users

import helix.http.credentials.ApiSettings
import helix.exceptions.BadRequestException
import helix.http.model.HelixResponse
import helix.extensions.model.Extension
import helix.users.model.FollowEvent
import helix.http.ResourceService
import helix.users.model.User
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.put
import kotlinx.serialization.UnstableDefault

@UnstableDefault
class UserService(
    apiSettings: ApiSettings, httpClientConfig: HttpClientEngineConfig
) : ResourceService(apiSettings, httpClientConfig) {

    companion object {
        const val BASE_URL = "${ResourceService.BASE_URL}/users"
    }

    suspend fun getUser(): HelixResponse<User> =
        httpClient
            .get(BASE_URL)


    suspend fun getUser(userId: Long): HelixResponse<User> =
        httpClient
            .get(BASE_URL) {
                parameter("id", userId)
            }


    suspend fun getUser(loginName: String): HelixResponse<User> =
        httpClient
            .get(BASE_URL) {
                parameter("login", loginName)
            }


    suspend fun getUsers(ids: Collection<Long>? = null, loginNames: Collection<String>? = null): HelixResponse<User> {
        if (ids.isNullOrEmpty() && loginNames.isNullOrEmpty()) {
            throw BadRequestException("Must provide at least one ID, Login or OAuth Token.")
        }
        return httpClient
            .get(BASE_URL) {
                ids?.forEach {
                    parameter("id", it)
                }
                loginNames?.forEach {
                    parameter("login", it)
                }
            }
    }

    suspend fun getUserFollowers(
        fromUserId: Long? = null,
        toUserId: Long? = null,
        first: Int? = 20
    ): HelixResponse<FollowEvent> {
        if (fromUserId == null && toUserId == null) {
            throw BadRequestException("Must provide either a from ID or to ID")
        }
        return httpClient
            .get("$BASE_URL/follows") {
                parameter("from_id", fromUserId)
                parameter("to_id", toUserId)
                parameter("first", first)
            }
    }

    // TODO#29: add user:edit req
    suspend fun updateUserDescription(description: String): HelixResponse<User> =
        httpClient.put(BASE_URL) {
            parameter("description", description)
        }

    // TODO#29: add user:read:broadcast req
    suspend fun getUserExtensions(): HelixResponse<Extension> =
        httpClient.get("$BASE_URL/extensions/list")

    // TODO#28 : Get user active extensions (auth = user:read:broadcast or user:edit:broadcast)
    //    suspend fun getUserActiveExtensions(): HelixResponse<Extension> =
    //        httpClient.get("$BASE_URL/extensions")

    // TODO#28: Update user extensions (auth=user:edit:broadcast)

}