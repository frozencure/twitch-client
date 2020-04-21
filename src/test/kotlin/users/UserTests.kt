package users

import helix.http.credentials.ApiSettings
import helix.users.UserService
import io.ktor.client.engine.mock.MockEngineConfig
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.UnstableDefault
import org.junit.Test
import util.HttpClientMockBuilder

class MockApiSettings() : ApiSettings {
    override val credentials: Map<String, Any?> = mapOf("token" to "randomtokenvalue")
}

@OptIn(UnstableDefault::class)
class UserTests {


    @Test
    fun `test init`() {
        val userService = UserService(MockApiSettings(), MockEngineConfig())
        runBlocking {
            val response = UsersStubEndpoints.withUserWithEmail(userService).getUser()
            assert(response.data.isNotEmpty())
        }

    }
}