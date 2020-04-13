import helix.auth.AuthService
import helix.auth.model.request.OauthAuthorizeRequestModel
import helix.auth.model.request.OauthRevokeRequestModel
import helix.configuration.DefaultApiCredentials
import helix.configuration.DefaultApiSettings
import helix.service.UserService
import io.ktor.client.engine.apache.ApacheEngineConfig
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.ImplicitReflectionSerializer
import kotlinx.serialization.Properties

@ImplicitReflectionSerializer
fun main() {
    val authService = AuthService(ApacheEngineConfig())
    runBlocking {
        val tokenValidationModel = authService.revokeToken(
            OauthRevokeRequestModel("client-id",
            "auth-token")
        )
        println(tokenValidationModel)
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

