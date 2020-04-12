package helix.service

import helix.configuration.ApiSettings
import helix.exceptions.BadRequestException
import helix.generic.HelixResponse
import helix.model.User
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class UserService(
    apiSettings: ApiSettings, httpClientConfig: HttpClientEngineConfig
) : ResourceService(apiSettings, httpClientConfig) {

    suspend fun getUser(userId: Long): User? {
        return httpClient
            .get<HelixResponse<User>>("https://api.twitch.tv/helix/users") {
                parameter("id", userId)
            }
            .data.firstOrNull()
    }

    suspend fun getUser(loginName: String): User? {
        return httpClient
            .get<HelixResponse<User>>("https://api.twitch.tv/helix/users") {
                parameter("login", loginName)
            }
            .data.firstOrNull()
    }

    suspend fun getUsers(ids: Collection<Long>? = null, loginNames: Collection<String>? = null): Collection<User> {
        try {
            if (ids.isNullOrEmpty() && loginNames.isNullOrEmpty()) {
                throw BadRequestException("Must provide at least one ID, Login or OAuth Token.")
            }
            return httpClient
                .get<HelixResponse<User>>("https://api.twitch.tv/helix/users") {
                    ids?.forEach {
                        parameter("id", it)
                    }
                    loginNames?.forEach {
                        parameter("login", it)
                    }
                }.data;
        } catch (e: Exception) {
            println(e.message)
        }
        return emptyList()
    }

    // TODO: Update user (auth = user:edit)
    // TODO: Get user extensions (auth = user:read:broadcast)
    // TODO: Get user active extensions (auth = user:read:broadcast or user:edit:broadcast)
    // TODO: Update user extensions (auth=user:edit:broadcast)

//    suspend fun getUserFollowers(fromId: Long? = null, toId: Long? = null, first: Int? = 100): Collection<User> {
//        if(fromId == null && toId == null) {
//            throw BadRequestException("Must provide either a from ID or to ID")
//        }
//        val result: List<User>
//        do {
//
//        } while ()
//        val firstResponse = httpClient
//            .get<HelixResponse<User>>("https://api.twitch.tv/helix/users/follows") {
//                parameter("from_id", fromId)
//                parameter("to_id", toId)
//                parameter("first", first)
//            }
//    }
}