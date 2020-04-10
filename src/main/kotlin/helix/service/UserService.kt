package helix.service

import helix.configuration.IApiSettings
import helix.generic.HelixResponse
import helix.model.User
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.features.json.JsonSerializer
import io.ktor.client.request.get

class UserService(
    apiSettings: IApiSettings, httpClientConfig: HttpClientEngineConfig, jsonSerializer: JsonSerializer
) : ResourceService(apiSettings, httpClientConfig, jsonSerializer) {

    suspend fun getUser(userId: Long): User? {
        return httpClient
            .get<HelixResponse<User>>("https://api.twitch.tv/helix/users?id=$userId")
            .data.firstOrNull()
    }
}