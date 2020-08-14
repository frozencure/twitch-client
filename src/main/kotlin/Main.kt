import helix.auth.AuthService
import helix.auth.model.AuthCredentials
import helix.auth.model.AuthScope
import helix.auth.model.OAuthCredentials
import helix.auth.model.request.OauthAppTokenRequestModel
import helix.auth.model.request.OauthUserTokenRequestModel
import helix.games.GameService
import helix.streams.StreamService
import helix.users.UserService
import io.ktor.client.engine.apache.ApacheEngineConfig
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.ImplicitReflectionSerializer
import kotlinx.serialization.UnstableDefault

@OptIn(UnstableDefault::class)
@ImplicitReflectionSerializer
fun main() {
    // app access token = 4j4u933wfyaayp71pxilgqrva7693c
    // user access token = 7omkmgbiz7ynbx5cwxod8263tysjmu
//    authenticateUser()
//    authenticateApp()
//    val credentials = AuthCredentials("nyufzvu4k8h80iq0r7ya4zx1fsas7d")
    val credentials = OAuthCredentials("4j4u933wfyaayp71pxilgqrva7693c", "nyufzvu4k8h80iq0r7ya4zx1fsas7d")
    val streamService = StreamService(credentials)
    val userService = UserService(credentials)
    val gameService = GameService(credentials)
    runBlocking {
        print(gameService.getGames("league of leg").resources)
    }

}


@ImplicitReflectionSerializer
fun authenticateUser() {
    val requestModel = OauthUserTokenRequestModel(
        "nyufzvu4k8h80iq0r7ya4zx1fsas7d", // client-id
        "http://localhost", // redirect-URI
        "token", // response type
        AuthScope.values().toList()
    )
    val authService = AuthService(ApacheEngineConfig())
    runBlocking {
        val response = authService.requestUserToken(requestModel)
        println(response)
    }
}

@ImplicitReflectionSerializer
fun authenticateApp() {
    val requestModel = OauthAppTokenRequestModel(
        "nyufzvu4k8h80iq0r7ya4zx1fsas7d",
        "hipf2vcom91i3kj177adosfwg7xqzw",
        AuthScope.values().toList()
    )
    val authService = AuthService(ApacheEngineConfig())
    runBlocking {
        val response = authService.requestAppToken(requestModel)
        println(response)
    }

}

