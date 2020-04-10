import helix.configuration.DefaultApiSettings
import helix.service.UserService
import io.ktor.client.engine.apache.ApacheEngineConfig
import io.ktor.client.features.json.serializer.KotlinxSerializer
import kotlinx.coroutines.runBlocking

fun main() {
    val userService = UserService(DefaultApiSettings(), ApacheEngineConfig(), KotlinxSerializer())
    runBlocking {
        println(
            userService.getUsers(
                listOf(44322889, 44322888),
                listOf("frozencure")
            ).toString()
        )
    }
}