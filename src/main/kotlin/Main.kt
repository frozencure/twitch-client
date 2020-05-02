import helix.http.credentials.DefaultApiSettings
import helix.http.credentials.OauthApiCredentials
import helix.users.UserService
import helix.users.model.User
import io.ktor.client.engine.apache.ApacheEngineConfig
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.ImplicitReflectionSerializer
import kotlinx.serialization.Properties
import kotlinx.serialization.UnstableDefault

@OptIn(UnstableDefault::class)
@ImplicitReflectionSerializer
fun main() {
    val userService = UserService(
        DefaultApiSettings(
            Properties.store(OauthApiCredentials("5a7ojxw3ldo6eu1gutwievwxuz8x3j"))
        ), ApacheEngineConfig()
    )
    runBlocking {
        println(userService.getUser("frozencure").resource.toString())
    }

}

