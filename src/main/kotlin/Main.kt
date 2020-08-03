import helix.auth.AuthService
import helix.auth.model.AuthScope
import helix.auth.model.request.OauthAuthorizeRequestModel
import helix.channels.ChannelService
import helix.http.credentials.DefaultApiSettings
import helix.http.credentials.OauthApiCredentials
import helix.moderation.ModerationService
import helix.users.UserService
import io.ktor.client.engine.apache.ApacheEngineConfig
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.ImplicitReflectionSerializer
import kotlinx.serialization.Properties
import kotlinx.serialization.UnstableDefault

@OptIn(UnstableDefault::class)
@ImplicitReflectionSerializer
fun main() {
//    authenticateUser()
    val apiSettings = DefaultApiSettings(
        Properties.store(
            OauthApiCredentials(
                "r86kdnn8k2mgulewhrlnvktq997nev",
                "nyufzvu4k8h80iq0r7ya4zx1fsas7d"
            )
        )
    )
    val moderationService = ModerationService(apiSettings, ApacheEngineConfig())
    val userService = UserService(apiSettings, ApacheEngineConfig())
    val channelService = ChannelService(apiSettings, ApacheEngineConfig())
    runBlocking {
        val currentUser = userService.getUser().resource
        val to = channelService.getChannels("Nmplol").resources.first().id
        currentUser?.let {
            val result = userService.deleteFollow(currentUser.id, to)
            print(result)
        }
    }

}


@ImplicitReflectionSerializer
fun authenticateUser() {
    val requestModel = OauthAuthorizeRequestModel(
        "nyufzvu4k8h80iq0r7ya4zx1fsas7d", // client-id
        "http://localhost", // redirect-URI
        "token", // response type
        AuthScope.values().toList()
    )
    val authService = AuthService(ApacheEngineConfig())
    runBlocking {
        val response = authService.authorizeAppForUser(requestModel)
        println(response)
    }
}

