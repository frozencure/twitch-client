package users

import helix.http.credentials.ApiSettings
import helix.users.UserService
import helix.users.model.User
import io.ktor.client.engine.mock.MockEngineConfig
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.UnstableDefault
import org.junit.Test
import util.HttpClientMockBuilder

class MockApiSettings() : ApiSettings {
    override val credentials: Map<String, Any?> = mapOf("token" to "randomtokenvalue")
}

class UserTests {


    class `Given GET users is called` {
        @Test
        fun `then user is returned`() =
            UsersStubEndpoints.getUserWithEmail {
                assert(it.data.filterIsInstance<User>().count() == 1)
            }

        @Test
        fun `then user has email`() =
            UsersStubEndpoints.getUserWithEmail {
                assert(it.data.first().email != null)
            }
    }


}