import helix.auth.AuthService
import helix.auth.model.AuthScope
import helix.auth.model.request.OauthAuthorizeRequestModel
import helix.bits.BitsService
import helix.clips.ClipService
import helix.extensions.ExtensionService
import helix.games.GameService
import helix.http.credentials.DefaultApiSettings
import helix.http.credentials.OauthApiCredentials
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
                "kyoim5wj84e8m9ujeqa04b8wlyizkg",
                "nyufzvu4k8h80iq0r7ya4zx1fsas7d"
            )
        )
    )
    val extensionsService = ExtensionService(apiSettings, ApacheEngineConfig())
    val bitsService = BitsService(apiSettings, ApacheEngineConfig())
    runBlocking {
        val result = extensionsService.getTransactions("tw-client-test-ext").resources
        print(result)
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

