import helix.auth.AuthService
import helix.auth.model.AuthScope
import helix.auth.model.request.OauthAuthorizeRequestModel
import helix.bits.BitsService
import helix.clips.ClipService
import helix.extensions.ExtensionService
import helix.games.GameService
import helix.http.credentials.DefaultApiSettings
import helix.http.credentials.OauthApiCredentials
import helix.moderation.ModerationService
import helix.moderation.model.AutoModMessage
import helix.streams.StreamService
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
                "qb1jtzk17wvcd1fwcbkcr4ckiroezm",
                "nyufzvu4k8h80iq0r7ya4zx1fsas7d"
            )
        )
    )
    val moderationService = ModerationService(apiSettings, ApacheEngineConfig())
    val userService = UserService(apiSettings, ApacheEngineConfig())
    runBlocking {
        val currentUser = userService.getUser().resource
        currentUser?.let {
            val result = moderationService.checkMessagesWithAutoMod(
                currentUser.id, listOf(
                    AutoModMessage("12", "test message", currentUser.id),
                    AutoModMessage("23", "fuck", currentUser.id)
                )
            )
            print(result.resources)
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

