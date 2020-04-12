import helix.auth.AuthService
import helix.auth.model.request.OauthAuthorizeRequestModel
import io.ktor.client.engine.apache.ApacheEngineConfig
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.ImplicitReflectionSerializer

@ImplicitReflectionSerializer
fun main() {
    val authService = AuthService(ApacheEngineConfig())
    runBlocking {
        val response = authService.authorizeApplicationForUser(OauthAuthorizeRequestModel())
        println(response)
    }
//    val userService = UserService(
//        DefaultApiSettings(
//            Properties.store(DefaultApiCredentials("nyufzvu4k8h80iq0r7ya4zx1fsas7d"))
//        ), ApacheEngineConfig()
//    )
//    runBlocking {
//        println(
//            userService.getUsers(
//                listOf(44322889, 44322888),
//                listOf("frozencure")
//            ).toString()
//        )
//    }
}

