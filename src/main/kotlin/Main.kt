import helix.auth.AuthService
import helix.auth.model.AuthScope
import helix.auth.model.request.OauthAuthorizeRequestModel
import helix.clips.ClipService
import helix.http.credentials.DefaultApiSettings
import helix.http.credentials.OauthApiCredentials
import helix.users.UserService
import io.ktor.client.engine.apache.ApacheEngineConfig
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.ImplicitReflectionSerializer
import kotlinx.serialization.Properties
import kotlinx.serialization.UnstableDefault
import java.time.Instant
import java.time.temporal.ChronoUnit

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
    val clipService = ClipService(apiSettings, ApacheEngineConfig())
    val userService = UserService(apiSettings, ApacheEngineConfig())
    runBlocking {
        val clips =
            clipService.getClipsByBroadcaster(
                71092938,
                startedAt = Instant.now().minus(1, ChronoUnit.DAYS),
                endedAt = Instant.now().minus(1, ChronoUnit.DAYS).plusSeconds(3600)
            )
        println(clips.data)
//        val user = userService.getUser("xqcow")
//        println(user.resource)
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

