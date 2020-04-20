import helix.auth.AuthService
import helix.auth.model.request.OauthAuthorizeRequestModel
import helix.configuration.ApiSettings
import helix.configuration.DefaultApiCredentials
import helix.configuration.DefaultApiSettings
import helix.configuration.OauthApiCredentials
import helix.service.UserService
import io.ktor.client.engine.apache.Apache
import io.ktor.client.engine.apache.ApacheEngineConfig
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.ImplicitReflectionSerializer
import kotlinx.serialization.Properties
import kotlinx.serialization.UnstableDefault

@OptIn(UnstableDefault::class)
@ImplicitReflectionSerializer
fun main() {
    val credentials = OauthApiCredentials("5a7ojxw3ldo6eu1gutwievwxuz8x3j")
    val userService = UserService(
        DefaultApiSettings(
            Properties.store(credentials)
        ), ApacheEngineConfig()
    )
    runBlocking {
        val response = userService.getUser()
        val user = response.data.first()
        println(userService.updateUserDescription("Test"))
    }

}

