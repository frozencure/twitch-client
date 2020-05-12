import helix.auth.AuthService
import helix.auth.model.AuthScope
import helix.auth.model.request.OauthAuthorizeRequestModel
import helix.http.credentials.DefaultApiSettings
import helix.http.credentials.OauthApiCredentials
import helix.users.UserService
import helix.videos.VideoService
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
                "kyoim5wj84e8m9ujeqa04b8wlyizkg",
                "nyufzvu4k8h80iq0r7ya4zx1fsas7d"
            )
        )
    )
    val userService = UserService(apiSettings, ApacheEngineConfig())
    val videoService = VideoService(apiSettings, ApacheEngineConfig())
    runBlocking {
        val user = userService.getUser("xQcOW").resource
        val videos = user?.id?.let { videoService.getVideosByUser(it) }

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

